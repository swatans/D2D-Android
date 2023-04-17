import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.util.internal.PathUtil as PathUtil

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent


public class Script {
	String textInput
	String textValue

	/*
	 The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("I open default app")
	def I_open_default_app() {
		Mobile.startExistingApplication('id.', FailureHandling.STOP_ON_FAILURE)
		//Mobile.startExistingApplication('kobitßΩon-store:v157113', FailureHandling.STOP_ON_FAILURE)
		Mobile.delay(5)

	}

	@Given("I open fresh app")
	def I_open_app() {
		Mobile.startApplication('C:\\Users\\MSI\\Downloads\\prod.apk', true)
		//Mobile.startExistingApplication('kobitßΩon-store:v157113', FailureHandling.STOP_ON_FAILURE)
		Mobile.delay(5)

	}

	////////////////////////////////////////////////////

	//	@When("I am on clear account chat room")
	//	def I_am_on_account_chat_room() {
	//		this.I_click('Home/Button_Chat')
	//		this.I_click('Search/Button_SearchContact')
	//		this.I_type_on('automation test', 'Search/TextBox_SearchContact')
	//		this.I_click('Search/List_Contact-1st')
	//		//this.I_should_see('ChatRoom/Button_VoiceCall')
	//		this.I_click('Home/Button_MoreOptions')
	//		this.I_click('ChatRoom/List_ClearConversation')
	//		Mobile.delay(2)
	//	}
	//
	//	@When("I am on clear group chat room")
	//	def I_am_on_group_chat_room() {
	//		this.I_click('Home/Button_Search')
	//		this.I_type_on('automation test', 'Search/TextBox_Search')
	//		this.I_hide_keyboard()
	//		this.I_click('Search/List_ListOfGroup-1st')
	//		//this.I_should_see('ChatRoom/Text_TotalMembers')
	//		this.I_click('Home/Button_MoreOptions')
	//		this.I_click('ChatRoom/List_ClearConversation')
	//		Mobile.delay(2)
	//	}

	@When("I click '(.*)'")
	def I_click(String elme) {
		Mobile.tap(findTestObject('Object Repository/'+elme), 10)
	}

	@When("I click and hold '(.*)'")
	def I_click_and_hold(String elme) {
		Mobile.tapAndHold(findTestObject('Object Repository/'+elme), 3 , 2)
	}

	@When("I type '(.*)' on '(.*)'")
	def I_type_on(String txt, String elme) {
		Mobile.setText(findTestObject('Object Repository/'+elme), txt, 10)
	}


	@When("I type encrypted text '(.*)' on '(.*)'")
	def I_type_on_en(String txt, String elme) {
		Mobile.setEncryptedText(findTestObject('Object Repository/'+elme), txt, 10)
	}

	@When("I should see '(.*)'")
	def I_should_see(String elme) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/'+elme), 10)
	}

	@When("I should not see '(.*)'")
	def I_should_not_see(String elme) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/'+elme), 5)
	}

	@When("I should not see object '(.*)'")
	def I_should_not_see_object(String elme) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/'+elme), 5)
	}

	@When("I verify text '(.*)'")
	def I_assert_text(String elme) {
		Mobile.verifyElementText(findTestObject('Object Repository/'+elme), 5)
	}

	@When("I get text '(.*)'")
	def I_get_text(String elme) {
		Mobile.getText(findTestObject('Object Repository/'+elme), 5)
	}

	@When("I compare text '(.*)'")
	def I_compare_text(String elme) {
		Mobile.verifyEqual(I_get_text('Object Repository/'+elme), 5)
	}


	@When("I swipe to bottom")
	def I_swipe_to_bottom() {
		Mobile.swipe(66, 1085, 53, 861)
		Mobile.delay(3)
	}

	@When("I refresh page")
	def I_refresh_page() {
		Mobile.swipe(66, 1085, 53, 1466)
		Mobile.delay(3)
	}

	@When("I swipe long to bottom")
	def I_swipe_long_to_bottom() {
		Mobile.swipe(1014, 1466, 1014, 0)
		Mobile.delay(3)
	}


	@When("I swipe to the right")
	def I_swipe_to_the_right() {

		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		'Storing the startX,endX values by dividing device height by 2 Because Y coordinates are constant'
		int startY = device_Height / 2
		'Here endY and startY values are equal for vertical Swiping for that assigning startY value to endY'
		int endY = startY

		'Storing the startX value'
		int startX = device_Width * 0.30

		'Storing the endX value'

		int endX = device_Width * 0.70
		'Here Y constant for Swipe Vertical Left to Right'


		//		Mobile.swipe(startX, startY, endX, endY)
		Mobile.swipe(endX, endY, startX, startY)
	}
	@When("I swipe to bottom trx")
	def I_swipe_to_bottom_trx() {
		Mobile.swipe(62, 662, 53, 662)
		Mobile.delay(3)
	}
	@When("I swipe slider '(.*)'")
	def I_swipe_slider(String elme) {
		Mobile.setSliderValue(findTestObject('Object Repository/'+elme), 1, 2)
	}

	@When("I scroll to up")
	def I_scroll_to_up() {
		Mobile.swipe(66, 1085, 53, 1466)
		Mobile.delay(3)
	}

	@When("I scroll to up trx")
	def I_scroll_to_up_trx() {
		Mobile.swipe(1066, 1080, 1306, 1989)
		Mobile.delay(3)
	}

	@When("I press back")
	def I_press_back() {
		Mobile.pressBack()
	}

	@When("I press see password")
	def I_press_see() {
		Mobile.tapAtPosition(938, 824)
	}

	@When("I wait for (.*) seconds")
	def I_wait_for(String secondsStr) {
		int seconds = secondsStr.toInteger()
		Mobile.delay(seconds)
	}

	@When("I kill app")
	def I_kill_app() {
		Mobile.pressBack()
		Mobile.pressBack()
		Mobile.pressBack()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		driver.terminateApp('id.sribuu')
	}

	@When("I put number into the app")
	def I_put_app() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
	}

	@When("I hide keyboard")
	def I_hide_keyboard() {
		Mobile.hideKeyboard()
	}

	@When("I tap app")
	def I_tap_app() {
		Mobile.tapAtPosition(200, 300)
	}

	@When("I tap tutorial at transaction")
	def I_tap_app_transaction() {
		Mobile.tapAtPosition(200, 300)
		Mobile.delay(1)
		Mobile.tapAtPosition(200, 300)
		Mobile.delay(1)
		Mobile.tapAtPosition(200, 300)
		Mobile.delay(1)
		Mobile.tapAtPosition(200, 300)
		Mobile.delay(1)
		Mobile.tapAtPosition(200, 300)
		Mobile.delay(1)
		Mobile.tapAtPosition(200, 300)
		Mobile.delay(1)
		Mobile.tapAtPosition(200, 300)
		Mobile.delay(1)
		Mobile.tapAtPosition(200, 300)
	}

	@When("I close app")
	def I_close_app() {
		Mobile.closeApplication('id.chatalia.app', FailureHandling.STOP_ON_FAILURE)
	}







}