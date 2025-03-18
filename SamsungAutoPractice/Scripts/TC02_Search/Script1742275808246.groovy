import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def acceptAllButton = findTestObject('Object Repository/Page_aisearch  Samsung UK/button_Accept All')
def searchButton = findTestObject('Object Repository/Page_Samsung UK  Mobile  Home Electronics  Home Appliances  TV/button_Search Search')
def inputSearch = findTestObject('Object Repository/Page_Samsung UK  Mobile  Home Electronics  Home Appliances  TV/input_Search Form_search')
def expectedUrl = 'https://www.samsung.com/uk/aisearch/?searchvalue=galaxy'

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.samsung.com/uk/')

WebUI.click(acceptAllButton)
WebUI.waitForElementVisible(searchButton, 5)
WebUI.click(searchButton)
WebUI.setText(inputSearch, 'galaxy')
WebUI.sendKeys(inputSearch, Keys.chord(Keys.ENTER))

WebUI.delay(3)
def currentUrl = WebUI.getUrl()

if (currentUrl == expectedUrl) {
	KeywordUtil.markPassed(currentUrl + " = " + expectedUrl)	
} else {
	KeywordUtil.markFailed(currentUrl + " != " + expectedUrl)
}

WebUI.closeBrowser()

