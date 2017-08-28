package ATMBranchFinderSpring.repos;

import ATMBranchFinderSpring.models.Bank;

import java.util.ArrayList;

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
