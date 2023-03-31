package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCampPage {
   public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(css = "input#UserName")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement girisYapilamadiYaziElementi;

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement basariliGirisYazisiElementi;

    @FindBy(css = "#menuHotels")
    public WebElement hotelManagementLinki;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelListLinki;

    @FindBy(xpath = "//a[@class='btn btn-circle btn-default']")
    public WebElement addHotelLinki;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoom;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement listOfHotelRoomText;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement addHotelCodeKutusu;

    @FindBy(xpath = "//select[@id='IDGroup']" )
    public WebElement addHotelDropdown;

    @FindBy(xpath ="//button[@id='btnSubmit']" )
    public WebElement addHotelSaveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement basariliEklendi;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement lastButtonOK;

    @FindBy(css = "button#details-button")
    public WebElement giris1;

    @FindBy(css = "a#proceed-link")
    public WebElement giris2;

    @FindBy(css = ".hidden-480")
    public WebElement addUser;

    @FindBy(css = "select#IDRole")
    public WebElement role;

    @FindBy(xpath = "//div[@class='radio']")
    public WebElement radio;

    @FindBy(css = "button#btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()='User was inserted successfully']")
    public WebElement succesfullText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement succesfullOKButton;




    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void girisYap(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        giris1.click();
        giris2.click();
        ilkLoginLinki.click();
        userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginButonu.click();
    }

}

