package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch implements EndPoint{

    @JsonProperty("BranchName")
    private String branchName;
    @JsonProperty("Address")
    private Address address;
    @JsonProperty("GeographicLocation")
    private GeographicLocation geographicLocation;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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

    @Override
    public String getId() {
        return branchName;
    }

    @Override
    @JsonIgnore
    public Class getClassType() {
        return Branch.class;
    }

}
