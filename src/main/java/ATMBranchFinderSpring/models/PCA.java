package ATMBranchFinderSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonProperty("CardWithdrawalLimit")
    private String cardWithdrawalLimit;

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

    public String getCardWithdrawalLimit() {
        return cardWithdrawalLimit;
    }

    public void setCardWithdrawalLimit(String cardWithdrawalLimit) {
        this.cardWithdrawalLimit = cardWithdrawalLimit;
    }

    @Override
    public String getId() {
        return name;
    }

    @Override
    @JsonIgnore
    public Class getClassType() {
        return PCA.class;
    }
}
