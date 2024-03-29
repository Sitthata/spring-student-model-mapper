package sit.example.int204springapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private String customerName;
    private String phone;
    private String city;
    private String country;
    @JsonIgnore
    private EmployeeDTO salesRepEmployee;

    public String getSalesRepName() {
        return salesRepEmployee == null ? "-" : salesRepEmployee.getName();
    }

}
