import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

WebUI.openBrowser('') // 브라우저 열기
WebUI.navigateToUrl('https://www.saucedemo.com/')

TestObject username = new TestObject().addProperty("id", ConditionType.EQUALS, "user-name")
TestObject password = new TestObject().addProperty("id", ConditionType.EQUALS, "password")
TestObject loginBtn = new TestObject().addProperty("id", ConditionType.EQUALS, "login-button")

WebUI.setText(username, 'standard_user')
WebUI.setText(password, 'secret_sauce')
WebUI.click(loginBtn)

WebUI.verifyTextPresent('Products', false)
WebUI.comment('Login successful!')
// closeBrowser() 없음