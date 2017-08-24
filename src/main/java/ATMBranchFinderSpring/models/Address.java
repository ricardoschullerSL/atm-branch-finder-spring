package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @JsonProperty("TownName")
    private String TownName;
    @JsonProperty("PostCode")
    private String PostCode;
    @JsonProperty("StreetName")
    private String StreetName;

    public String getTownName() {
        return TownName;
    }

    public void setTownName(String townName) {
        this.TownName = townName;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        this.PostCode = postCode;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        this.StreetName = streetName;
    }
}
