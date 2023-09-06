package com.blinkx.excelStatus.serviceIml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.entity.ExcelStatusEntity;
import com.blinkx.excelStatus.entity.TempTopFund;
import com.blinkx.excelStatus.entity.TopFund;
import com.blinkx.excelStatus.repository.ExcelStatusRepository;

public class ExcelHelperImpl {
	
	private final static String data="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	public static boolean hasExcelFormat(MultipartFile file) {
		if(!data.equals(file.getContentType())) {
			return false;
		}
		else {
//
			return true;
		}
	}
	
	
	public static List<ExcelStatusEntity> convertExcelSheetToSql(InputStream inputStream) throws Exception {
		try {
		Workbook workbook=new XSSFWorkbook(inputStream);
//			Workbook workbook=new Workbook();
			
		String sheetName = workbook.getSheetName(0);
		Sheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> iterator = sheet.iterator();
		List<ExcelStatusEntity> dumpData=new ArrayList<ExcelStatusEntity>();
		int rowNumber=0;
		while(iterator.hasNext()) {
			Row currentRow = iterator.next();
			
			if(rowNumber==0) {
				rowNumber++;
				continue;
			}
		
			Iterator<Cell> cellsInRow = currentRow.iterator();
			
			ExcelStatusEntity excelStatusEntity=new ExcelStatusEntity();
			
			int cellIdx=0;
			while(cellsInRow.hasNext()) {
				Cell currentCell = cellsInRow.next();
				switch (cellIdx) {
				case 0:
					excelStatusEntity.setEmail(currentCell.getStringCellValue());
				break;
				case 1:
					excelStatusEntity.setMandateId(currentCell.getStringCellValue());
				break;
				case 2:
					excelStatusEntity.setBankName(currentCell.getStringCellValue());
				break;
				case 3:
					excelStatusEntity.setAccountNumber(currentCell.getStringCellValue());
				break;
				case 4:
					excelStatusEntity.setBankId(currentCell.getStringCellValue());
				break;
				case 5:
					excelStatusEntity.setAmount(currentCell.getNumericCellValue());
				break;
				case 6:
//					String stringCellValue = currentCell.getStringCellValue();
//					if(stringCellValue.isEmpty()) {
					excelStatusEntity.setUmrn(currentCell.getStringCellValue());
//					}
//					else {
//						excelStatusEntity.setUmrn(stringCellValue);
//					}
//					System.out.println("empty");
				break;
				case 7:
					excelStatusEntity.setType(currentCell.getStringCellValue());
				break;
				case 8:
					excelStatusEntity.setRegistration_date(currentCell.getStringCellValue());
				break;
				case 9:
					excelStatusEntity.setApproved_date(currentCell.getStringCellValue());
//					System.out.println("empty");
				break;
				case 10:
					excelStatusEntity.setStatus(currentCell.getStringCellValue());
				break;
				case 11:
					excelStatusEntity.setStatusReason(currentCell.getStringCellValue());
//					System.out.println("empty");
				break;
				case 12:
					excelStatusEntity.setSubStatus(currentCell.getStringCellValue());
//					System.out.println("empty");

				break;
				}
				if(cellIdx<=12) {
				cellIdx++;
				}
			}
			dumpData.add(excelStatusEntity);
		}
		workbook.close();
		
		return dumpData;
	}
		
	catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }

	}
	
	public static List<TopFund> convertExcelToSqlTopFunds(InputStream inputStream) throws Exception {
		try {
			Workbook workbook=new XSSFWorkbook(inputStream);
			String sheetName = workbook.getSheetName(0);
			Sheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> iterator = sheet.iterator();
			List<TopFund> dumpData=new ArrayList<TopFund>();
			int rowNo=0;
			while(iterator.hasNext()) {
				Row currentRow = iterator.next();
				
				if(rowNo==0) {
					rowNo++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				TopFund topFund=new TopFund();
				
				int cellIdx=0;
				while(cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
				switch (cellIdx) {
					case 0:
						topFund.setListOfFund(currentCell.getStringCellValue());
					break;
					case 1:
						
						topFund.setTopFunds(currentCell.getStringCellValue());
					break;
					case 2:
						topFund.setWealthCreation(currentCell.getStringCellValue());
					break;
					case 3:
						topFund.setTopTaxSaver(currentCell.getStringCellValue());
					break;
					case 4:
						topFund.setBalanceFunds(currentCell.getStringCellValue());
					break;
					case 5:
						topFund.setBetterThanSavings(currentCell.getStringCellValue());
					break;
					case 6:
						topFund.setBetterThanFd(currentCell.getStringCellValue());
					break;	
					  default:
				     break;
					}
//					if(cellIdx<=6) {
						cellIdx++;
//						}
			}
				dumpData.add(topFund);
		} 
			workbook.close();
			return dumpData;
		}
		
		catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	public static List<TempTopFund> convertExceltoSqlTempTopFund(InputStream inputStream) throws Exception{
		try {
			Workbook workbook=new XSSFWorkbook(inputStream);
			List<TempTopFund> tempTopFund=new ArrayList<TempTopFund>();
			int numberOfSheets = workbook.getNumberOfSheets();
			for(int i=0;i<numberOfSheets;i++) {
				String sheetName = workbook.getSheetName(i);
				Sheet sheet = workbook.getSheet(sheetName);
				Iterator<Row> iterator = sheet.iterator();
				int rowNumber=0;
				while(iterator.hasNext()) {
					Row currentRow = iterator.next();
					
					if(rowNumber==0) {
						rowNumber++;
						continue;
					}
					Iterator<Cell> cellsInRow = currentRow.iterator();
					TempTopFund fund=new TempTopFund();
					int cellIdx=0;
					while(cellsInRow.hasNext()) {
						Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
					case 0:
						fund.setSrNo((int)currentCell.getNumericCellValue());
					break;
					case 1:
						fund.setFundaName(currentCell.getStringCellValue());
					break;
					case 2:
						fund.setLink(currentCell.getStringCellValue());
					break;
					case 3:
						fund.setThreeYrReturn(currentCell.getStringCellValue());
					break;
					case 4:
						fund.setRating(currentCell.getStringCellValue());
					break;
					case 5:
						fund.setMinInv(currentCell.getStringCellValue());
					break;
					case 6:
						fund.setCategory(sheetName);
					break;
					default:
					     break;
					}
					cellIdx++;
				}
					tempTopFund.add(fund);
			}
				
			}
			workbook.close();
			return tempTopFund;
			
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());

			}
	}
}
