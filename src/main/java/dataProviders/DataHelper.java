package dataProviders;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class DataHelper {

	/**
	 * This method will read the data from Excel sheet and returns the data as a list of map
	 * 
	 * @return
	 */
	public static List<HashMap<String, String>> data() {

		List<HashMap<String, String>> mydata = new ArrayList<>();
		try {

			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir")
							+ "//src//test//resources//testData/ExcelTest.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("TestData");
			Row HeaderRow = sheet.getRow(0);

			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:

						currentHash.put(HeaderRow.getCell(j)
								.getStringCellValue(), currentCell
								.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:

						currentHash.put(HeaderRow.getCell(j)
								.getStringCellValue(),  Double.toString(currentCell
										.getNumericCellValue()));                              
						break;
					}

				}
				mydata.add(currentHash);
			}

			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mydata;

	}

}