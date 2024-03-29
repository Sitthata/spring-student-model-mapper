package sit.example.int204springapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private String firstName;
    private String lastName;

    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }
}
