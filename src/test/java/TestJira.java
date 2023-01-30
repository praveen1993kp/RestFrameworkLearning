import com.api.utils.ConfigLoader;

import java.util.Properties;

public class TestJira {
    public static void main(String[] args) {
        Properties prop = ConfigLoader.getInstance().prop;
        System.out.println(prop.get("FAC"));
    }
    
}
