import com.api.utils.ConfigLoader;
import com.api.utils.ReadProp;

import java.util.Properties;

public class TestJira {
    public static void main(String[] args) {
        Properties prop = ConfigLoader.getInstance().prop;
        System.out.println(prop.get("FAC"));

        Properties prop1 = ReadProp.getConfigPropertyFile("stg");
        System.out.println(prop1.get("FAC"));
    }
    
}
