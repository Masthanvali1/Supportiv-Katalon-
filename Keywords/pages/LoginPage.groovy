package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import lib.Actions
import lib.Page
import lib.Navigations
import lib.drivers

class LoginPage {
	Actions actions = new Actions();
	Page verifications = new Page();

	@Keyword
	def getUrl(def url) {
		WebUI.navigateToUrl(url);
	}

	@Keyword
	def EnterLoginDetainsInEmailAndPasswordFields(def email,def password) {
		verifications.verifyElementPresent(findTestObject('Object Repository/Modarator objects/emailField'),"Email field takes too long time to present in login page",GlobalVariable.mediumWaitTime)
		actions.click(findTestObject('Object Repository/Modarator objects/emailField'));
		actions.sendKeys(findTestObject('Object Repository/Modarator objects/emailField'), email)
		WebUI.clearText(findTestObject('Object Repository/Modarator objects/password'))
		actions.sendKeys(findTestObject('Object Repository/Modarator objects/password'), password)
	};

	@Keyword
	def ClickOnLoginButton(){
		actions.click(findTestObject('Object Repository/Modarator objects/loginButton'))
		verifications.verifyElementPresent(findTestObject('Modarator objects/Start Chat Button'),"After lonin page talkes too long time to  load or Stat chart button takes too long time to load",GlobalVariable.mediumWaitTime)
	}

	@Keyword
	def ClickOnStartChatButton(){
		actions.click(findTestObject('Modarator objects/Start Chat Button'))
		verifications.verifyElementPresent(findTestObject('Object Repository/Modarator objects/User List Bar'),"After Clicking on Start chart button, chart modl takes too long time to present",GlobalVariable.mediumWaitTime)
		verifications.verifyElementPresent(findTestObject('Object Repository/Modarator objects/Chat container'),"After Clicking on Start chart button, chart modl takes too long time to present",GlobalVariable.mediumWaitTime)
	}
}