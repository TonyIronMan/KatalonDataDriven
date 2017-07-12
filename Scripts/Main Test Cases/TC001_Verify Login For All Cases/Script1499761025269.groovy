import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.sun.java.util.jar.pack.Instruction.Switch
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

@com.kms.katalon.core.annotation.SetUp
def Setup() {
	WebUI.openBrowser(var_url)
	
}
'Click Sign in button'
WebUI.click(findTestObject('Object Repository/Dashboard Pages/btn_Signin'))

'Call login functions'

WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('var_username') : var_email , ('var_password') : var_password], FailureHandling.STOP_ON_FAILURE)

'Get status expected test case result'
switch(var_statusExpectedResult.toString())
{
	case 'email_is_empty':
		'Verify when expected test case login with email is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/Login Pages/div_ErrorMess'))				
		WebUI.verifyEqual(errorMess.contains('Password is required.'), true)		
		break;
	case 'email_isnot_correct':
		'Verify when expected test case login fail with passowrd is not correct'
		def errorMess = WebUI.getText(findTestObject('Object Repository/Login Pages/div_ErrorMess'))
		WebUI.verifyEqual(errorMess.contains('Authentication failed.'), true)
		break;
}

@com.kms.katalon.core.annotation.TearDown
def Teardown() {
    WebUI.closeBrowser()
}

