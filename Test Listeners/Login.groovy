import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.junit.After
import org.openqa.selenium.firefox.FirefoxDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class Login {

	/**
	 * Executes before every test case starts//	 */
	//  	@BeforeTestCase
	def beforeTestCase() {

	}

	/**
	 * Executes before every test suite starts
	 */
	@BeforeTestSuite
	def loginBeforeTestSuite(){
		GlobalVariable.OS_Name = System.properties['os.name'].toString().toLowerCase()
		def modarator = CustomKeywords.'lib.drivers.driver'(GlobalVariable.OS_Name ,GlobalVariable.browserNameForModerator)
		def user = CustomKeywords.'lib.drivers.driver'(GlobalVariable.OS_Name ,GlobalVariable.browserNameForUser)
		GlobalVariable.modaratorDriver = modarator
		GlobalVariable.userDriver = user

		DriverFactory.changeWebDriver(GlobalVariable.modaratorDriver)
		WebUI.maximizeWindow()
		CustomKeywords.'setUp.Moderator.setUp'()

		DriverFactory.changeWebDriver(GlobalVariable.userDriver)
		WebUI.maximizeWindow()
		CustomKeywords.'setUp.User.setUp'()
	}

	/**
	 * Executes after every test suite
	 */
	@AfterTestSuite
	def closeBrowserAfterTestSuite(){
		DriverFactory.changeWebDriver(GlobalVariable.modaratorDriver)
		CustomKeywords.'pages.ModaratorChatBox.logOutModerator'();
		WebUI.closeBrowser();
		DriverFactory.changeWebDriver(GlobalVariable.userDriver)
		WebUI.closeBrowser();
	}
}

