package by.shopproject.entity;

import lombok.*;

import java.sql.Date;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfo {

    private Integer id;
    private Customer customer;
    private Guitar guitar;
    private Integer count;
    private Date datePlaced;
    private Status status;

}
