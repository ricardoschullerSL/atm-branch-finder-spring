package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ATM implements EndPoint {

    @JsonProperty("ATMID")
    private String atmid;
    @JsonProperty("Address")
    private Address address;
    @JsonProperty("GeographicLocation")
    private GeographicLocation geographicLocation;

    public String getATMID() {
        return atmid;
    }

    public void setATMID(String atmid) {
        this.atmid = atmid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public GeographicLocation getGeographicLocation() {
        return geographicLocation;
    }

    public void setGeographicLocation(GeographicLocation geographicLocation) {
        this.geographicLocation = geographicLocation;
    }
    @JsonIgnore()
    public Class getClassType() {
        return ATM.class;
    }
    public String getId() {return atmid; }
}
