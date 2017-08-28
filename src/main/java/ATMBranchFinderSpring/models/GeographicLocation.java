package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeographicLocation {
    @JsonProperty("Latitude")
    private double latitude;
    @JsonProperty("Longitude")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
