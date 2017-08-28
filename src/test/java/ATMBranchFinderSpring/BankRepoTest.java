package ATMBranchFinderSpring;

import ATMBranchFinderSpring.models.Bank;
import ATMBranchFinderSpring.repos.BankRepo;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankRepoTest {

    private BankRepo bankRepo = new BankRepo();

    @Test
    public void canAddBank() {
        bankRepo.Add(new Bank());
        assertEquals(1, bankRepo.GetAll().size());
    }

    @Test
    public void canRetrieveBank() {
        Bank bank = new Bank();
        bank.setId(10);
        bankRepo.Add(bank);
        Bank expectedBank = bankRepo.Get(0);
        assertEquals(10, expectedBank.getId());
    }

    @Test
    public void canRetrieveAllBanks() {
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        bank1.setBankId("testBank1");
        bank2.setBankId("testBank2");
        bankRepo.Add(bank1);
        bankRepo.Add(bank2);
        assertEquals(2, bankRepo.GetAll().size());
        assertEquals("testBank2", bankRepo.Get(1).getBankId());
    }

    @Test
    public void canRemoveBank() {
        Bank bank1 = new Bank();
        bankRepo.Add(bank1);
        assertEquals(1, bankRepo.GetAll().size());
        bankRepo.Remove(0);
        assertEquals(0, bankRepo.GetAll().size());
    }

    @Test
    public void canFindByBankId() {
        Bank bank1 = new Bank();
        bank1.setBankId("testBank1");
        bank1.setId(0);
        Bank bank2 = new Bank();
        bank2.setBankId("testBank2");
        bank2.setId(1);
        bankRepo.Add(bank1);
        bankRepo.Add(bank2);
        assertEquals(2,bankRepo.GetAll().size());
        assertEquals(1, bankRepo.FindByBankId("testBank2").getId());
    }
}
