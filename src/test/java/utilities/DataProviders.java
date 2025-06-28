 package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Logindata")
	
	public String[][] GetAllData() throws IOException 
	
	{
       String path=".\\testdata\\LoginData.xlsx";          // taking excel file from testdata
       XLUtility xl=new XLUtility(path);                  // creating object for xl utility
		
	    
	    int rownum = xl.getRowcount("Sheet1");      // get total no.of row
	    
	    int colCount = xl.getCellcount("Sheet1",1);  // get total no.of column
	    
	    String ldata[][]= new String[rownum][colCount];
	    
	    for (int i = 1; i < rownum; i++)           // 1 read the data from xl storing in two dimensional array
	    {
	        for (int j = 0; j < colCount; j++)          // 0               i is row j is column
	        {
	            ldata[i-1][j]=xl.getCellData("Sheet1", i, j);
	            	
	        }
	        
	    }
		return ldata;
		
	}}
	
	
	  	    
		    
		    
		    
		    
		    

	    
	    

	    
	    
	
