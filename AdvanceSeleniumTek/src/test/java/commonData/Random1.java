package commonData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Random1 {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	Random ran=new Random();
	int count=ran.nextInt(1000);
	
	FileInputStream path1=new FileInputStream("‪C:\\Users\\Admin\\OneDrive\\Desktop\\code\\sss.xlsx");
	Workbook wb= WorkbookFactory.create(path1);
	Sheet sh=wb.getSheet("Sheet2");
	Row row=sh.getRow(1);
	String Org=row.getCell(2).toString()+count;
	wb.close();
	System.out.println(Org);
	
}


}
