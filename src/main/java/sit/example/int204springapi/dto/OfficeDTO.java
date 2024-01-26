package sit.example.int204springapi.dto;

import lombok.Data;

@Data
public class OfficeDTO {
    private Integer id;
    private String city;
    private String phone;
//    private List<EmployeeDTO> employeeList = new ArrayList<>();
}
