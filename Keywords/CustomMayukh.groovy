import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

import internal.GlobalVariable

public class CustomMayukh {

	@Keyword
	def printName(String name) {
		println "Your name is: " + name
	}

	@Keyword
	def multiply(int x, int y) {
		println "Multiplication is: " + (x * y)
	}

	@Keyword
	def toUpper(String text) {
		println text.toUpperCase()
	}

	@Keyword
	def repeatWord(String word, int times) {
		for (int i = 0; i < times; i++) {
			println word
		}
	}

	@Keyword
	def reverseWord(String word) {
		String reversed = word.reverse()
		println "Reversed word: " + reversed
		return reversed
	}

	@Keyword
	static String generateRandomGmail() {
		int randomNumber = (Math.random() * 1000).toInteger()
		String email = "user${randomNumber}@gmail.com"
		return email
	}

	@Keyword
	def boolean performLogin(String username, String password) {
		try {
			WebUI.setText(findTestObject('Object Repository/Page_Demo Web Shop. Login/input_Email_Email'), username)
			WebUI.setEncryptedText(findTestObject('Object Repository/Page_Demo Web Shop. Login/input_Password_Password'), password)
			WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Login/input_Forgot password_button-1 login-button'))
			boolean loginSuccess = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Demo Web Shop/a_Log out'), 10, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			println "Login failed due to: " + e.getMessage()
			return false
		}
	}
}
