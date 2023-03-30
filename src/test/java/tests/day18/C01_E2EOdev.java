package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_E2EOdev {
    //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
    //2. Bir metod olusturun: RoomCreateTest()
    Faker faker;
    Actions action;
    Select select;

    @Test
    public void RoomCreateTest() {
        //3. https://www.hotelmycamp.com adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
    //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.giris1.click();
        hotelMyCampPage.giris2.click();
        hotelMyCampPage.ilkLoginLinki.click();
    //a. Username : manager b. Password : Manager1!
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
    //5. Login butonuna tıklayın.
        hotelMyCampPage.loginButonu.click();
    //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        hotelMyCampPage.addUser.click();
    //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

      //hotelMyCampPage.userNameBox
       action=new Actions(Driver.getDriver());
        faker=new Faker();

       action.click(hotelMyCampPage.userNameBox).sendKeys(Faker.instance().name().username())
        .sendKeys(Keys.TAB)
        .sendKeys(faker.internet().password(10,15,true,true,true))
        .sendKeys(Keys.TAB)
        .sendKeys(faker.internet().emailAddress())
        .sendKeys(Keys.TAB)
        .sendKeys(faker.name().fullName())
        .sendKeys(Keys.TAB)
        .sendKeys(faker.phoneNumber().cellPhone())
        .sendKeys(Keys.TAB)
        .sendKeys(faker.phoneNumber().phoneNumber())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.letterify(faker.bothify("B")))
               .sendKeys(Keys.TAB)
               .sendKeys(faker.country().name())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.country().capital())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.address().fullAddress())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.date().birthday().toString())
               .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
               .sendKeys(faker.educator().course()).perform();
        select=new Select(hotelMyCampPage.role);
       select.selectByValue("4");
       hotelMyCampPage.radio.click();

    //8. Save butonuna basin.
        hotelMyCampPage.saveButton.click();
    //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        ReusableMethods.waitForVisibility(hotelMyCampPage.succesfullText,10);
        Assert.assertTrue(hotelMyCampPage.succesfullText.isDisplayed());
    //10. OK butonuna tıklayın.
        hotelMyCampPage.succesfullOKButton.click();
    //11. Hotel rooms linkine tıklayın.
        action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitForClickablility(hotelMyCampPage.hotelManagementLinki,10);
        hotelMyCampPage.hotelManagementLinki.click();
        hotelMyCampPage.hotelRoom.click();
    //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
        Assert.assertTrue(hotelMyCampPage.listOfHotelRoomText.isDisplayed());
}
}