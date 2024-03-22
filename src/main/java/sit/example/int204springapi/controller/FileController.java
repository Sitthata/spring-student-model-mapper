package sit.example.int204springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.example.int204springapi.properties.FileStorageProperties;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {
    private final FileStorageProperties fileStorageProperties;
    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(fileStorageProperties.getUploadDir());
    }
}
