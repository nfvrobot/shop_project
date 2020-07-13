package by.shopproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewCustomerFullInfoDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
