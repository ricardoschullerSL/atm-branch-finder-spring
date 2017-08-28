package ATMBranchFinderSpring.controllers;

import ATMBranchFinderSpring.models.Bank;
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
    BankController(BankRepo bankRepo) { this.bankRepo = bankRepo; }

    @RequestMapping(method = RequestMethod.GET, value = "/banks", produces = "application/json")
    public Collection<Bank> allBanks() {return bankRepo.GetAll(); }

    @RequestMapping(method = RequestMethod.GET, value = "/banks/{bankId}", produces = "application/json")
    public Bank getBankById(@PathVariable String bankId) {
        Bank bank = bankRepo.FindByBankId(bankId);
        if (bank == null) throw new BankNotFoundException();

        return bank;
    }
}
