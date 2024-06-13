package genericfileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xcelutility {
public String getDataExcel(String SheetName,int Rownum,int cell) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis= new FileInputStream("./configapp/sss.xlxs");
	Workbook wb=WorkbookFactory.create(fis);
	String data= wb.getSheet(SheetName).getRow(Rownum).getCell(cell).getStringCellValue().toString();
	wb.close();
	return data;
	
}
public int getRowcount(String sh) throws Throwable, IOException {
	FileInputStream fis= new FileInputStream("./configapp/sss.xlxs");
	Workbook wb=WorkbookFactory.create(fis);
	int rownum= wb.getSheet(sh).getLastRowNum();
	wb.close();
	return rownum;
	
}
public void setDataXcel(String Sheetname,int Rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis1= new FileInputStream("./configapp/sss.xlxs");
	Workbook wb1=WorkbookFactory.create(fis1);
	 wb1.getSheet(Sheetname).getRow(Rownum).createCell(cellnum);
	FileOutputStream fos= new FileOutputStream("./configapp/sss.xlsx");
	wb1.write(fos);
	wb1.close();
	
	

}
}
