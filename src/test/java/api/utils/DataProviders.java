package api.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

	public static String filelocation = System.getProperty("user.dir") + "/TestData/DataDrivenExcel.xlsx";
	public String sheetName = "TestSheet";
	public Read_Excel readExcelData;

	@DataProvider(name = "Data")
	public Object[][] getUserData() {
		
		readExcelData = new Read_Excel(filelocation);
		String testCaseName = "CreateUser";
		return readExcelData.retrieveTestData(sheetName, testCaseName);
	}
}
