package product.star.model;

import java.util.stream.Stream;

public enum Distance {
    ONE_KM("1 km"),
    TWO_KM("2 km"),
    TEN_KM("10 km"),
    MARATHON("42 km");


    private final String dist;

    Distance(String dist) {
        this.dist = dist;
    }

    public static Distance getDistance(String value) {
        return Stream.of(values()).filter(x -> x.dist.equals(value)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such distance " + value));
    }
}
