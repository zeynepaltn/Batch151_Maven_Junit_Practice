package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.

    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatirIdx=workbook.getSheet("Sayfa1").getLastRowNum();//getLastRowNum()--->son satir no'sunu index olarak verir
        System.out.println("son Satir Idx = " + sonSatirIdx);
         /*
        1.YOL

        for (int i = 0; i <=sonSatirIdx ; i++) {

            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);

            System.out.println(satirdakiData);

        }
    //NOT1: static bir methoda farkli bir class'dan ulasabilmek icin class ismi kullanilir
    //NOT2: instance bir methoda farkli bir class'dan ulasabilmek icin obje olusturulur.
         */
        for (int i=0; i<=sonSatirIdx; i++) {
           String ingUlkelerBaskent= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(ingUlkelerBaskent);

        }
        System.out.println();
    }
}
