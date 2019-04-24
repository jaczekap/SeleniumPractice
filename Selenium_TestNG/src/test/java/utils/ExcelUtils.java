package utils;

import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtils {

	private String filePath;
	private int sheetIndex;
	private Workbook dataFile;
	private Sheet dataSheet;
	private int adjustRowsNumber;

	/**
	 * @param filePath - path to excel fie (xls or xlsx)
	 * @param sheetIndex - index of sheet in which are data stored
	 * @param hasTitleRow - true if first raw should be consider title row - not a data itself
	 */
	public ExcelUtils(String filePath, int sheetIndex, boolean hasTitleRow) {
		try {
			this.adjustRowsNumber = hasTitleRow ? 1 : 0;
			this.filePath = filePath;
			this.sheetIndex = sheetIndex;
			this.dataFile = WorkbookFactory.create(new File(filePath));
			this.dataSheet =  dataFile.getSheetAt(sheetIndex);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public int getRowsCount() {
		return dataSheet.getPhysicalNumberOfRows();
	}

	public int getColumnsCount() {
		return dataSheet.getRow(0).getPhysicalNumberOfCells();
	}

	public String getCellValueAsString(int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(dataSheet.getRow(rowNum).getCell(colNum));
	}

	/**
	 * @return Array of data ready to use as DataProvider for testNG
	 */
	public Object[][] dataProvider() {
		Object[][] data = new Object[getRowsCount() - adjustRowsNumber][getColumnsCount()];
		for(int i = adjustRowsNumber; i < getRowsCount(); i++) {
			for(int j = 0; j < getColumnsCount(); j++) {
				data[i - adjustRowsNumber][j] = getCellValueAsString(i, j);
			}
		}
		return data;
	}
}
