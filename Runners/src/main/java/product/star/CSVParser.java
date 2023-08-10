package product.star;

import org.springframework.stereotype.Service;
import product.star.model.Distance;
import product.star.model.Gender;
import product.star.model.Run;
import product.star.model.Runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVParser {
    public List<Run> loadRuns(String fileName) {
        var result = new ArrayList<Run>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                result.add(new Run(new Runner(data[0], Gender.getGender(data[1])), Distance.getDistance(data[2]), parseTime(data[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int parseTime(String time) {
        var timeArray = time.split(":");
        return switch (timeArray.length) {
            case 1 -> Integer.parseInt(timeArray[0]);
            case 2 -> Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
            case 3 ->
                    Integer.parseInt(timeArray[0]) * 3600 + Integer.parseInt(timeArray[1]) * 60 + Integer.parseInt(timeArray[2]);
            default -> throw new IllegalArgumentException("Wrong time format");
        };
    }
}
