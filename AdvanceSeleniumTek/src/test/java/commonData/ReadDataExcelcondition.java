package commonData;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataExcelcondition {

	public static void main(String[] args) throws IOException {
		String testid="TC-2";
		String data1="";
		String data2="";
		String data3="";
	FileInputStream path=new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\sss.xlsx");
	Workbook wb=WorkbookFactory.create(path);
	Sheet sh=wb.getSheet("Sheet2");
	int lastRow=sh.getLastRowNum();
	for (int i=0;i<=lastRow;i++) {
		String data="";
		try {
	 data=sh.getRow(i).getCell(0).toString();
	 if(data.equals(testid)) {
		 data1=sh.getRow(i).getCell(1).toString();
		 data2=sh.getRow(i).getCell(2).toString();
		 data3=sh.getRow(i).getCell(3).toString();
		 
	 }
		}
		catch(Exception e) {}
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
	}
			

	}

}
