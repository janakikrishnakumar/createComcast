package commonData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataXcel {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream path=new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\sss.xlsx");
		Workbook wb=WorkbookFactory.create(path);
		Sheet sh=wb.getSheet("Sheet2");
		
		Row row=sh.getRow(1);
		Cell cel=row.createCell(4);
	 cel.setCellType(CellType.STRING);
	 cel.setCellValue("Fail");
	 FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\sss.xlsx");
wb.write(fos);
wb.close();	
 
	}
}
