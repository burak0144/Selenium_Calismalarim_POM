package tests.day20;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    //1. apache poi dependency’i pom file’a ekleyelim
    //2. Java klasoru altinda resources klasoru olusturalim
    //3. Excel dosyamizi resources klasorune ekleyelim
    //4. excelAutomation isminde bir package olusturalim
    //5. ReadExcel isminde bir class olusturalim

    @Test
    public void readExcel() throws IOException {
    //6. readExcel() method olusturalim
    //7. Dosya yolunu bir String degiskene atayalim
        String path="src/test/java/resources/ulkeler.xlsx";
    //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(path);
    //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
    //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
    //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(4);
    //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(2);

        System.out.println("Sayfa 1 deki 4.indexteki satir ve 2. index'teki sutunda bulunan data :"+cell);

        // biz FIS ile okudugumuz excel dosyasini projemiz icerisinde kullanabilmek icin
        // Apachi POI dependency yardimi ile bir Workbook olusturduk

        // Bu workbook bizim projemizin icerisinde ulkeler excelinin bir kopyasini kullanmamizi sagliyor

        // Excel'in yapisis geregi bir hucreye ulasabilmek icin workbook dan baslayarak
        // sirasiyla sheet, row ve cell objeleri olusturmamiz gerekir

        //indexi4 olan satirdaki , indexi 2 olan hucrenin Andorra oldugunu test edin
        Assert.assertEquals(cell.toString(),"Andorra");
        //data turu cell oldugu icin .toString methodunu kullanmaliyiz

        // 5. indexteki satirin 3.indexdeki hucre bilgisini yazdiralim
        row=sheet.getRow(5);
        cell=row.getCell(3);
        System.out.println("Sayfa 1 deki 5.indexteki satir ve 3. index'teki sutunda bulunan data :"+cell);
}
}