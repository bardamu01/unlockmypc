
import com.themerrybunch.unlockmypc.AWSConfig;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestGetAWSConfig {

    @Test
    public void values_retrieved_ok() throws IOException {
        InputStreamReader inputStreamReader = new FileReader("src/test/test.json");
        AWSConfig awsConfig = AWSConfig.fromReader(inputStreamReader);
        Assert.assertEquals("endpoint", awsConfig.getEndpoint());
        Assert.assertEquals("access-key", awsConfig.getAccessKey());
        Assert.assertEquals("secret-key", awsConfig.getSecretKey());
    }
}
