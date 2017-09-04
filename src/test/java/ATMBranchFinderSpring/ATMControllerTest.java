package ATMBranchFinderSpring;

import ATMBranchFinderSpring.controllers.ATMController;
import ATMBranchFinderSpring.models.ATM;
import ATMBranchFinderSpring.models.Address;
import ATMBranchFinderSpring.models.GeographicLocation;
import ATMBranchFinderSpring.repos.ATMRepo;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.test.web.servlet.MockMvc;

public class ATMControllerTest {

    private MockMvc mockMvc;

    private ATMRepo atmRepo = new ATMRepo();
    private ATMController atmController = new ATMController(atmRepo);

    private void SetUp() {
        GeographicLocation geographicLocation1 = new GeographicLocation();
        geographicLocation1.setLatitude(1.5);
        geographicLocation1.setLongitude(1.5);
        ATM atm1 = new ATM();
        atm1.setAtmId("testATM1");
        atm1.setGeographicLocation(geographicLocation1);
        Address address1 = new Address();
        address1.setTownName("Bristol");
        address1.setPostCode("TROLOL15");
        address1.setStreetName("15 Trolol Lane");
        atm1.setAddress(address1);
        String[] currency = {"GBP"};
        atm1.setCurrency(currency);

        GeographicLocation geographicLocation2 = new GeographicLocation();
        geographicLocation2.setLongitude(10);
        geographicLocation2.setLatitude(10);
        ATM atm2 = new ATM();
        atm2.setAtmId("testATM2");
        atm2.setGeographicLocation(geographicLocation2);
        Address address2 = new Address();
        address2.setTownName("London");
        address2.setPostCode("HEHEHE70");
        address2.setStreetName("70 Hehe Drive");
        atm2.setAddress(address2);
        atm2.setCurrency(currency);

        atmRepo.add(atm1);
        atmRepo.add(atm2);
    }

    @Test
    public void allAtmsTest() {
        SetUp();
        assertEquals(2, atmController.allAtms().size());
    }

    @Test
    public void singleAtmTest() {
        SetUp();
        assertEquals("testATM1", atmController.singleAtm(0).getAtmId());
    }

    @Test
    public void FindAtmsByCityTest() {
        SetUp();
        assertEquals(1, atmController.findAtmsByCity("Bristol").size());
    }

    @Test
    public void FindAtmsByUserLocationTest() {
        SetUp();
        assertEquals(1, atmController.findAtmsByUserLocation(1.5,1.5,2).size());
    }
}
