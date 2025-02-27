import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// 브라우저 열기
WebUI.openBrowser('')

// Sauce Demo 사이트로 이동
WebUI.navigateToUrl('https://www.saucedemo.com/')

// 사용자 이름, 비밀번호, 로그인 버튼 요소 정의
TestObject usernameInput = new TestObject().addProperty("id", ConditionType.EQUALS, "user-name")
TestObject passwordInput = new TestObject().addProperty("id", ConditionType.EQUALS, "password")
TestObject loginButton = new TestObject().addProperty("id", ConditionType.EQUALS, "login-button")

// 로그인 정보 입력 및 버튼 클릭
WebUI.setText(usernameInput, 'standard_user')
WebUI.setText(passwordInput, 'secret_sauce')
WebUI.click(loginButton)

// 페이지 로드 대기 (2초)
WebUI.delay(2)

// 로그인 성공 여부 확인 ("Products" 텍스트 확인)
WebUI.verifyTextPresent('Products', false)

// 브라우저 닫기
WebUI.closeBrowser()