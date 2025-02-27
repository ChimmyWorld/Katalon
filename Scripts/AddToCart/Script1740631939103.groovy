import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// 브라우저 열기
WebUI.openBrowser('')

// Sauce Demo 사이트로 이동
WebUI.navigateToUrl('https://www.saucedemo.com/')

// 로그인
TestObject usernameInput = new TestObject().addProperty("id", ConditionType.EQUALS, "user-name")
TestObject passwordInput = new TestObject().addProperty("id", ConditionType.EQUALS, "password")
TestObject loginButton = new TestObject().addProperty("id", ConditionType.EQUALS, "login-button")
WebUI.setText(usernameInput, 'standard_user')
WebUI.setText(passwordInput, 'secret_sauce')
WebUI.click(loginButton)

// 제품 목록 로드 대기
WebUI.waitForElementPresent(new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@class='inventory_list']"), 10)

// "Sauce Labs Backpack" 제품 찾기
TestObject backpackItem = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Backpack')]")
WebUI.waitForElementPresent(backpackItem, 10)
WebUI.waitForElementClickable(backpackItem, 10)
WebUI.click(backpackItem)
 
// 상세 페이지 로드 대기
WebUI.waitForElementPresent(new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@class='inventory_details_desc_container']"), 10)

// "Add to cart" 버튼 클릭 (상세 페이지 ID로 수정)
TestObject addToCartButton = new TestObject().addProperty("id", ConditionType.EQUALS, "add-to-cart")
WebUI.waitForElementClickable(addToCartButton, 10)
WebUI.click(addToCartButton)

// 장바구니 이동 및 확인
TestObject cartIcon = new TestObject().addProperty("class", ConditionType.EQUALS, "shopping_cart_link")
WebUI.click(cartIcon)
TestObject cartBackpack = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Backpack')]")
WebUI.verifyElementPresent(cartBackpack, 5)

// 성공 메시지
WebUI.comment('Successfully added Sauce Labs Backpack to cart!')

// 브라우저 닫기
WebUI.closeBrowser()