package sit.example.int204springapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
        return students.stream().map(this::convertToDTO).toList();
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        repository.save(student);
        return convertToDTO(student);
    }

    private Character calculateGrade(Integer score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    private StudentDTO convertToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .score(student.getScore())
                .grade(calculateGrade(student.getScore()))
                .build();
    }

}
