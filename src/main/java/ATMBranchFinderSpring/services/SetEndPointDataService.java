package ATMBranchFinderSpring.services;

import ATMBranchFinderSpring.models.ATM;
import ATMBranchFinderSpring.models.Bank;
import ATMBranchFinderSpring.models.Branch;
import ATMBranchFinderSpring.models.PCA;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SetEndPointDataService implements Service {

    private String name;
    private Bank bank;

    public SetEndPointDataService(Bank bank) {
        this.name = "SetEndPointDataService";
        this.bank = bank;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        bank.setAtms((ArrayList<ATM>) bank.getEndPointCollections().get(0).getData());
        bank.getEndPointCollections().get(0).setData(null);
        bank.setBranches((ArrayList<Branch>) bank.getEndPointCollections().get(1).getData());
        bank.getEndPointCollections().get(1).setData(null);
        bank.setPcas((ArrayList<PCA>) bank.getEndPointCollections().get(2).getData());
        bank.getEndPointCollections().get(2).setData(null);
    }
}
