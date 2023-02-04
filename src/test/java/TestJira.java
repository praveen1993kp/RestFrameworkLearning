import com.api.base.RestResource;
import com.api.utils.ConfigLoader;
import com.api.utils.ReadProp;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Properties;

public class TestJira {

    @Test(enabled = false)
    public  void testConfigLoader() {
        Properties prop = ConfigLoader.getInstance().prop;
        System.out.println(prop.get("FAC"));

        Properties prop1 = ReadProp.getConfigPropertyFile("stg");
        System.out.println(prop1.get("FAC"));
    }


    @Test(enabled = true)
    public  void testCreateJira() {
        try {
            RestResource rest = new RestResource();
            Response res = rest.createIncident();
            res.jsonPath().get("id");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



}
