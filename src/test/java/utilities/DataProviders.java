package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
//	Data Provider 1 :
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\loginData.xlsx";   // taking xl file from test Data
		
		ExcelUtility xlutil = new ExcelUtility(path);   // creating an object for xlutility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);   // 1 indicates row numbers start from 1 in Excel
		
		String logindata[][]=new String[totalrows][totalcols];   // Created for two dimension array which can store rows and cols
		
		for(int i=1;i<=totalrows;i=i+1)   // 1 // read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j=j+1)   // 0 // i is row j is col 
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);   // Get data from Excel sheet
			}
		}
		
		return logindata;   // returning two dimension array
	}

}