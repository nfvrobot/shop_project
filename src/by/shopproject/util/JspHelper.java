package by.shopproject.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {
    private final String PREFIX = "/WEB-INF/jsp/";
    private final String SUFFIX = ".jsp";


    public String getPath(String pageName) {
        return PREFIX + pageName + SUFFIX;
    }
}
