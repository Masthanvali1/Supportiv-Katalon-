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
import lib.Actions
import lib.Page
import lib.Navigations
import lib.drivers
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


class UserWebPage {
	Actions actions = new Actions();
	Page verifications = new Page();

	@Keyword
	def ClickOnChatButton() {
		verifications.waitUntilElementVisible(findTestObject('Object Repository/User Objects/Video on Webpage'),"User web page takes too long time to load",GlobalVariable.highWaitTime)
		verifications.verifyElementPresent(findTestObject('User Objects/Chat Now Button'),"Chart button takes too long time to present",GlobalVariable.mediumWaitTime)
		actions.click(findTestObject('User Objects/Chat Now Button'));
		verifications.waitUntilElementVisible(findTestObject('Object Repository/User Objects/Spinner'), "user chart box takes too long time to load",GlobalVariable.highWaitTime)
	}

	@Keyword
	def SendMessageFromUserChatBox(def message){
		actions.click(findTestObject('Object Repository/User Objects/Message Textbox'))
		actions.sendKeys(findTestObject('Object Repository/User Objects/Message Textbox'),message)
		actions.click(findTestObject('Object Repository/User Objects/Send message button'))
		WebUI.delay(3)
		verifications.verifyElementText(findTestObject('Object Repository/User Objects/User last message'),message,message+" message takes too long time to present")
	}
	@Keyword
	def SwitchIframeToUserChatBox(){
		verifications.waitUntilElementNotVisible(findTestObject('Object Repository/User Objects/Spinner'), "the frame takes too long time to load", GlobalVariable.highWaitTime)
		verifications.waitUntilElementVisible(findTestObject('Object Repository/User Objects/iframe'), "iframe takes too long time to present",GlobalVariable.highWaitTime)
		WebUI.switchToFrame(findTestObject('User Objects/chat iframe'),GlobalVariable.highWaitTime)
		verifications.waitUntilElementVisible(findTestObject('Object Repository/User Objects/whats the struggle Text'),"whats the struggle Text modal takes too long time to present in user chart box", GlobalVariable.highWaitTime);
	}

	@Keyword
	def EnterStruggleText(def StruggleText){
		actions.click(findTestObject('Object Repository/User Objects/struggleTextarea'));
		actions.sendKeys(findTestObject('Object Repository/User Objects/struggleTextarea'),StruggleText);
	}

	@Keyword
	def ClickOnGetMatchedButton(){
		actions.click(findTestObject('Object Repository/User Objects/Get Matched Button'));
		verifications.waitUntilElementVisible(findTestObject('Object Repository/User Objects/People matching magic'), "People matching magic page takes too long time", GlobalVariable.veryHighWaitTime)
		verifications.waitUntilElementVisible(findTestObject('Object Repository/User Objects/What should the group call you-popup'),"What should the group call you-popup fields takes too long time to present",GlobalVariable.veryHighWaitTime);	
	}

	@Keyword
	def EnterUserName(def UserName){
		verifications.verifyElementPresent(findTestObject('Object Repository/User Objects/What should the group call you-popup'),"What should the group call you-popup fields takes too long time to present",GlobalVariable.highWaitTime);
		actions.sendKeys(findTestObject('Object Repository/User Objects/UserName field'), UserName);
	}

	@Keyword
	def ClickReadyButton(def UserName){
		actions.click(findTestObject('Object Repository/User Objects/Ready Button'));
		verifications.verifyElementPresent(findTestObject('Object Repository/User Objects/User List on user chart box'),"After clicking on ",GlobalVariable.highWaitTime);
		verifications.verifyElementNotPresent(findTestObject('Object Repository/User Objects/Modarator name'), "chrt box takes to lon time to present",GlobalVariable.highWaitTime)
	}
	@Keyword
	def getAssignedModaratorName(){
		verifications.verifyElementPresent(findTestObject('Object Repository/User Objects/Modarator last message'), "modarator is not assigned",GlobalVariable.highWaitTime)
		def modaratorUserNameInUserPage = verifications.getText(findTestObject('Object Repository/User Objects/Modarator name'))
		println modaratorUserNameInUserPage+" this is user modarator"
		GlobalVariable.modaratorNameInUserPage = modaratorUserNameInUserPage
	}

	@Keyword
	def getModaratorLastMessage() {
		def userLostMessage = actions.getText(findTestObject('Object Repository/User Objects/Modarator last message'))
		return  userLostMessage;
	}

	@Keyword
	def GetSharedPostContentFromUserChatBox(){
		def lastPostContent = WebUI.getText(findTestObject('Object Repository/User Objects/Post Content'));
		return lastPostContent
	}
}