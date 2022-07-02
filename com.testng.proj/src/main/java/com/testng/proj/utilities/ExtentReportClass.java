package com.testng.proj.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportClass {
	private static ExtentReports extentReporter = null;

	private static String directoryPath;

	private ExtentReportClass() {

		System.out.println("Creating the ExtentReportClass object");
	}

	public static ExtentReports getExtentReporter() {
		try {
			if (extentReporter == null) {
				System.out.println("Create reporter object");
				ExtentReportClass extentReportClass = new ExtentReportClass();
				createReportingDirectory();
				extentReporter = new ExtentReports();
				String htmlReport = CreateFile();
				ExtentSparkReporter htmlReporter = new ExtentSparkReporter(htmlReport);
				htmlReporter.config().setTheme(Theme.DARK);
				extentReporter.attachReporter(htmlReporter);
			} else {
				System.out.println("Reporter object already created");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return extentReporter;

	}

	public static void createReportingDirectory() {
		try {
			directoryPath = System.getProperty("user.dir") + "\\ExtentReport";
			File directoryObj = new File(directoryPath);
			if (!directoryObj.exists()) {
				System.out.println("Create the directory");
				directoryObj.mkdir();
			} else {
				System.out.println("The directory has already been created");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
	public static String CreateFile() {
		try {
		String htmlReport = directoryPath + "\\extentReport.html";
		File reportFile = new File(htmlReport);
		if(!reportFile.exists()) {
				reportFile.createNewFile();
		}
		return htmlReport;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		}
}
