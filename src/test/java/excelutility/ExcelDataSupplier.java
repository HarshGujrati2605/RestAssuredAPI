package excelutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	
   @DataProvider(name = "BookDataFromExcel")
	public Object[][] readDataFromExcel() throws IOException {
		
	   File excel = new File(".\\src\\test\\resources\\ExcelSheets\\testdata.xlsx");
		FileInputStream file = new FileInputStream(excel);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int numberofcolumns = sheet.getRow(0).getLastCellNum();
		
		
		Object[][] data = new Object[rows - 1][numberofcolumns];
		System.out.println(rows);
		System.out.println(numberofcolumns);
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < numberofcolumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
				// System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
				 
				 
			}

		}
		workbook.close();
		file.close();
		for (Object[] arr : data) {
			System.out.println(Arrays.toString(arr));		
		}

		return data;
	}

}
