import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

WebUI.waitForElementPresent(new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@class='inventory_list']"), 10)

TestObject product = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Backpack')]")
WebUI.waitForElementClickable(product, 10)
WebUI.click(product)

WebUI.waitForElementPresent(new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@class='inventory_details_desc_container']"), 10)
TestObject addBtn = new TestObject().addProperty("id", ConditionType.EQUALS, "add-to-cart")
WebUI.waitForElementClickable(addBtn, 10)
WebUI.click(addBtn)

WebUI.comment('Product added to cart!')
// openBrowser()나 closeBrowser() 없음