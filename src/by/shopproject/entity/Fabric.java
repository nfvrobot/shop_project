package by.shopproject.entity;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fabric {

    private Integer id;
    private String name;
    private String country;
}
