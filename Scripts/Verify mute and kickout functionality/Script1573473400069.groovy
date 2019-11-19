import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'pages.ModaratorChatBox.VerifyTheModeratorNames'()
DriverFactory.changeWebDriver(GlobalVariable.modaratorDriver)
CustomKeywords.'pages.ModaratorChatBox.ClickOnUserProfileIcon'()
CustomKeywords.'pages.ModaratorChatBox.ClickOnMuteChatButton'()
def muteAlartMessage = CustomKeywords.'pages.ModaratorChatBox.getModaratorLastMessage'()
WebUI.verifyMatch(muteAlartMessage,GlobalVariable.nameOfTheUser+' is in "time out" to review rules.', false);
DriverFactory.changeWebDriver(GlobalVariable.userDriver)
WebUI.verifyElementNotClickable(findTestObject('Object Repository/User Objects/Message Textbox'))
DriverFactory.changeWebDriver(GlobalVariable.modaratorDriver)
CustomKeywords.'pages.ModaratorChatBox.ClickOnMuteChatButton'()
CustomKeywords.'pages.ModaratorChatBox.ClickOnKickOutButton'()
CustomKeywords.'pages.ModaratorChatBox.clickOnNoButtonInKickoutConformationBar'()
//CustomKeywords.'pages.ModaratorChatBox.ClickOnKickOutButton'()
//CustomKeywords.'pages.ModaratorChatBox.clickOnYesButtonInKickoutConformationBar'();
//def kickOutMessage = CustomKeywords.'pages.ModaratorChatBox.getModaratorLastMessage'()
//WebUI.verifyMatch(kickOutMessage,GlobalVariable.nameOfTheUser+" is suspended for misbehavior.", false);
//DriverFactory.changeWebDriver(GlobalVariable.userDriver)
//CustomKeywords.'lib.Page.verifyElementPresent'(findTestObject('User Objects/temporarily locked Text'), "After kickout the user, the temporarily locked message is not present",GlobalVariable.highWaitTime)
//CustomKeywords.'lib.Page.verifyElementText'(findTestObject('User Objects/temporarily locked Text'), "Your account is temporarily locked", "Your account is temporarily locked message is not present for the kickout user")
