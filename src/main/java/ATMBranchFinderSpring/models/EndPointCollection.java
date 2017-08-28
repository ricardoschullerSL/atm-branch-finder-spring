package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class EndPointCollection {

    private String uri;
    private Class classType;
    private ArrayList<? extends EndPoint> data;

    public EndPointCollection(String uri, Class classType, ArrayList<? extends EndPoint> data) {
        this.uri = uri;
        this.classType = classType;
        this.data = data;
    }

    public String getUri() {
        return uri;
    }

    @JsonIgnore
    public Class getClassType() {
        return classType;
    }

    public ArrayList<? extends EndPoint> getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }
}
