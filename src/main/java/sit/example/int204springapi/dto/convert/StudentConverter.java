package sit.example.int204springapi.dto.convert;

import org.hibernate.Internal;
import org.hibernate.boot.model.source.spi.IdentifierSource;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import sit.example.int204springapi.dto.StudentDTO;
import sit.example.int204springapi.models.Student;

public class StudentConverter implements Converter<Student, StudentDTO> {
    @Override
    public StudentDTO convert(MappingContext<Student, StudentDTO> mappingContext) {
        Student source = mappingContext.getSource();

        return StudentDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .score(source.getScore())
                .grade(calculateGrade(source.getScore()))
                .build();
    }

    public Character calculateGrade(Integer score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }
}
