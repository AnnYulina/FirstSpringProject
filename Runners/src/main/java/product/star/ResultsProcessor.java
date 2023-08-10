package product.star;

import product.star.model.Distance;
import product.star.model.Gender;

import java.util.List;

public interface ResultsProcessor {
    void loadRunResults(String fileName);

    List<String> getFastest(int count, Gender gender, Distance distance);
}
