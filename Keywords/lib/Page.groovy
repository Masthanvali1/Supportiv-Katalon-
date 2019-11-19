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
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.DataFlavor
import org.openqa.selenium.Keys as Keys


class Page extends Actions{
	/**
	 * Reusable Methods
	 */
	@Keyword
	def verifyElementPresent(TestObject element, String failureDescription, int maxWaitTime = GlobalVariable.defaultWaitTime) {
		if(!WebUI.verifyElementPresent(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementPresentAndContinueOnFailure(TestObject element, String failureDescription, int maxWaitTime = GlobalVariable.defaultWaitTime) {
		if(!WebUI.verifyElementPresent(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotPresent(TestObject element, String failureDescription, int maxWaitTime = GlobalVariable.defaultWaitTime) {
		if(!WebUI.verifyElementNotPresent(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotPresentAndContinuewOnFailure(TestObject element, String failureDescription, int maxWaitTime = GlobalVariable.defaultWaitTime) {
		if(!WebUI.verifyElementNotPresent(element, maxWaitTime, FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(failureDescription)
		}
	}

	@Keyword
	def verifyTextMatch(String actual, String expected, String failureDescription){
		if(!(WebUI.verifyMatch(actual, expected, false))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementVisible(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementVisible(element))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def waitUntilElementVisible(TestObject element, String failureDescription,int WaitTime){
		if(!(WebUI.waitForElementVisible(element, WaitTime))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}
	@Keyword
	def waitUntilElementNotVisible(TestObject element, String failureDescription,int WaitTime){
		if(!(WebUI.waitForElementNotVisible(element, WaitTime))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotVisible(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementNotVisible(element))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementClickable(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementClickable(element))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotClickable(TestObject element, String failureDescription){
		if(!(WebUI.verifyElementNotClickable(element))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}

	@Keyword
	def verifyElementText(TestObject element,String expectedText, String failureDescription){
		if(!(WebUI.verifyElementText(element, expectedText))){
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(failureDescription)
		}
	}
	@Keyword
	def verifyTextboxEditable(TestObject element, String failureDescription){

		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard()
		def t = cb.getContents(cb)
		String clipboardContentBeforeCopy = t.getTransferData(DataFlavor.stringFlavor).toString()
		println(clipboardContentBeforeCopy)
		WebUI.click(element)
		WebUI.sendKeys(element, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(element, Keys.chord(Keys.CONTROL, 'c'))
		String clipboardContentAfterCopy = t.getTransferData(DataFlavor.stringFlavor).toString()
		println(clipboardContentBeforeCopy)

		if(clipboardContentAfterCopy==clipboardContentBeforeCopy){
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(failureDescription)
		}
	}
}