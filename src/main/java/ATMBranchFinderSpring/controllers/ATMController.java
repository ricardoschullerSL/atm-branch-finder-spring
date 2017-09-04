package ATMBranchFinderSpring.controllers;

import ATMBranchFinderSpring.models.ATM;
import ATMBranchFinderSpring.repos.ATMRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class ATMController {

    private final ATMRepo atmRepo;
    private final double LATITUDE_TO_KM = 69;
    private final double LONGITUDE_TO_KM = 111;


    @Autowired
    public ATMController( ATMRepo atmRepo) {
        this.atmRepo = atmRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/atms",
                    produces="application/json")
    public Collection<ATM> allAtms() {
        return atmRepo.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/atms/{id}")
    public ATM singleAtm(@PathVariable int id) { return atmRepo.get(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/atms/city/{cityName}", produces="application/json")
    public Collection<ATM> findAtmsByCity(@PathVariable String cityName) {return atmRepo.findByCity(cityName); }

    @RequestMapping(method = RequestMethod.GET, value = "/atms/userlocation/{userLatitude}/{userLongitude}/{maxDistance}")
    public Collection<ATM> findAtmsByUserLocation(@PathVariable double userLatitude, @PathVariable double userLongitude, @PathVariable double maxDistance) {
        ArrayList<ATM> atms = (ArrayList<ATM>) atmRepo.getAll();
        ArrayList<ATM> filteredAtms = new ArrayList<ATM>();

        for(ATM atm: atms) {
            double distanceSquared = Math.pow((atm.getGeographicLocation().getLatitude() - userLatitude)*LATITUDE_TO_KM, 2) +
                    Math.pow((atm.getGeographicLocation().getLongitude() - userLongitude)*LONGITUDE_TO_KM, 2);
            if (distanceSquared <= maxDistance) {
                atm.setDistanceSquared(distanceSquared);
                filteredAtms.add(atm);
            }
        }
        return filteredAtms;
    }
}
