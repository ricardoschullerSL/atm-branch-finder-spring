package ATMBranchFinderSpring;

import ATMBranchFinderSpring.controllers.BankController;
import ATMBranchFinderSpring.repos.BankRepo;

public class BankControllerTest {
    // TODO: FINISH THESE TESTS
    private BankRepo bankRepo = new BankRepo();
    private BankController bankController = new BankController(bankRepo);

    private void SetUp() {

    }
}
