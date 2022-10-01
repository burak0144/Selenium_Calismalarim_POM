package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_WrongKeyKullanimi {
    @Test
    public void wrongKey() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCurl"));
        // eger key olarak girdigimiz String configuration.properties dosyasinda yoksa
        // Ornegin:  HMCUrl yerine HMCurl yazarsak
        // ConfigReader.getProperty()  o key'i bulamaz ve
        // nullPointerException verir..
    }
}
