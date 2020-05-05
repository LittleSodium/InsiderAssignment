package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportToExcel {
	
	String[] myHeaders = { "Movie Name", "Movie Poster URL", "Language", "Genre", "Release Date", 
			"rank", "paytmMovieCode", "isContentAvailable", "contentId", "MovieCode"};

	 int sheetRowCount = 0; 
	  
	 Workbook wb = new XSSFWorkbook();
	 Sheet sheet = wb.createSheet("FirstSheet");
	 
	Row row = sheet.createRow(sheetRowCount++);
	 
	Cell cell= null;
	
	
	 
	 
	}
