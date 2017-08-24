package ATMBranchFinderSpring.repos;

import ATMBranchFinderSpring.models.Bank;

import java.util.ArrayList;


public class BankRepo implements Repository<Bank> {

    private ArrayList<Bank> banks;
    @Override
    public Bank Get(int id) {
        return banks.get(id);
    }
    @Override
    public ArrayList<Bank> GetAll() {
        return banks;
    }
    @Override
    public void Add(Bank bank) {
        banks.add(bank);
    }
    @Override
    public void Remove(int id) {
        banks.remove(id);
    }

}
