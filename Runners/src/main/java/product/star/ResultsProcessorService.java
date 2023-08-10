package product.star;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.star.model.Distance;
import product.star.model.Gender;
import product.star.model.Run;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultsProcessorService implements ResultsProcessor {

    private final CSVParser parser;
    private List<Run> runs;

    @Autowired
    public ResultsProcessorService(CSVParser parser) {
        this.parser = parser;
    }

    @Override
    public void loadRunResults(String fileName) {
        runs = parser.loadRuns(fileName);
    }

    @Override
    public List<String> getFastest(int count, Gender gender, Distance distance) {
        return runs.stream().filter(r -> r.distance().equals(distance)).filter(r -> r.runner().gender().equals(gender))
                .sorted(Comparator.comparingInt(Run::time).reversed()).limit(count).map(r -> r.runner().name()).collect(Collectors.toList());
    }
}
