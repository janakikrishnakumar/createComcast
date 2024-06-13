package commonData;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.*;
import org.apache.poi.ss.usermodel.*;

public class TestScriptData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream path=new java.io.FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\sss.xlsx");
		
		//open workbook
		Workbook wb= WorkbookFactory.create(path);
		//control sheet
 Sheet sh=wb.getSheet("TestData");
		//control row
		Row row=sh.getRow(0);
		//control cell
		String data=row.getCell(0).getStringCellValue();
		System.out.println(data);


	}

}
