package sit.example.int204springapi.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Employee {
    @Id
    @Column(name = "employeeNumber")
    private Integer id;
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JsonIgnoreProperties("employeeList")
//    @JsonIgnore
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode")
    private Office office;

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "reportsTo")
    private Employee manager;

    @Column(name = "jobTitle")
    private String jobTitle;
}
