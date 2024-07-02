package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {

	public static String getTestData(int row, int cell, String sheetname)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\Alka\\Documents\\TestData.xlsx\\");
		return WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
}
