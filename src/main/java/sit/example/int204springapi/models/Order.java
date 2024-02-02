package sit.example.int204springapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @Column(name = "orderNumber")
    private Integer id;

    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private String status;
    private String comments;
    private Integer customerNumber;
}
