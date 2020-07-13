package by.shopproject.entity;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Color {

    RED("Red"),
    YELLOW("Yellow"),
    BLACK("Black"),
    ORANGE("Orange"),
    WHITE("White"),
    BROWN("Brown"),
    BLUE("Blue");

    private String description;

    Color(String description) {
        this.description = description;
    }

    public static Color getByName(String name) {
        return Arrays.stream(values())
                .filter(it -> it.getDescription().equals(name))
                .findFirst()
                .orElse(null);
    }
}
