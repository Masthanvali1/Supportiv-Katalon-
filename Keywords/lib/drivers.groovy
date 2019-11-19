package lib

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.safari.SafariDriver
import com.kms.katalon.core.annotation.Keyword
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.internal.PathUtil as PathUtil

import internal.GlobalVariable

public class drivers {

	def chromeDriverPathForWindows = PathUtil.relativeToAbsolutePath(GlobalVariable.chromeDriverPathForWindows, RunConfiguration.getProjectDir())
	def firefoxDriverPathForWindows = PathUtil.relativeToAbsolutePath(GlobalVariable.firefoxDriverPathForWindows, RunConfiguration.getProjectDir())
	def edgeDriverPathForWindows =PathUtil.relativeToAbsolutePath(GlobalVariable.edgeDriverForWindows, RunConfiguration.getProjectDir())
	def chromeDriverPathForMac = PathUtil.relativeToAbsolutePath(GlobalVariable.chromeDriverPathForMac, RunConfiguration.getProjectDir())

	@Keyword
	def driver(def platform ,def browserName){

		if(GlobalVariable.OS_Name.contains('windows')){

			switch(browserName.toLowerCase()) {

				case "chrome":
					def chromeDriver =  openChromeDriveForWindows()
					return chromeDriver
					break;
				case "firefox":
					def firefoxDriver = openFirefoxDriveForWindows();
					return firefoxDriver
					break;
				case "edge":
					def edgeDriver = openEdgeDriveForWindows()
					return edgeDriver
					break;
				default: throw new Exception("On Windows platform supported browsers are Chrome | Firefox | Edge; choose a valid browser before start running the scripts")
			}
		}
		if(GlobalVariable.OS_Name.contains('mac')){
			
			switch(browserName.toLowerCase()) {
				case "chrome":
					def chromeDriver =  openChromeDriveForMac()
					return chromeDriver
					break;
				case "safari":
					def safariDriver = openSafariBrowserForMac()
					return safariDriver
					break;

				default: throw new Exception("On Mac platform supported browsers are Chrome | Safari; choose a valid browser before start running the scripts")
			}
		}
	}
	
	
	@Keyword
	def openChromeDriveForWindows(){
		System.setProperty("webdriver.chrome.driver", chromeDriverPathForWindows)
		ChromeOptions options = new ChromeOptions()
		options.addArguments("-allow-running-insecure-content")
		ChromeDriver driver = new ChromeDriver(options)
		return driver
	}

	@Keyword
	def openFirefoxDriveForWindows(){
		System.setProperty("webdriver.gecko.driver", firefoxDriverPathForWindows)
		FirefoxOptions options = new FirefoxOptions()
		options.addArguments("-allow-running-insecure-content")
		WebDriver driver = new FirefoxDriver(options);
		return driver
	}

	@Keyword
	def openEdgeDriveForWindows(){
		System.setProperty("webdriver.edge.driver", edgeDriverPathForWindows)
		WebDriver driver = new EdgeDriver();
		return driver
	}

	@Keyword
	def openChromeDriveForMac(){
		System.setProperty("webdriver.chrome.driver", chromeDriverPathForMac)
		ChromeOptions options = new ChromeOptions()
		options.addArguments("-allow-running-insecure-content")
		ChromeDriver driver = new ChromeDriver(options)
		return driver
	}

	@Keyword
	def openSafariBrowserForMac(){
		WebDriver driver = new SafariDriver()
		return driver
	}
}
