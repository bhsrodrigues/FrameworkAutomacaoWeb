package estudos.frameworkautomacaoweb.common;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends CommonFunctions {
	

	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		wait = new WebDriverWait(driver, 15);
	}
	
	public void navigateTo(String url) {
		CommonFunctions.driver.get(url);
	}
	
	protected String getWebPageTitle() {
		return CommonFunctions.driver.getTitle();
	}
	
	
	
	/***
	 * Método para esperar um elemento visível na página
	 * Pode ser usado em qualquer classe do tipo Page (elementos das páginas)
	 * @param by Tipo de elemento o qual será procurado na página (xpath, css, id, etc)
	 * @return Retorna o elemento encontrado
	 * @author Bruno Henrique
	 */
	protected WebElement waitVisibleElement(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	/***
	 * Método para esperar todos elementos visíveis na página
	 * Pode ser usado em qualquer classe do tipo Page (elementos das páginas)
	 * @param by Tipo de elemento o qual será procurado na página (xpath, css, id, etc)
	 * @return Retorna o elemento encontrado
	 * @author Bruno Henrique
	 */
	protected List<WebElement> waitAllVisibleElements(By by){
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	protected String getElementPlaceholderValue(WebElement element) {
		return element.getAttribute("placeholder");
	}
	
	protected String getElementAriaLabelValue(WebElement element) {
		return element.getAttribute("aria-label");
	}

	protected void updateTimeout(int time) {
		wait = new WebDriverWait(CommonFunctions.driver, time);
	}
	
	protected void assertMessages(String expected, String message) {
		assertEquals("Mensagens não combinam. Esperado ('" + expected.trim().toLowerCase() 
				+ "') e encontrado ('" + message.trim().toLowerCase() + ").", 
				expected, message);
	}
	
	protected void assertTitles(String expected, String actual) {
		assertEquals(expected.trim().toLowerCase(),actual.trim().toLowerCase());
	}
}
