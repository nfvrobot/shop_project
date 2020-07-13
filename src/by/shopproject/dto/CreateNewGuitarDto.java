package by.shopproject.dto;

import by.shopproject.entity.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewGuitarDto {

    private Integer fabricId;
    private String name;
    private Short strings;
    private Color color;
    private Integer count;
}
