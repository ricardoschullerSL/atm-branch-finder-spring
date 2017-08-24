package ATMBranchFinderSpring;

import ATMBranchFinderSpring.models.*;
import ATMBranchFinderSpring.services.GetEndPointDataService;
import ATMBranchFinderSpring.services.SetUpBanks;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;

@SpringBootApplication
public class Application {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {

            InitialSetup(restTemplate);
        };
    }

    private void InitialSetup(RestTemplate restTemplate) {
        SetUpBanks bankSetter = new SetUpBanks();
        ArrayList<Bank> banks = bankSetter.getBanks();

        for (Bank bank : banks) {
            new GetEndPointDataService(restTemplate, bank).execute();
        }

    }
}
