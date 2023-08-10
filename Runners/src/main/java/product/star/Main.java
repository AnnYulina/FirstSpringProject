package product.star;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import product.star.config.ResultsProcessorConfiguration;
import product.star.model.Distance;
import product.star.model.Gender;

public class Main {
    public static void main(String[] args) {
        var fileName = "Runners/src/main/resources/results.csv";
        var appContext = new AnnotationConfigApplicationContext(ResultsProcessorConfiguration.class);
        var resultProcessor = appContext.getBean(ResultsProcessorService.class);
        resultProcessor.loadRunResults(fileName);
        System.out.println(resultProcessor.getFastest(3, Gender.FEMALE, Distance.TEN_KM));


    }
}