package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ATM implements EndPoint {

    @JsonProperty("ATMID")
    private String ATMID;
    @JsonProperty("Address")
    private Address Address;
    @JsonProperty("GeographicLocation")
    private GeographicLocation GeographicLocation;

    private String name = "ATM";

    public String getATMID() {
        return ATMID;
    }

    public void setATMID(String id) {
        ATMID = id;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address address) {
        this.Address = address;
    }

    public GeographicLocation getGeographicLocation() {
        return GeographicLocation;
    }

    public void setGeographicLocation(GeographicLocation geographicLocation) {
        GeographicLocation = geographicLocation;
    }

    public Class getClassType() {
        return ATM.class;
    }

    public String getName() {
        return name;
    }
}
