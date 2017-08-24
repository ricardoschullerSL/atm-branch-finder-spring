package ATMBranchFinderSpring.services;

import ATMBranchFinderSpring.models.*;

import java.util.ArrayList;

public class SetUpBanks {

    private ArrayList<Bank> banks;

    public SetUpBanks () {
        banks = new ArrayList<Bank>();
        setup();
    }

    private void setup() {
        ArrayList<EndPointCollection> halifaxEndPointCollections = new ArrayList<EndPointCollection>();
        halifaxEndPointCollections.add(new EndPointCollection("https://api.halifax.co.uk/open-banking/v1.2/atms", ATM.class, new ArrayList<ATM>()));
        halifaxEndPointCollections.add(new EndPointCollection("https://api.halifax.co.uk/open-banking/v1.2/branches", Branch.class, new ArrayList<Branch>()));
        halifaxEndPointCollections.add(new EndPointCollection("https://api.halifax.co.uk/open-banking/v1.2/personal-current-accounts", PCA.class, new ArrayList<PCA>()));
        banks.add(new Bank(0, "Halifax", halifaxEndPointCollections));
        ArrayList<EndPointCollection> barclaysEndPointCollections = new ArrayList<EndPointCollection>();
        barclaysEndPointCollections.add(new EndPointCollection("https://atlas.api.barclays/open-banking/v1.3/atms", ATM.class, new ArrayList<ATM>()));
        barclaysEndPointCollections.add(new EndPointCollection("https://atlas.api.barclays/open-banking/v1.3/branches", Branch.class, new ArrayList<Branch>()));
        barclaysEndPointCollections.add(new EndPointCollection("https://atlas.api.barclays/open-banking/v1.3/personal-current-accounts", PCA.class, new ArrayList<PCA>()));
        banks.add(new Bank( 1, "Barclays", barclaysEndPointCollections));
        ArrayList<EndPointCollection> RBSEndPointCollections = new ArrayList<EndPointCollection>();
        RBSEndPointCollections.add(new EndPointCollection("https://openapi.rbs.co.uk/open-banking/v1.3/atms", ATM.class, new ArrayList<ATM>()));
        RBSEndPointCollections.add(new EndPointCollection("https://openapi.rbs.co.uk/open-banking/v1.3/branches", Branch.class, new ArrayList<Branch>()));
        RBSEndPointCollections.add(new EndPointCollection("https://openapi.rbs.co.uk/open-banking/v1.3/personal-current-accounts", PCA.class, new ArrayList<PCA>()));
        banks.add(new Bank( 2, "RBS", RBSEndPointCollections));
        ArrayList<EndPointCollection> danskeBankEndPointCollections = new ArrayList<EndPointCollection>();
        danskeBankEndPointCollections.add(new EndPointCollection("https://obp-api.danskebank.com/open-banking/v1.2/atms", ATM.class, new ArrayList<ATM>()));
        danskeBankEndPointCollections.add(new EndPointCollection("https://obp-api.danskebank.com/open-banking/v1.2/branches", Branch.class, new ArrayList<Branch>()));
        danskeBankEndPointCollections.add(new EndPointCollection("https://obp-api.danskebank.com/open-banking/v1.2/personal-current-accounts", PCA.class, new ArrayList<PCA>()));
        banks.add(new Bank( 3, "Danske Bank", danskeBankEndPointCollections));
        ArrayList<EndPointCollection> natWestEndPointCollections = new ArrayList<EndPointCollection>();
        natWestEndPointCollections.add(new EndPointCollection("https://openapi.natwest.com/open-banking/v1.3/atms", ATM.class, new ArrayList<ATM>()));
        natWestEndPointCollections.add(new EndPointCollection("https://openapi.natwest.com/open-banking/v1.3/branches", Branch.class, new ArrayList<Branch>()));
        natWestEndPointCollections.add(new EndPointCollection("https://openapi.natwest.com/open-banking/v1.3/personal-current-accounts", PCA.class, new ArrayList<PCA>()));
        banks.add(new Bank( 4, "NatWest", natWestEndPointCollections));
        ArrayList<EndPointCollection> nationWideEndPointCollections = new ArrayList<EndPointCollection>();
        nationWideEndPointCollections.add(new EndPointCollection("https://openapi.nationwide.co.uk/open-banking/v1.2/atms", ATM.class, new ArrayList<ATM>()));
        nationWideEndPointCollections.add(new EndPointCollection("https://openapi.nationwide.co.uk/open-banking/v1.2/branches", Branch.class, new ArrayList<Branch>()));
        nationWideEndPointCollections.add(new EndPointCollection("https://openapi.nationwide.co.uk/open-banking/v1.2/personal-current-accounts", PCA.class, new ArrayList<PCA>()));
        banks.add(new Bank( 5, "NationWide", nationWideEndPointCollections));

    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
}
