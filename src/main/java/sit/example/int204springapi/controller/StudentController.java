package sit.example.int204springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.example.int204springapi.dto.StudentDTO;
import sit.example.int204springapi.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;
    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> get() {
        return ResponseEntity.ok(service.getAllStudent());
    }

    @PostMapping("/add-student")
    public ResponseEntity<StudentDTO> add(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(service.addStudent(studentDTO));
    }
}
