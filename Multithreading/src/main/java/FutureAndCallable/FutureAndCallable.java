/**
 * 
 */
package FutureAndCallable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Adwiti
 *
 */
public class FutureAndCallable {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		FileReadThread fileE = new FileReadThread();
		Future<File> file = executor.submit(fileE);
		System.out.println(file);
		FileRead fileRead = new FileRead();
		try {
			fileRead.ReadAFile(file.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class FileReadThread implements Callable<File> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	public File call() throws Exception {
		return new FileRead().CreateAFile();
	}

}

class FileRead {
	public File CreateAFile() {
		File file = new File("mass.xlsx");

		/* Create a workbook */
		XSSFWorkbook workbook = new XSSFWorkbook();
		/* Create a Sheet */
		XSSFSheet sheet = workbook.createSheet("product");
		Map<String, String[]> data = new TreeMap<String, String[]>();
		data.put("1", new String[] { "Arun", "Male", "16" });
		data.put("2", new String[] { "Arun", "Male", "16" });
		data.put("3", new String[] { "Arun", "Male", "16" });
		data.put("4", new String[] { "Arun", "Male", "16" });

		int rowCount = 0;
		for (String key : data.keySet()) {
			int cellCount = 0;

			Row row = sheet.createRow(rowCount++);

			String[] cellData = data.get(key);

			for (String d : cellData) {

				Cell cell = row.createCell(cellCount++);
				cell.setCellValue(d);
			}
		}

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}

	public void ReadAFile(File file) {

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue());
						break;
					default:
						break;
					}
					System.out.println();
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
