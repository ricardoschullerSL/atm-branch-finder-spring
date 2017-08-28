package ATMBranchFinderSpring;

import ATMBranchFinderSpring.models.ATM;
import ATMBranchFinderSpring.models.Address;
import ATMBranchFinderSpring.repos.ATMRepo;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;

public class ATMRepoTest {

    private ATMRepo atmRepo = new ATMRepo();

    @Test
    public void canAddAtm() {
        atmRepo.Add(new ATM());
        assertEquals(1, atmRepo.GetAll().size());
    }

    @Test
    public void canRetrieveAtm() {
        ATM atm = new ATM();
        atm.setATMID("testATM");
        atmRepo.Add(atm);
        ATM expectedAtm = atmRepo.Get(0);
        assertEquals("testATM", expectedAtm.getATMID());
    }

    @Test
    public void canRetrieveAllAtms() {
        ATM atm1 = new ATM();
        ATM atm2 = new ATM();
        atm1.setATMID("testATM1");
        atm2.setATMID("testATM2");
        atmRepo.Add(atm1);
        atmRepo.Add(atm2);
        List<ATM> expectedAtms = atmRepo.GetAll();
        assertEquals(2, expectedAtms.size() );
        assertEquals("testATM1",atmRepo.Get(0).getATMID());
    }

    @Test
    public void canRemoveAtm() {
        ATM atm = new ATM();
        atm.setATMID("testATM1");
        atmRepo.Add(atm);
        assertEquals(1,atmRepo.GetAll().size());
        atmRepo.Remove(0);
        assertEquals(0,atmRepo.GetAll().size());
    }

    @Test
    public void canFindAtmsByCity() {
        Address address1 = new Address();
        address1.setTownName("Bristol");
        ATM atm1 = new ATM();
        atm1.setAddress(address1);
        Address address2 = new Address();
        address2.setTownName("Manchester");
        ATM atm2 = new ATM();
        atm2.setAddress(address2);
        atmRepo.Add(atm1);
        atmRepo.Add(atm2);

        assertEquals(1, atmRepo.FindByCity("Bristol").size());
    }

}
