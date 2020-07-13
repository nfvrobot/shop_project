package by.shopproject.entity;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guitar {

    private Integer id;
    private Fabric fabric;
    private String name;
    private Short strings;
    private Color color;
    private Integer count;
}
