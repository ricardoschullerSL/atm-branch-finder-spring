package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PCA implements EndPoint{

    @JsonProperty("ProductName")
    private String productName;
    @JsonProperty("ProductDescription")
    private String productDescription;
    @JsonProperty("ProductURL")
    private String[] productUrlArray;

    private String name = "Personal Current Account";


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String[] getProductUrlArray() {
        return productUrlArray;
    }

    public void setProductUrlArray(String[] productUrlArray) {
        this.productUrlArray = productUrlArray;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class getClassType() {
        return PCA.class;
    }
}
