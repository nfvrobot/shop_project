package by.shopproject.validator;

import by.shopproject.dto.CreateNewGuitarDto;
import by.shopproject.dto.ViewGuitarFullInfoDto;
import by.shopproject.util.StringUtil;

public class GuitarValidator implements Validator<CreateNewGuitarDto> {

    @Override
    public boolean isValid(CreateNewGuitarDto guitar) {
        return StringUtil.isEmpty(String.valueOf(guitar.getFabricId())) &&
                StringUtil.isEmpty(guitar.getName()) &&
                StringUtil.isEmpty(String.valueOf(guitar.getStrings())) &&
                StringUtil.isEmpty(String.valueOf(guitar.getCount()));
    }
}
