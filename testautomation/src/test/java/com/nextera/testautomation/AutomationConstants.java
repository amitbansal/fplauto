package com.nextera.testautomation;

public class AutomationConstants {
	public String Base_URL;
	public String Json_File_Path;
	public String Hub_URL;
	public String Screenshot_Path;
	public String FireFoxProfile_Name;
	public String Regression_Reportfile_Path;
	public String Sanity_Reportfile_Path;
	public String Reportfile_Path;
	public static String ImagetagFailTest;
	public static String Data_File = "C:\\Eclipse_workspace\\testautomation\\datafile.properties";

	public AutomationConstants() {
		ExternalConstants.init();
		Base_URL=   ExternalConstants.prop.getProperty("base_URL");
		Json_File_Path = ExternalConstants.prop.getProperty("JSon_File_Path");
		Hub_URL = ExternalConstants.prop.getProperty("Hub_URL");
		Screenshot_Path = ExternalConstants.prop.getProperty("Screenshot_Path");
		FireFoxProfile_Name = ExternalConstants.prop.getProperty("FireFoxProfile_Name");
		Regression_Reportfile_Path = ExternalConstants.prop.getProperty("RegressionReportfile_Path");
		Sanity_Reportfile_Path = ExternalConstants.prop.getProperty("SanityReportfile_Path");
		Reportfile_Path = ExternalConstants.prop.getProperty("Reportfile_Path");
	}

}