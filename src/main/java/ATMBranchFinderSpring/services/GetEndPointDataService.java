package ATMBranchFinderSpring.services;

import ATMBranchFinderSpring.models.Bank;
import ATMBranchFinderSpring.models.EndPoint;
import ATMBranchFinderSpring.models.EndPointCollection;
import com.fasterxml.jackson.databind.*;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class GetEndPointDataService implements Service {

    private String name;
    private Bank bank;
    private RestTemplate restTemplate;

    public GetEndPointDataService(RestTemplate restTemplate, Bank bank) {
        this.name = "GetEndPointDataService";
        this.bank = bank;
        this.restTemplate = restTemplate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        for (EndPointCollection endPointCollection : bank.getEndPointCollections()) {
            try {
                URI uri = new URI(endPointCollection.getUri());
                String json = restTemplate.getForObject(uri, String.class);
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                JavaType arrayType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, endPointCollection.getClassType());
                ObjectReader reader = mapper.readerFor(arrayType);
                JsonNode node = mapper.readTree(json).get("data");
                ArrayList<? extends EndPoint> data = reader.readValue(node);
                endPointCollection.setData(data);

                System.out.format("Set endpoint data for %s bank. \n", bank.getBankId());


            } catch (IOException e) {
                System.out.println(e);
            } catch (URISyntaxException e) {
                System.out.println(e);
            }
        }


    }
}
