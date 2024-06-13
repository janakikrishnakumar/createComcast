package commonData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream path=new java.io.FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\sss.xlsx");
		
		//open workbook
		Workbook wb= WorkbookFactory.create(path);
		//control sheet
 Sheet sh=wb.getSheet("Sheet1");
		//control row
		int rowCount=sh.getLastRowNum();
		for(int i=1;i<=rowCount;i++) {
			Row row=sh.getRow(i);
		
		String data=row.getCell(0).getStringCellValue();
		String data1=row.getCell(1).getStringCellValue();
		System.out.println(data + " "+ data1);
		

	}

	}
}
