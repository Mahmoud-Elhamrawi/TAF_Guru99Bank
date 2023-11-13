package Data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {


    static FileInputStream fis =null ;

    public  FileInputStream getFile() throws FileNotFoundException {

        //  String path = "./src\\test\\java\\resources\\testData.csv";
        String pathFile = System.getProperty("user.dir")+"./src\\test\\resources\\validuserLogin.xlsx";
        File srcFile = new File(pathFile);
        fis = new FileInputStream(srcFile);
        return fis;
    }

    public  Object [][] getExcelData() throws IOException {
        fis = getFile()   ;
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int totalNumbersOfRows = (sheet.getLastRowNum() + 1);
        int totalNumbersOfCols = 2;

        String[][] arrayExcelData = new  String[totalNumbersOfRows][totalNumbersOfCols];
        for (int i=0;i<totalNumbersOfRows ;i++)
        {
            for (int j =0;j<totalNumbersOfCols ;j++)
            {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] =row.getCell(j).toString();
            }
        }

        wb.close();
        return  arrayExcelData ;
    }





}
