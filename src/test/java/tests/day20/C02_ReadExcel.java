package tests.day20;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcel2() throws IOException {
        SoftAssert softAssert = new SoftAssert();

    //Yeni bir test method olusturalim readExcel2( )
    //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
    String path="src/test/java/resources/ulkeler.xlsx";
    //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    FileInputStream fis=new FileInputStream(path);
    Workbook workbook= WorkbookFactory.create(fis);
       String cell= workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("=======1. satir 2.hucre");
        System.out.println(cell);
    //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedData="Kabil";
        String cell2=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        softAssert.assertEquals(cell2,expectedData);
    //- Satir sayisini bulalim
        System.out.println("=======satir sayisi ve fiziki kullanilan satir sayisi");
      int satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("satir sayisi :"+satirSayisi);
    //- Fiziki olarak kullanilan satir sayisini bulun
        int fizikiKullanilanSatirSayisi=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("fiziki kullanilan satir sayisi :"+fizikiKullanilanSatirSayisi);
        // fiziki kullanilan satir sayisi index ile degil sayma sayilari ile calisir
        System.out.println("======3.satirdaki datalar");
        // ulkeler excel'inin 3. satirini yazdirin
        for(int i=0; i<4; i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(2).getCell(i));
            //sout'ta toString'e gerek kalmadan yazdirilabiliriz(cell)
        }
        // ilk 20 ulkenin baskentlerinin turkce isimlerini yazdirin
        System.out.println("==========ilk 20 ulkenin baskentleri");
        for (int i = 1; i <=20 ; i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(3));
        }
    //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim




       softAssert.assertAll();
}
}