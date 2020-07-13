package by.shopproject.entity;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Status {
    OPEN("Open"),
    IN_PROGRESS("In progress"),
    CLOSE("Close");

    private String name;

    Status(String nameStatus) {
        this.name = nameStatus;
    }

    public static Status getByName(String name) {
        return Arrays.stream(values())
                .filter(it -> it.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
