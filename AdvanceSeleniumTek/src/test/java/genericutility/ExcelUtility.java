package genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
		public String getDataFromXcel(String sheetname,int rowNum,int colnum) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
 FileInputStream fis=new FileInputStream("./configapp/sss.xlsx");
 Workbook wb=WorkbookFactory.create(fis);
 String data=wb.getSheet(sheetname).getRow(rowNum).getCell(colnum).getStringCellValue() ;
return data;
 
	}
		
		public int getRowcount(String sheetname) throws EncryptedDocumentException, IOException {
			 FileInputStream fis=new FileInputStream("./configapp/sss.xlsx");
			 Workbook wb=WorkbookFactory.create(fis);
int rowcount=wb.getSheet(sheetname).getLastRowNum();
return rowcount;

		}
public void setDataExcel(String sheetname,int rowNum,int colnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./configapp/sss.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	 wb.getSheet(sheetname).getRow(rowNum).createCell(colnum);
	 FileOutputStream fos=new FileOutputStream("./configapp/sss.xlsx");
	 wb.write(fos);
	 wb.close();
}

}
