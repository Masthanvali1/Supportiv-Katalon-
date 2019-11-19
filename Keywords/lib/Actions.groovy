package lib
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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class Actions {
	/**
	 * Actions on web elements
	 */

	int waitTime = GlobalVariable.defaultWaitTime

	@Keyword
	def click(TestObject element) {
		wait(element)
		WebUI.waitForElementClickable(element, waitTime)
		if(GlobalVariable.OS_Name.contains('windows')){
			WebUI.click(element)
		} else {
			WebDriver driver = DriverFactory.getWebDriver()
			JavascriptExecutor executor = ((driver) as JavascriptExecutor)
			def el = WebUiCommonHelper.findWebElement(element, 30)
			executor.executeScript('arguments[0].click()', el)
		}
	}

	@Keyword
	def sendKeys(TestObject element, String text) {
		wait(element)
		WebUI.waitForElementClickable(element, waitTime)
		WebUI.sendKeys(element, text)
	}

	@Keyword
	def sendKeysEncrypted(TestObject element, String encryptedText) {
		wait(element)
		WebUI.waitForElementClickable(element, waitTime)
		WebUI.setEncryptedText(element, encryptedText)
	}

	@Keyword
	def getText(TestObject element, int maxWaitTime = waitTime) {
		wait(element, maxWaitTime)
		return WebUI.getText(element).trim()
	}

	@Keyword
	def wait(TestObject element, int maxWaitTime = waitTime) {
		//		WebUI.waitForAngularLoad(0)
		WebUI.waitForElementPresent(element, maxWaitTime)
		WebUI.waitForElementVisible(element, maxWaitTime)
	}

	@Keyword
	def getElementCount(TestObject element) {
		wait(element)
		return WebUiCommonHelper.findWebElements(element, waitTime).size()
	}
}





