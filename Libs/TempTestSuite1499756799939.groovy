import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData



def static runTestCase_0() {
    TestCaseMain.runTestCase('Test Cases/Test Cases/TC001_Verify Login Functions', new TestCaseBinding('Test Cases/Test Cases/TC001_Verify Login Functions - Iteration 1',  [ 'var_email' : 'katalonstudio@gmail.com' , 'var_url' : 'http://automationpractice.com' , 'var_password' : 'Katalon@2017' , 'var_statusExpectedResult' : 'email_and_password_iscorrect' ,  ]), FailureHandling.STOP_ON_FAILURE)
}

def static runTestCase_1() {
    TestCaseMain.runTestCase('Test Cases/Test Cases/TC001_Verify Login Functions', new TestCaseBinding('Test Cases/Test Cases/TC001_Verify Login Functions - Iteration 2',  [ 'var_email' : 'katalonstudio@gmail.com' , 'var_url' : 'http://automationpractice.com' , 'var_password' : '12345678' , 'var_statusExpectedResult' : 'email_isnot_correct' ,  ]), FailureHandling.STOP_ON_FAILURE)
}


Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/TS_Login Functions')

suiteProperties.put('name', 'TS_Login Functions')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\liemchau\\Katalon Studio\\KatalonDataDriven\\Reports\\TS_Login Functions\\20170711_140639\\execution.properties")

TestCaseMain.beforeStart()

KeywordLogger.getInstance().startSuite('TS_Login Functions', suiteProperties)

(0..1).each {
    "runTestCase_${it}"()
}



KeywordLogger.getInstance().endSuite('TS_Login Functions', null)
