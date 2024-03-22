package sit.example.int204springapi.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sit.example.int204springapi.properties.FileStorageProperties;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Getter
public class FileService {

    private final Path fileStorageLocation;

    @Autowired
    public FileService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            if(!Files.exists(this.fileStorageLocation)) {
                Files.createDirectories(this.fileStorageLocation);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//        String fileTest;
         try {
             if (fileName.contains("..")) {
                 throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
             }
             Path targetLocation = this.fileStorageLocation.resolve(fileName);
             Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
             return fileName;
         } catch (IOException ex) {
             throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
         }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (!resource.exists()) {
                throw new RuntimeException("File not found");
            }
            return resource;
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File operation error", ex);
        }
    }

    public void removeResource(String filename) {
        try {
            Path filePath = this.fileStorageLocation.resolve(filename).normalize();
            if (!Files.exists(filePath)) {
                throw new RuntimeException("File not found " + filename);
            }
            Files.delete(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
