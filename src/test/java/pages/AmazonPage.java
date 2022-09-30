package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    //Bir Page classi actigimizda ilk yapmamiz gereken sey parametresiz constructor olusturup
    //PageFactory ile driver'a ilk degeri atamak(parametresiz constructor ile utilities paketindeki
    //Driver class'indan getDriver methoduna ulasip browser'i aciyoruz)
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="twotabsearchtextbox")  //diger class'lardan obje olusturarak
    public WebElement amazonAramaKutusu;  //bu variable'a ulasiriz (static yapmadik)

   @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
   public WebElement sonucYazisiElementi;
}