package setUp

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.annotation.Keyword
import org.openqa.selenium.WebDriver
import pages.LoginPage
import pages.ModaratorChatBox
import pages.UserWebPage
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

import internal.GlobalVariable

public class User {
	LoginPage loginPage = new LoginPage()
	ModaratorChatBox modaratorChartBox = new ModaratorChatBox()
	UserWebPage userWebpage = new UserWebPage()
	@Keyword
	def setUp(){
		loginPage.getUrl(GlobalVariable.userUrl);
		userWebpage.ClickOnChatButton();
		userWebpage.SwitchIframeToUserChatBox();
		userWebpage.EnterStruggleText("how to get relief from work pressure");
		userWebpage.ClickOnGetMatchedButton();
		userWebpage.EnterUserName(GlobalVariable.nameOfTheUser);
		userWebpage.ClickReadyButton()
		userWebpage.getAssignedModaratorName()
	}
}
