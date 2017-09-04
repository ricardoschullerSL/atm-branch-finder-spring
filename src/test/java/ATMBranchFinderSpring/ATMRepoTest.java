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
        atmRepo.add(new ATM());
        assertEquals(1, atmRepo.getAll().size());
    }

    @Test
    public void canRetrieveAtm() {
        ATM atm = new ATM();
        atm.setAtmId("testATM");
        atmRepo.add(atm);
        ATM expectedAtm = atmRepo.get(0);
        assertEquals("testATM", expectedAtm.getAtmId());
    }

    @Test
    public void canRetrieveAllAtms() {
        ATM atm1 = new ATM();
        ATM atm2 = new ATM();
        atm1.setAtmId("testATM1");
        atm2.setAtmId("testATM2");
        atmRepo.add(atm1);
        atmRepo.add(atm2);
        List<ATM> expectedAtms = atmRepo.getAll();
        assertEquals(2, expectedAtms.size() );
        assertEquals("testATM1",atmRepo.get(0).getAtmId());
    }

    @Test
    public void canRemoveAtm() {
        ATM atm = new ATM();
        atm.setAtmId("testATM1");
        atmRepo.add(atm);
        assertEquals(1,atmRepo.getAll().size());
        atmRepo.remove(0);
        assertEquals(0,atmRepo.getAll().size());
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
        atmRepo.add(atm1);
        atmRepo.add(atm2);

        assertEquals(1, atmRepo.findByCity("Bristol").size());
    }

}
