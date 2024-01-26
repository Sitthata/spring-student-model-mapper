package sit.example.int204springapi.dto;

import sit.example.int204springapi.models.Office;

public record EmployeeDTO(Integer id,
                          String lastName,

                          String firstName,
                          String extension,
                          String email,
                          Office office,
                          EmployeeDTO manager,
                          String jobTitle) {
}
