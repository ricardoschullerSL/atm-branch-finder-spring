package ATMBranchFinderSpring.services;

import ATMBranchFinderSpring.models.Bank;
import ATMBranchFinderSpring.repos.BankRepo;

import java.util.ArrayList;

public class GetBankDataService implements Service {

    private String name;
    private BankRepo bankRepo;
    private ArrayList<Bank> banks;

    public GetBankDataService(BankRepo bankRepo) {
        this.name = "GetBankDataService";
        this.bankRepo = bankRepo;
        this.banks = bankRepo.getAll();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {



    }
}
