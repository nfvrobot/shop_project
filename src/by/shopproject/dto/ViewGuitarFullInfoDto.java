package by.shopproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewGuitarFullInfoDto {

    private Integer fabricId;
    private String fabricName;
    private String fabricCountry;
    private String name;
    private Short strings;
    private String colorName;
    private Integer count;

}
