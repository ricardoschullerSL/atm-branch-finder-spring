package ATMBranchFinderSpring.controllers;

import ATMBranchFinderSpring.models.ATM;
import ATMBranchFinderSpring.models.Bank;
import ATMBranchFinderSpring.models.Branch;
import ATMBranchFinderSpring.models.PCA;
import ATMBranchFinderSpring.repos.BankRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BankController {

    private BankRepo bankRepo;

    @Autowired
    public BankController(BankRepo bankRepo) { this.bankRepo = bankRepo; }

    @RequestMapping(method = RequestMethod.GET, value = "/banks", produces = "application/json")
    public Collection<Bank> allBanks() {return bankRepo.GetAll(); }

    @RequestMapping(method = RequestMethod.GET, value = "/banks/{bankId}", produces = "application/json")
    public Bank getBankById(@PathVariable String bankId) {
        Bank bank = bankRepo.FindByBankId(bankId);
        if (bank == null) throw new BankNotFoundException();

        return bank;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/banks/{bankId}/atms", produces = "application/json")
    public Collection<ATM> getATMsByBankId(@PathVariable String bankId) {
        Bank bank = bankRepo.FindByBankId(bankId);
        if (bank == null) throw new BankNotFoundException();

        return bank.getAtms();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/banks/{bankId}/branches", produces = "application/json")
    public Collection<Branch> getBranchesByBankId(@PathVariable String bankId) {
        Bank bank = bankRepo.FindByBankId(bankId);
        if (bank == null) throw new BankNotFoundException();

        return bank.getBranches();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/banks/{bankId}/branches/city/{cityName}", produces = "application/json")
    public Collection<Branch> getBranchesByBankIdAndCity(@PathVariable String bankId, @PathVariable String cityName) {
        Bank bank = bankRepo.FindByBankId(bankId);
        if (bank == null) throw new BankNotFoundException();
        Collection<Branch> branches = bankRepo.GetBranchesByBankIdAndCityName(bankId, cityName);
        return bank.getBranches();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/banks/{bankId}/pca", produces = "application/json")
    public Collection<PCA> getPCAsByBankId(@PathVariable String bankId) {

        Bank bank = bankRepo.FindByBankId(bankId);
        if (bank == null) throw new BankNotFoundException();

        return bank.getPcas();
    }

}
