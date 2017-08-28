package ATMBranchFinderSpring.repos;

import ATMBranchFinderSpring.models.ATM;
import ATMBranchFinderSpring.models.Bank;


import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class ATMRepo implements Repository<ATM> {

    private ArrayList<ATM> atms;

    public ATMRepo() {
        atms = new ArrayList<ATM>();
    };

    public void SetAllATMs(ArrayList<Bank> banks) {
        atms = new ArrayList<ATM>();
        for (Bank bank : banks) {
            atms.addAll(bank.getAtms());
        }
        System.out.format("%d number of ATMS set.%n", atms.size());
    }

    @Override
    public ATM Get(int id) {
        return atms.get(id);
    }

    @Override
    public List<ATM> GetAll() {
        return atms;
    }

    @Override
    public void Add(ATM entity) {
        atms.add(entity);
    }

    @Override
    public void Remove(int id) {
        atms.remove(id);
    }


    public List<ATM> FindByCity(String city) {
        List<ATM> filteredAtms = new ArrayList<ATM>();
        for (ATM atm : atms) {
            if (atm.getAddress().getTownName() == null) {
                continue;
            }
            if (atm.getAddress().getTownName().toUpperCase().equals(city.toUpperCase())) {
                filteredAtms.add(atm);
            }
        }
        return filteredAtms;
    }
}
