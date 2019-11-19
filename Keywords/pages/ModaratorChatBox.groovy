package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.stringtemplate.v4.compiler.CodeGenerator.region_return

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import lib.Actions
import lib.Page
import lib.Navigations
import lib.drivers
import internal.GlobalVariable

public class ModaratorChatBox {
	Actions actions = new Actions();
	Page verifications = new Page();
	@Keyword
	def SendMessageFromModaratorChatBox(def message) {
		actions.click(findTestObject('Object Repository/Modarator objects/Message Textarea'))
		actions.sendKeys(findTestObject('Object Repository/Modarator objects/Message Textarea'), message)
		actions.click(findTestObject("Object Repository/Modarator objects/Send message button"))
		WebUI.delay(3)
		verifications.verifyElementText(findTestObject('Modarator objects/Modarator last message in modarator chat box'),message,message+" message takes too long time to present, after sending from the modarator")
	}

	@Keyword
	def getModaratorLastMessage(){
		def message =actions.getText(findTestObject('Modarator objects/Modarator last message in modarator chat box'))
		return message
	}

	@Keyword
	def clickOnNoButtonInKickoutConformationBar(){
		actions.click(findTestObject('Object Repository/Modarator objects/No button to Kickout a user'))
	}

	@Keyword
	def clickOnYesButtonInKickoutConformationBar(){
		actions.click(findTestObject('Object Repository/Modarator objects/Yes button to kickout a user'))
		WebUI.delay(5)
	}

	@Keyword
	def VerifyUserLastMessage(def userName,def message) {
		def userLostMessage = actions.getText(findTestObject('User Objects/Specificified users last message (user)', ["user":userName]))
		println userLostMessage;
	}

	@Keyword
	def ClickOnMuteChatButton(){
		actions.click(findTestObject('Modarator objects/Mute chat button'))
		WebUI.delay(5)
	}

	@Keyword
	def ClickOnKickOutButton(){
		actions.click(findTestObject('Object Repository/Modarator objects/kickout button'))
		WebUI.delay(5)
	}

	@Keyword
	def ShareRandomPost(){
		WebUI.delay(3)
		def AllShareButtonsCount = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Modarator objects/All Share Buttons'), GlobalVariable.mediumWaitTime).size()
		Random rnd = new Random();
		def ranDomIndexValue = rnd.nextInt(AllShareButtonsCount)+1;
		actions.click(findTestObject('Object Repository/Modarator objects/All Share Buttons(index)', ["index":ranDomIndexValue]))
	}

	@Keyword
	def CloseThePostPage(){
		actions.click(findTestObject('Object Repository/Modarator objects/Close button in Post page'))
	}

	@Keyword
	def GetSharedPostContentFromModaratorChatBox(){
		verifications.verifyElementPresent(findTestObject('Object Repository/Modarator objects/Post Content'),"shared post is takes too long time to present in modarator chart box",GlobalVariable.mediumWaitTime)
		def lastPostContent = actions.getText(findTestObject('Object Repository/Modarator objects/Post Content'));
		return lastPostContent
	}

	@Keyword
	def ClickOnUserProfileIcon(){
		actions.click(findTestObject('Object Repository/Modarator objects/User Profile Icon'));
		verifications.verifyElementPresent(findTestObject('Modarator objects/Mute chat button'),"After clicking on User profile icon, the mute button takes too long time to present", GlobalVariable.defaultWaitTime);
	}

	@Keyword
	getModaratorName(){
		actions.click(findTestObject("Object Repository/Modarator objects/modarator menu button"));
		verifications.waitUntilElementVisible(findTestObject('Object Repository/Modarator objects/profile bar'), "profile bar takes too long time to present ",GlobalVariable.mediumWaitTime)
		def modaratorName = actions.getText(findTestObject('Object Repository/Modarator objects/Modarator Name'))
		GlobalVariable.modaratorName = modaratorName
		actions.click(findTestObject('Object Repository/Modarator objects/modarator menu button'))
	}

	@Keyword
	VerifyTheModeratorNames(){
		def ModeratorNameInModeratorChartBox =  GlobalVariable.modaratorName.split(" ")[0];
		def ModeratorNameInUserChartBox = GlobalVariable.modaratorNameInUserPage.split(" ")[0];
		println ModeratorNameInModeratorChartBox
		println ModeratorNameInUserChartBox
		if(ModeratorNameInModeratorChartBox != ModeratorNameInUserChartBox){
			KeywordUtil.markFailedAndStop(ModeratorNameInModeratorChartBox)("The user is connected to different moderator")
		}
	}
	
	@Keyword
	logOutModerator(){
		actions.click(findTestObject("Object Repository/Modarator objects/modarator menu button"));
		verifications.waitUntilElementVisible(findTestObject('Object Repository/Modarator objects/profile bar'), "profile bar takes too long time to present ",GlobalVariable.mediumWaitTime)
		actions.click(findTestObject('Object Repository/Modarator objects/logOutButton'));
		verifications.waitUntilElementVisible(findTestObject('Object Repository/Modarator objects/loginButton'), "logout functionality takes too long time to present", GlobalVariable.highWaitTime)
	}
}
