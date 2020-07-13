package by.shopproject.dto;

import by.shopproject.entity.Customer;
import by.shopproject.entity.Guitar;
import by.shopproject.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewOrderInfoDto {

    private Integer customerId;
    private Integer guitarId;
    private Integer count;
    private Date datePlaced;
    private Status status;

}
