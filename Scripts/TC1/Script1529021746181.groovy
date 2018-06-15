import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * Thank you for http://automationpractice.com/
 * I used you as a testbed.
 */
WebUI.openBrowser('')
WebUI.navigateToUrl('http://automationpractice.com/index.php?')

/**
 * check if the logo is displayed
 */
def headerLogo = new TestObject('header_logo')
headerLogo.addProperty('xpath', ConditionType.EQUALS, '//div[@id="header_logo"]')
WebUI.verifyElementPresent(headerLogo, 10, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementVisible(headerLogo, FailureHandling.STOP_ON_FAILURE)


/**
 * check if the 'header block_top_menu' shows 
 *     | WOMEN | DRESSES | T-SHIRT |
 * in the top level TAB
 */
/* 
 * Here I create a single instance of com.kms.katalon.core.testobject.TestObject
 * on the fly without using Katalon's Objec Repository.
 * I will reuse the instance for iterating over the 3 tabs while replacing 
 * its selector in xpath.
 *
 * I have a template string: 
 *     //div[@id="block_top_menu"]/ul/li[${index}]/a
 * 
 * I will interpolate the placeholder ${index} with the index of the TAB: 1,2,3. 
 * As the result of interpolation I got the following XPath expressions.
 *     //div[@id="block_top_menu"]/ul/li[1]/a
 *     //div[@id="block_top_menu"]/ul/li[2]/a
 *     //div[@id="block_top_menu"]/ul/li[3]/a
 *     
 * Here I used Groovy's SimpleTemplateEngine. The following URL would give you
 * what it does
 * - http://mrhaki.blogspot.com/2009/10/groovy-goodness-using-template-engines.html
 */
def expected = ['WOMEN', 'DRESSES', 'T-SHIRT']
def engine = new groovy.text.SimpleTemplateEngine()
String template = '//div[@id="block_top_menu"]/ul/li[${index}]/a'
TestObject blockTopMenu = new TestObject('block_top_menu')
for (int i = 0; i < expected.size(); i++) {
	String expr = engine.createTemplate(template).make(['index':i+1]).toString()
	WebUI.comment("expr=${expr}")
	blockTopMenu.addProperty('xpath', ConditionType.EQUALS, expr)
	String text = WebUI.getText(blockTopMenu, FailureHandling.STOP_ON_FAILURE)
	WebUI.comment("text=${text}")
	// check if displayed as expected
	WebUI.verifyEqual(text, expected[i], FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.closeBrowser()
