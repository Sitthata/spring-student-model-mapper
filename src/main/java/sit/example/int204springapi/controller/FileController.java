package sit.example.int204springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sit.example.int204springapi.properties.FileStorageProperties;
import sit.example.int204springapi.service.FileService;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {
    private final FileStorageProperties fileStorageProperties;
    private final FileService fileService;

    @PostMapping("")
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return ResponseEntity.ok(String.format("File %s uploaded successfully", file.getOriginalFilename()));
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileService.loadFileAsResource(filename);
        String extension = filename.substring(filename.lastIndexOf('.'));
        MediaType extensionType = extension.equals("png") ? MediaType.IMAGE_PNG : MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(extensionType).body(file);
    }

    @GetMapping("test")
    public ResponseEntity<Object> test() {
        return ResponseEntity.ok(fileStorageProperties);
    }
}
