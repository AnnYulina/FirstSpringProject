package product.star.model;

import java.util.stream.Stream;

public enum Gender {
    MALE("M"), FEMALE("F");
    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender getGender(String value) {
        return Stream.of(values()).filter(x -> x.value.equals(value)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such gender " + value));
    }
}
