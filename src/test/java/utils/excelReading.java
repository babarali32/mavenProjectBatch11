package utils;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class excelReading {
    public static XSSFWorkbook book;
    public static XSSFSheet sheet;

    public static void openExcel(String filepath) {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            book = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getsheet(String sheetname) {
        sheet = book.getSheet(sheetname);
    }

    public static int getrowcount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getcellcount(int rowindex) {
        return sheet.getRow(rowindex).getPhysicalNumberOfCells();
    }

    public static String getcelldata(int rowIndex, int columnIndex) {

        return sheet.getRow(rowIndex).getCell(columnIndex).toString();
        }
    public static List<Map<String,String>> exceldataintolist(String filepath,String sheetname){
        openExcel(filepath);
        getsheet(sheetname);
        if (sheet == null) {
            throw new RuntimeException("Sheet is null. Unable to proceed.");
        }
        List<Map<String,String>> listdata=new ArrayList<>();
        for (int row = 1; row < getrowcount(); row++) {
            Map<String,String> map=new LinkedHashMap<>();
            for (int col=0; col<getcellcount(row);col++){
                map.put(getcelldata(0,col),getcelldata(row,col));
            }
            listdata.add(map);
        }
        return listdata;
    }
}