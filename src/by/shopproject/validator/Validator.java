package by.shopproject.validator;

public interface Validator<T> {

    boolean isValid(T object);
}
