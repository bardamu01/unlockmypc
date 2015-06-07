
import com.themerrybunch.unlockmypc.AWSConfig;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestGetAWSConfig {

    @Test
    public void values_retrieved_ok() throws IOException {
        AWSConfig awsConfig = AWSConfig.fromReader(new FileReader("src/test/test.json"));
        Assert.assertEquals("endpoint", awsConfig.getEndpoint());
        Assert.assertEquals("access-key", awsConfig.getAccessKey());
        Assert.assertEquals("secret-key", awsConfig.getSecretKey());
    }
}
