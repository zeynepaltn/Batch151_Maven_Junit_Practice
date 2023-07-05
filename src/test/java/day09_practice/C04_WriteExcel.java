package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {
    @Test
    public void test01() throws IOException {
        //Ulkeler dosyasindaki 0. satir index'in, 4. hucre index'ine yeni bir cell olusturalim
        //olusturdugumuz hucreye "Nufus" yaziralim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        // 1. satir index'in 4. hucre index'ine yeni bir cell olusturun
        //olusturdugunuz hucreye "15000" yazdirin
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("15000");
        //2. satir index'inin 4. hucre index'ine yeni bir cell olusturun
        //olusturdugunuz hucreye "25000" yazdirin
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("25000");
        //Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);//data'lari bizim class'dan ulkeler dosyasina gondermek icin
        workbook.write(fos);
        //Dosyayi kapatalim
        workbook.close();
        fos.close();

    }
}
