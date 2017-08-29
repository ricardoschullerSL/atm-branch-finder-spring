package ATMBranchFinderSpring.repos;

import ATMBranchFinderSpring.models.Bank;
import ATMBranchFinderSpring.models.Branch;

import java.util.ArrayList;
import java.util.Collection;

@org.springframework.stereotype.Repository
public class BankRepo implements Repository<Bank> {

    private ArrayList<Bank> banks;

    public BankRepo() {
        banks = new ArrayList<Bank>();
    }

    public void SetAllBanks(ArrayList<Bank> banks) {
        this.banks = banks;
        System.out.format("%d number of banks set. %n", banks.size() );
    }

    @Override
    public Bank Get(int id) {
        return banks.get(id);
    }
    public Bank FindByBankId(String bankId) {
        for (Bank bank: banks) {
            if (bank.getBankId().toUpperCase().equals(bankId.toUpperCase())) {
                return bank;
            }
        }
        return null;
    }
    public Collection<Branch> GetBranchesByBankIdAndCityName(String bankId, String cityName) {
        Bank bank = FindByBankId(bankId);
        if (bank == null) return null;
        Collection<Branch> branches = new ArrayList<Branch>();
        for (Branch branch: bank.getBranches()) {
            String townName = branch.getAddress().getTownName() != null ? branch.getAddress().getTownName() : "cityName";
            if (townName.toUpperCase().equals(cityName.toUpperCase())) {
                branches.add(branch);
            }
        }
        return branches;
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
