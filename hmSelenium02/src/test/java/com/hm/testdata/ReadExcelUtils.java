package com.hm.testdata;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtils {
	
	public static void main(String[] args) {
		Object[][] o = getExcelData("calcTestData.xlsx");
		for(int i = 0; i<o.length; i++){
			for(int j = 0; j<o[1].length; j++){
				System.out.print(o[i][j]+"\t");
			}
			System.out.println();//每输完一行打个回车
		}
	}
	public static Object[][] getExcelData(String filename) {
		Object[][] objs = null;
		// 获取当前类的加载器,java是从我们的构建路径来加载类，excel文件也写在构建路径里，所有用类加载器就能找到excel文件的路径
		InputStream is = ReadExcelUtils.class.getClassLoader().getResourceAsStream(filename);
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheet("Sheet1");
			int lastRowNum = sheet.getLastRowNum();// RowNum从0开始。
			Row titleRow = sheet.getRow(0);
			int lastCellNum = titleRow.getLastCellNum();// cell的编号加1，即单元格的编号加1，即有多少列
			objs = new Object[lastRowNum][lastCellNum];

			for (int i = 0; i < objs.length; i++) {
				Row row = sheet.getRow(i + 1);
				for (int j = 0; j < objs[i].length; j++) {
					objs[i][j] = getObject(row.getCell(j));
					
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				wb.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return objs;
	}
	
	private static Object getObject(Cell cell){
		Object data = null;
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			data=cell.getBooleanCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				data = cell.getDateCellValue();
			}else{
				data = DataParse.double2int(cell.getNumericCellValue());//返回的都是double类型
			}
			break;
		case STRING:
			data = cell.getStringCellValue();
			break;	
		default:
			data = null;
		}
		return data;
	}
	
	
	
}


