package sit.example.int204springapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sit.example.int204springapi.dto.StudentDTO;
import sit.example.int204springapi.models.Student;
import sit.example.int204springapi.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final ModelMapper modelMapper;

    public List<StudentDTO> getAllStudent() {
        List<Student> students = repository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class)).toList();
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        repository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

}
