import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// 브라우저 열기 및 삼성 UK 사이트로 이동
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.samsung.com/uk/')

// 쿠키 동의 버튼 클릭
WebUI.click(findTestObject('Object Repository/Page_Samsung UK  Mobile  Home Electronics  _b6bf0b/button_Accept All'))

// "Appliances" 메뉴에 마우스 오버
WebUI.mouseOver(findTestObject('Object Repository/Page_Samsung UK  Mobile  Home Electronics  _b6bf0b/button_Appliances'))

// "All Vacuums" 링크 클릭
WebUI.click(findTestObject('Object Repository/Page_Samsung UK  Mobile  Home Electronics  _b6bf0b/a_All Vacuums'))

// "Add to basket" 버튼 클릭으로 장바구니에 추가
WebUI.click(findTestObject('Object Repository/Page_Explore Vacuum Cleaner Range  Latest D_fe44a3/a_Add to basket'))

// 장바구니 페이지로 이동
WebUI.click(findTestObject('Object Repository/Page_Cart  Samsung UK/button_'))

// 체크아웃 시작 버튼 클릭
WebUI.click(findTestObject('Object Repository/Page_Cart  Samsung UK/button_Checkout now'))

// 이메일 입력 (체크아웃 초기 단계)
WebUI.setText(findTestObject('Object Repository/Page_/input_Email address_mat-input-1'), 'autotest@teml.net')

// 게스트 체크아웃 선택
WebUI.click(findTestObject('Object Repository/Page_/span_Guest checkout'))