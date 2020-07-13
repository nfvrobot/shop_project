package by.shopproject.dto;

import by.shopproject.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuitarBuyDto {

    private Integer customer_id;
    private Integer guitar_id;
    private Status status;
}
