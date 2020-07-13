package by.shopproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewCustomerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
}
