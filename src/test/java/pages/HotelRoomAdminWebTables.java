package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HotelRoomAdminWebTables {

    public HotelRoomAdminWebTables(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
@FindBy(xpath = "//input[@id='UserName']")
    public WebElement userName;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> sutunList;

    @FindBy(xpath = "//thead//tr[1]")
    public WebElement basliklar;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> satirlar;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> hucreler;




    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void xSutunundakiElementler(int sutun) {
        int satirSayisi=satirlar.size();
        String dinamikXPath;
        for (int i = 1; i <=satirSayisi ; i++) {
            dinamikXPath="//tbody//tr["+i+"]//td["+sutun+"]";
            WebElement dinamikXPathWE=Driver.getDriver().findElement(By.xpath(dinamikXPath));

            System.out.println(dinamikXPathWE.getText());
        }

    }

    public void printData(int satir, int sutun) {
        int satirSayisi=satirlar.size();
        String dinamikXPath="//tbody//tr["+satir+"]//td["+sutun+"]";
        WebElement dinamikXPathWE=Driver.getDriver().findElement(By.xpath(dinamikXPath));
        System.out.println(satir+".satir ve "+sutun+".sutundaki cell :"+dinamikXPathWE.getText());
    }
}
