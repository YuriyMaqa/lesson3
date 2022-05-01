package tests.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class TestUrlWithProperties {
@Test
    void testPropertiesUrl() {

  String selenoid = System.getProperty("selenoid", "selenoid.autotests.cloud");
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    String login = config.loginSelenoid();
    String password = config.passwordSelenoid();

    System.out.println(login + " " + password);


    System.out.println("https://"+ login + password + selenoid + "/wd/hub");
    }
}
