package ATMBranchFinderSpring.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;


public class Bank {
    public int id;
    private String bankId;
    private ArrayList<ATM> atms;
    private ArrayList<Branch> branches;
    private ArrayList<PCA> pcas;
    private ArrayList<EndPointCollection> endPointCollections;

    public Bank() {};

    public Bank(int id,String bankId, ArrayList<EndPointCollection> endPointCollections) {
        this.id = id;
        this.bankId = bankId;
        this.atms = new ArrayList<ATM>();
        this.branches = new ArrayList<Branch>();
        this.pcas = new ArrayList<PCA>();
        this.endPointCollections = endPointCollections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public ArrayList<ATM> getAtms() {
        return atms;
    }

    public void setAtms(ArrayList<ATM> atms) {
        this.atms = atms;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public ArrayList<PCA> getPcas() {
        return pcas;
    }

    public void setPcas(ArrayList<PCA> pcas) {
        this.pcas = pcas;
    }

    @JsonIgnore
    public ArrayList<EndPointCollection> getEndPointCollections() {
        return endPointCollections;
    }

    public void setEndPointCollections(ArrayList<EndPointCollection> endPointCollections) {
        this.endPointCollections = endPointCollections;
    }
}
