package ATMBranchFinderSpring;

import ATMBranchFinderSpring.models.*;
import ATMBranchFinderSpring.repos.ATMRepo;
import ATMBranchFinderSpring.repos.BankRepo;
import ATMBranchFinderSpring.services.GetEndPointDataService;
import ATMBranchFinderSpring.services.SetEndPointDataService;
import ATMBranchFinderSpring.services.SetUpBanks;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
    public CommandLineRunner run(RestTemplate restTemplate, BankRepo bankRepo, ATMRepo atmRepo) throws Exception {
        return args -> {

            initialSetup(restTemplate, bankRepo, atmRepo);
        };
    }

    private void initialSetup(RestTemplate restTemplate, BankRepo bankRepo, ATMRepo atmRepo) {
        SetUpBanks bankSetter = new SetUpBanks();
        ArrayList<Bank> banks = bankSetter.getBanks();

        for (Bank bank : banks) {
            new GetEndPointDataService(restTemplate, bank).execute();
            new SetEndPointDataService(bank).execute();
        }

        bankRepo.setAllBanks(banks);
        atmRepo.setAllATMs(banks);

    }
}
