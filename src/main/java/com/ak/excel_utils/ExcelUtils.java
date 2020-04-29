package com.ak.excel_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	String excelPath;

	public ExcelUtils(String excelPath) {
		this.excelPath = excelPath;
	}

//	// Write output to an excel file
//	private void writeExcel() {
//		try (FileOutputStream fileOut = new FileOutputStream(excelPath)) {
//			wb.write(fileOut);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		ExcelUtils exl = new ExcelUtils("/C:/DEV/Workspaces/T1.xls");
		List<String> data = new ArrayList<String>();
		data.add("v1");
		data.add("v2");
		data.add("v3");
		// exl.inserRecord("Users", data);

		HashMap<String, String> criteria = new HashMap<String, String>();
		criteria.put("Col2", "v32");
		exl.updateRecord("Users", criteria, data);
	}

	void inserRecord(String tableName, List<String> data) {
		try {
			FileInputStream file = new FileInputStream(new File(excelPath));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(tableName);

			int i = 1;
			while (sheet.getRow(i) != null && sheet.getRow(i).getCell(0) != null) {
				i++;
			}
			System.out.println("Inserting row no : " + i);

			HSSFRow row = sheet.getRow(i);

			if (row == null)
				row = sheet.createRow(i);

			for (int j = 0; j < data.size(); j++) {
				Cell cell = row.getCell(j);
				if (cell == null)
					cell = row.createCell(j);
				cell.setCellValue(data.get(j));
			}

			file.close();

			FileOutputStream outFile = new FileOutputStream(new File(excelPath));
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	List<Integer> getMatchingRows(HSSFSheet sheet, Map<String, String> matchingCriteria) {
		List<Integer> matchingRows = new ArrayList<Integer>();
		Map<Integer, String> _matchingCriteria = new HashMap<Integer, String>();

		if (sheet != null && sheet.getRow(0) != null) {
			int i = 0;
			while (sheet.getRow(0).getCell(i) != null) {
				System.out.println("Here");
				System.out.println(sheet.getRow(0).getCell(i).getStringCellValue());
				if (matchingCriteria.containsKey(sheet.getRow(0).getCell(i).getStringCellValue())) {
					_matchingCriteria.put(i, matchingCriteria.get(sheet.getRow(0).getCell(i).getStringCellValue()));
				}
				i++;
			}

			int rowNo = 1;
			// Iterate over rows
			while (sheet.getRow(rowNo) != null) {

				// Iterate over criterias
				boolean matched = true;
				for (Integer key : _matchingCriteria.keySet()) {
					if (sheet.getRow(rowNo).getCell(key) != null && sheet.getRow(rowNo).getCell(key)
							.getStringCellValue().equals(_matchingCriteria.get(key))) {
					} else {
						matched = false;
						break;
					}
				}
				if (matched) {
					matchingRows.add(rowNo);
				}

				rowNo++;
			}

		}
		System.out.println("Column Criterias : ");
		System.out.println(_matchingCriteria);
		System.out.println("Matching Rows : ");
		System.out.println(matchingRows);
		return matchingRows;
	}

	void updateRecord(String tableName, Map<String, String> matchingCriteria, List<String> data) {
		try {
			FileInputStream file = new FileInputStream(new File(excelPath));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(tableName);

			List<Integer> matchedRows = getMatchingRows(sheet, matchingCriteria);

			for (Integer rowNo : matchedRows) {
				System.out.println("Updating Row : " + rowNo);
				HSSFRow row = sheet.getRow(rowNo);

				if (row == null)
					row = sheet.createRow(rowNo);

				for (int j = 0; j < data.size(); j++) {
					Cell cell = row.getCell(j);
					if (cell == null)
						cell = row.createCell(j);
					cell.setCellValue(data.get(j));
				}
			}

			file.close();

			FileOutputStream outFile = new FileOutputStream(new File(excelPath));
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void deleteRecord(String tableName, Map<String, String> matchingCriteria) {
		try {
			FileInputStream file = new FileInputStream(new File(excelPath));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(tableName);

			List<Integer> matchedRows = getMatchingRows(sheet, matchingCriteria);

			for (Integer rowNo : matchedRows) {

				System.out.println("Removing Row : " + rowNo);
				HSSFRow row = sheet.createRow(rowNo);
			}

			file.close();

			FileOutputStream outFile = new FileOutputStream(new File(excelPath));
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	List<List<String>> getAllRecords(String tableName) {
		return null;
	}

	List<List<String>> getecords(String tableName, Map<String, String> matchingCriteria) {
		return null;
	}

}
