package ATMBranchFinderSpring.controllers;

import ATMBranchFinderSpring.models.ATM;
import ATMBranchFinderSpring.repos.ATMRepo;
import ATMBranchFinderSpring.repos.BankRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ATMController {

    private final ATMRepo atmRepo;

    @Autowired
    ATMController( ATMRepo atmRepo) {
        this.atmRepo = atmRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/atms",
                    produces="application/json")
    public Collection<ATM> allATMs() {
        return atmRepo.GetAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/atms/{id}")
    public ATM atm(@PathVariable int id) { return atmRepo.Get(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/atms/city/{cityName}", produces="application/json")
    public Collection<ATM> FindAtmsByCity(@PathVariable String cityName) {return atmRepo.FindByCity(cityName); }
}
