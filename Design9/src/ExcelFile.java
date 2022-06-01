import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.*;

public class ExcelFile {
	
	
	public void excel( double z,double s[],double v[],double a[],double j[] ) throws IOException {
		
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Cam Design");
	XSSFRow row1;
	XSSFRow row2;
	XSSFRow row3;
	XSSFCell cell1;
	XSSFCell cell2;
	XSSFCell cell3;
	
	DecimalFormat dformat = new DecimalFormat("0.000000");

	int cols = (int)z;
	double formated[] = new double[cols];
	
	String str[] = {"Duration" , "Displacement(mm)" , "Velocity(mm/degree)" , "Acceleration(mm/degree^2)" , "Jerk(mm/degree^3)" };
	
	row1 = sheet.createRow(0);
	for(int i=0 ; i<str.length ; i++) {
			cell1 = row1.createCell(i);
			cell1.setCellValue(str[i]);
		}
	
	for(int i=0 ; i<s.length ; i++) {
		row2 = sheet.createRow(i+1);
		
		for(int c=0 ; c<5 ;c++) {
			cell2 = row2.createCell(c);
			switch(c) {
				case 0:
					cell2.setCellValue(i);
				break;
				case 1:
					cell2.setCellValue(s[i]);
				break;
				case 2:
					cell2.setCellValue(v[i]);
				break;
				case 3:
					cell2.setCellValue(Double.parseDouble(dformat.format(a[i])));
				break;
				case 4:
					cell2.setCellValue(j[i]);
				break;
			}
		}
	}
		
		/*
		for(int c=0 ; c<cols ; c++) {
			XSSFRow row3 = sheet.createRow(c);
			XSSFRow row4 = sheet.createRow(c);
			XSSFCell cell = row4.createCell(2);
			XSSFCell cell1 = row4.createCell(3);
			//vv[c] = (Math.round(v[c])*100) / 100;
			
			formated[c] =Double.parseDouble(dformat.format(v[c])) ;
			cell.setCellValue(c);
			cell1.setCellValue(formated[c]);
		    }*/
		
	      
	String fileName = (String)CamInterface.camTypeBox.getSelectedItem();
	//String fileName = ".\\Cam Design.xlsx";
	FileOutputStream outputStream = new FileOutputStream(".\\"+fileName+".xlsx");
	workbook.write(outputStream);
	
	outputStream.close();
		
	}

}

