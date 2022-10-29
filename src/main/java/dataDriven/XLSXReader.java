package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {

	public void singleData() throws IOException {

		File f = new File(
				"C:\\Users\\Nagarajan\\eclipse-workspace\\IPT-Mini-Project\\AmazonProject\\Datadriven\\Amazon.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet s = w.getSheet("Sheet1");

		Row r = s.getRow(2);

		Cell c = r.getCell(1);

		CellType ce = c.getCellType();

		if (ce.equals(CellType.STRING)) {
			String ss = c.getStringCellValue();
			System.out.println(ss);
		} else if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int i = (int) d;//narrowing

			System.out.println(i);
		}

	}
	
	public static void main(String[] args) throws IOException {
		XLSXReader xs = new XLSXReader();
		xs.singleData();
	}

}
