package testing;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Api;

import java.io.FileInputStream;
import java.nio.file.Paths;

public class ApiTestingExcel {
    Api apiTesting;

    @Test (dataProvider = "Data")
    public void apiTesting(String url, String token, String message) {
        // Pages
        apiTesting = new Api();
        // Methods
        apiTesting.dhsup2021(url,token,message);
    }

    @DataProvider
    public Object[][] Data() throws Exception {
        String Excel;
        Excel = "\\src\\test\\java\\testdata\\";
        if (!(Excel.indexOf("c:\\") > -1)) {
            Excel = Paths.get(".").toAbsolutePath().normalize().toString() + Excel;
        }
        FileInputStream filepath = new FileInputStream(Excel + "api_example.xls");
        Workbook wb = Workbook.getWorkbook(filepath);
        Sheet sheet = wb.getSheet("example");
        int row = sheet.getRows();
        System.out.println("number of rows" + row);
        int column = sheet.getColumns();
        System.out.println("number of columns" + column);
        String Testdata[][] = new String[row - 1][column];
        int count = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Cell cell = sheet.getCell(j, i);
                Testdata[count][j] = cell.getContents();
            }
            count++;
        }
        filepath.close();
        return Testdata;
    }
}
