package sit.example.int204springapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@Builder
public class Customer {
    @Id
    @Column(name = "customerNumber")
    private Integer id;

    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private BigDecimal creditLimit;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee salesRepEmployee;
}
