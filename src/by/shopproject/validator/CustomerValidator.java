package by.shopproject.validator;

import by.shopproject.dto.CreateNewCustomerDto;
import by.shopproject.util.StringUtil;

public class CustomerValidator implements Validator<CreateNewCustomerDto> {

    @Override
    public boolean isValid(CreateNewCustomerDto customerDto) {

        return StringUtil.isEmpty(customerDto.getFirstName()) &&
                StringUtil.isEmpty(customerDto.getLastName()) &&
                StringUtil.isEmpty(customerDto.getEmail()) &&
                StringUtil.isEmpty(customerDto.getPassword()) &&
                StringUtil.isEmpty(customerDto.getPhone()) &&
                StringUtil.isEmpty(customerDto.getAddress());
    }
}
