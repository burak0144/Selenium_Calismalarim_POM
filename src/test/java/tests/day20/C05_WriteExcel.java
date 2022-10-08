package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C05_WriteExcel {
    //1) Yeni bir Class olusturalim WriteExcel
    Workbook workbook;
    @Test
    public void writeExcelTest() throws IOException {

    //2) Yeni bir test method olusturalim writeExcelTest()

        String path="src/test/java/resources/ulkeler.xlsx";

        try {
            FileInputStream fis=new FileInputStream(path); //okuyacagiz iceri aliyoruz
             workbook= WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3) Adimlari takip ederek 1.satira kadar gidelim
        //4) 5.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “NUMARA” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(5).setCellValue("NUMARA");

    //6) 2.satir NUMARA kolonuna 4634234 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(5).setCellValue("4634234");
    //7) 10.satir NUMARA kolonuna 10923634 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(5).setCellValue("10923634");
    //8) 15.satir NUMARA kolonuna 54022131 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(5).setCellValue("54022131");
    //9) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(path); //yazdiriyoruz disari gonderiyoruz
       workbook.write(fos);
    //10)Dosyayi kapatalim

        //FileOutputStream Write yazar disari gonderir
        //FileInputStream Read okur iceri alir
}
}
