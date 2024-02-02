package sit.example.int204springapi.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "offices")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Office {
    @Id
    @Column(name = "officeCode", nullable = false)
    private Integer id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone", nullable = false)
    private String phone;

    @JsonIgnoreProperties("office")
    @JsonIgnore
    @OneToMany(mappedBy = "office", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employee> employeeList = new ArrayList<>();
}
