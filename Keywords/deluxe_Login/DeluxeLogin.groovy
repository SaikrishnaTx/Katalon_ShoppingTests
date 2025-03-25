package deluxe_Login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

import com.kms.katalon.core.annotation.Keyword
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
import com.kms.katalon.core.configuration.RunConfiguration



import internal.GlobalVariable

public class DeluxeLogin {
	
	TestObject AcceptCookies=findTestObject("Object Repository/Deluxe/btn_AcceptCookies")
	TestObject User=findTestObject("Object Repository/Deluxe/Input_UserName")
	TestObject Pwd=findTestObject("Object Repository/Deluxe/Input_Password")
	TestObject Domain=findTestObject("Object Repository/Deluxe/Input_DomainName")
	TestObject Login=findTestObject("Object Repository/Deluxe/btn_Login")
	TestObject ErrorMessage=findTestObject("Object Repository/Deluxe/ErrorMessage")
	@Keyword
	
	def LoginDeluxe(String Username,String Password, String DomainName) {
		try {
			
			WebUI.openBrowser(GlobalVariable.urlLogin)
		//	WebUI.navigateToUrl(GlobalVariable.urlLogin)
			WebUI.deleteAllCookies()
			WebUI.maximizeWindow()
			WebUI.waitForPageLoad(30)
			WebUI.click(AcceptCookies)
			WebUI.comment("Clicked on Accept All cookies on popup")
			println("Clicked on Accept All cookies on popup")
			WebUI.delay(5)
			WebUI.setText(User, Username)
			WebUI.comment("Entered UserName")
			println("Entered UserName")
			
			WebUI.setText(Pwd, Password)
			println("Entered Password")
			WebUI.comment("Entered Password")
			WebUI.setText(Domain, DomainName)
			println("Entered Domain Name")
			WebUI.comment("Entered Domain Name")
			WebUI.click(Login)
			println("Clicked on Login Button")
			WebUI.comment("Clicked on Login Button")
			WebUI.delay(5)
			
			boolean ErrorMessage =WebUI.verifyElementPresent(ErrorMessage, 30)
		if(ErrorMessage) {
			println("Failed to Login to The Application")
			WebUI.comment("Failed to Login to The Application")
			WebUI.takeScreenshot()
			WebUI.takeFullPageScreenshot()
			
			}else {
			
				println("Successfully Login to the The Application")
				WebUI.comment("Successfully to Login to the The Application")
				WebUI.takeScreenshot()
			}
			
			
			
		} catch (Exception e) {
			WebUI.comment("Exception occured in Login")
			println("Exception occured in Login")
		} 
		
	}
}
