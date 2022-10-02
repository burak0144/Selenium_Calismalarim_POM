package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaWebTables {
     public  DemoqaWebTables(){
           PageFactory.initElements(Driver.getDriver(),this);
       }
   @FindBy(xpath = "//div[@class='rt-th rt-resizable-header -cursor-pointer']")
    public List<WebElement> basliklar;

     @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List<WebElement> satirList;

     @FindBy(xpath = "//div[@class='rt-tbody']")
    public WebElement datalar;

     @FindBy(xpath = "//div[@class='rt-td']")
     public List<WebElement> dataList;



     public void doluDatalar(){
         if (datalar!=null){
             System.out.println(datalar.getText());
         }
     }

    public void xKolonuYazdir(int sutun ){
         int satirSayisi=satirList.size();
         String dinamikXpath=null;
        for (int i = 1; i <=satirSayisi ; i++) {
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+sutun+"]";
            WebElement dinamikXpathWE=Driver.getDriver().findElement(By.xpath(dinamikXpath));
            System.out.println(dinamikXpathWE.getText());
        }
    }
}
