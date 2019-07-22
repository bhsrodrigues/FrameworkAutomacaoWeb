package estudos.frameworkautomacaoweb.pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import estudos.frameworkautomacaoweb.common.BasePage;
import estudos.frameworkautomacaoweb.common.CommonFunctions;

public class GooglePage extends BasePage{
	public GooglePage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement searchField() {
		return waitVisibleElement(By.xpath("//*[@title='Pesquisar']"));
	}
	
	private WebElement firstResult() {
		return waitVisibleElement(By.cssSelector(".bkWMgd:nth-child(1) .LC20lb"));
	}
	
	private WebElement globoComLogo() {
		return waitVisibleElement(By.className("home-header__logo-desktop"));
	}
	
	public void searchSite(String searchText) {
		searchField().sendKeys(searchText + Keys.ENTER);
		firstResult().click();
	}
	
	public void validateGloboAccess() {
		try {
			if (!globoComLogo().equals(null)) {
				assertTrue(true);
			}
		}catch(Exception ex) {
			assertFalse(true);
		}
	}
	
	private WebElement techtudoLink() {
		return waitVisibleElement(By.cssSelector(".tech.widget-menu__list a"));
	}
	
	public void techtudoLinkClick() {
		techtudoLink().click();
	}
	

	public void validateTechTudoTitle() {
		assertTitles("TechTudo - A Tecnologia Descomplicada.",CommonFunctions.driver.getTitle());
	}
	
}
