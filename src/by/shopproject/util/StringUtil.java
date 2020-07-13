package by.shopproject.util;

import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class StringUtil {

    private final String EMPTY = "";

    public boolean isEmpty(String value) {
        return Objects.isNull(value) || EMPTY.equals(value.trim());
    }
}
