package tests.properties;

import org.junit.jupiter.api.Test;

public class TestUrlWithProperties {
@Test
    void testPropertiesUrl() {

  String selenoid = System.getProperty("selenoid", "selenoid.autotests.cloud");


    System.out.println("https://user1:1234@" + selenoid + "/wd/hub");
    }
}
