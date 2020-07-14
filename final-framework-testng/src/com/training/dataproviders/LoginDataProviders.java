package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegisterBean> list = new ELearningDAO().getRegisters(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegisterBean temp : list){
			Object[]  obj = new Object[9]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName();
			obj[2] = temp.getEmail(); 
			obj[3] = temp.getUserName();
			obj[4] = temp.getPassWord(); 
			obj[5] = temp.getConfirmPassword();
			obj[6] = temp.getPhone(); 
			obj[7] = temp.getLanguage();
			obj[8] = temp.getProfile(); 			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\DeepaBanakar\\Desktop\\Selenium Training_IBM\\TestData\\Test_Data_Complex Testcase_1.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
