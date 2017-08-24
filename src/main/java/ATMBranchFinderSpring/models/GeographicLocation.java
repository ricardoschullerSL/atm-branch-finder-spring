package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeographicLocation {
    @JsonProperty("Latitude")
    private double Latitude;
    @JsonProperty("Longitude")
    private double Longitude;

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        this.Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        this.Longitude = longitude;
    }
}
