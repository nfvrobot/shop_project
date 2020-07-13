package by.shopproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
}
