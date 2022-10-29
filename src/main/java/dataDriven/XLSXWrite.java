package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXWrite {

	public void singledata() throws IOException {

		File f = new File("C:\\Users\\Nagarajan\\Desktop\\Amazon.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet s = w.createSheet("Sheet2");

		Row r = s.createRow(0);

		Cell c = r.createCell(1);

		c.setCellValue("Data");

		w.getSheet("Sheet2").createRow(2).createCell(2).setCellValue("Datatype");

		FileOutputStream fo = new FileOutputStream(f);

		w.write(fo);
		w.close();

	}

	
	public void alldata() throws IOException {
		File f = new File("C:\\Users\\Nagarajan\\Desktop\\Amazon.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet s = w.getSheet("Sheet1");
		
		int rowSize = s.getPhysicalNumberOfRows();
		
		for (int i = 0; i < rowSize; i++) {
			
			Row r = s.getRow(i);
			
			int cellSize =r.getPhysicalNumberOfCells();
			
			for (int j = 0; j < cellSize; j++) {
				
				Cell c = r.getCell(j);
				
				CellType ce = c.getCellType();

				if (ce.equals(CellType.STRING)) {
					String ss = c.getStringCellValue();
					System.out.print(ss);
				} else if (ce.equals(CellType.NUMERIC)) {
					double d = c.getNumericCellValue();
					int k = (int) d;//narrowing

					System.out.print(k);
				}
				System.out.print("||");	
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		XLSXWrite xw = new XLSXWrite();
		//xw.singledata();
		xw.alldata();
		//System.out.println("done");
	}
}
