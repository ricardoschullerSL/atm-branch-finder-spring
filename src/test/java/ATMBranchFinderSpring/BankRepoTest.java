package ATMBranchFinderSpring;

import ATMBranchFinderSpring.models.Bank;
import ATMBranchFinderSpring.repos.BankRepo;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankRepoTest {

    private BankRepo bankRepo = new BankRepo();

    @Test
    public void canAddBank() {
        bankRepo.add(new Bank());
        assertEquals(1, bankRepo.getAll().size());
    }

    @Test
    public void canRetrieveBank() {
        Bank bank = new Bank();
        bank.setId(10);
        bankRepo.add(bank);
        Bank expectedBank = bankRepo.get(0);
        assertEquals(10, expectedBank.getId());
    }

    @Test
    public void canRetrieveAllBanks() {
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        bank1.setBankId("testBank1");
        bank2.setBankId("testBank2");
        bankRepo.add(bank1);
        bankRepo.add(bank2);
        assertEquals(2, bankRepo.getAll().size());
        assertEquals("testBank2", bankRepo.get(1).getBankId());
    }

    @Test
    public void canRemoveBank() {
        Bank bank1 = new Bank();
        bankRepo.add(bank1);
        assertEquals(1, bankRepo.getAll().size());
        bankRepo.remove(0);
        assertEquals(0, bankRepo.getAll().size());
    }

    @Test
    public void canFindByBankId() {
        Bank bank1 = new Bank();
        bank1.setBankId("testBank1");
        bank1.setId(0);
        Bank bank2 = new Bank();
        bank2.setBankId("testBank2");
        bank2.setId(1);
        bankRepo.add(bank1);
        bankRepo.add(bank2);
        assertEquals(2,bankRepo.getAll().size());
        assertEquals(1, bankRepo.findByBankId("testBank2").getId());
    }
}
