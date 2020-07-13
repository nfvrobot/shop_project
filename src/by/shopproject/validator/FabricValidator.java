package by.shopproject.validator;

import by.shopproject.dto.FabricDto;
import by.shopproject.util.StringUtil;

public class FabricValidator implements Validator<FabricDto>{

    @Override
    public boolean isValid(FabricDto object) {
        return StringUtil.isEmpty(object.getName()) && StringUtil.isEmpty(object.getCountry());
    }
}
