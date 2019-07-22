package estudos.frameworkautomacaoweb.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import estudos.frameworkautomacaoweb.common.BasePage;

public class AmazonPage extends BasePage{

	public AmazonPage(WebDriver driver) {
		super(driver);
	}
	
	public void validateAmazonTitle() {
		takeScreenshotFullScreen(true);
		assertTitles("Amazon.com.br: compre celulares, TVs, computadores, livros, eBooks, e-readers Kindle e mais", getWebPageTitle());
	}
	
	private WebElement searchField() {
		return waitVisibleElement(By.id("twotabsearchtextbox"));
	}
	
	private List<WebElement> allResults(){
		return waitAllVisibleElements(By.xpath("//*[contains(@class,'a-section') and contains(@class,'a-spacing-medium')]//h2[contains(@class,'s-line-clamp-2')]/a"));
	}
	
	public void searchBook(String book) throws Exception {
		searchField().sendKeys(book);
		takeScreenshotFullScreen(true);
		searchField().sendKeys(Keys.ENTER);
		
	}
	
	private WebElement addToCartButton() {
		return waitVisibleElement(By.id("add-to-cart-button"));
	}
	
	public void addToCart(String book) {
		for(WebElement element : allResults()) {
			if (element.getText().toLowerCase().contains(book.toLowerCase())) {
				takeScreenshotFullScreen(false);
				element.click();
				break;
			}
		}
		takeScreenshotFullScreen(false);
		addToCartButton().click();
	}
	
	private WebElement addToCartMessage() {
		return waitVisibleElement(By.cssSelector(".a-size-medium.a-text-bold"));
	}
	
	private WebElement seeCart() {
		return waitVisibleElement(By.id("hlb-view-cart-announce"));
	}
	
	public void validateAddToCartMessage() {
		takeScreenshotFullScreen(true);
		assertMessages("Adicionado ao carrinho", addToCartMessage().getText().trim());
		
	}
	
	private List<WebElement> listProductsInCart(){
		return waitAllVisibleElements(By.xpath("//*[contains(@class,'a-unordered-list')]//*[@class='a-list-item']//a[contains(@class,'sc-product-link')]"));
	}
	
	public void clickSeeCart() {
		seeCart().click();
		takeScreenshotFullScreen(true);
	}
	
	public void validateCart(String book) {
		boolean found = false;
		for(WebElement bookOpt : listProductsInCart()) {
			if (bookOpt.getText().toLowerCase().trim().equals(book.toLowerCase().trim())) {
				found = true;
			}
		}
		assertTrue(found);
	}

	/*--- LOGIN INCORRETO ---*/
	private WebElement loginOptionLink() {
		return waitVisibleElement(By.id("nav-link-accountList"));
	}
	
	public void accessLoginScreen() {
		loginOptionLink().click();
	}
	
	private WebElement userLogin() {
		return waitVisibleElement(By.id("ap_email"));
	}
	
	private WebElement passwordLogin() {
		return waitVisibleElement(By.id("ap_password"));
	}
	
	public void fillLoginAmazon(Map<String, String> userDataLogin) {
		userLogin().sendKeys(userDataLogin.get("email"));
		passwordLogin().sendKeys(userDataLogin.get("senha"));
	}
	
	private WebElement loginButton() {
		return waitVisibleElement(By.id("signInSubmit"));
	}
	
	public void amazonLoginButtonClick() {
		loginButton().click();
		takeScreenshotFullScreen(false);
	}
	
	private WebElement haveAProblemMistake() {
		return waitVisibleElement(By.className("a-alert-heading"));
	}
	
	public void validateWrongLogin() {
		assertMessages("Houve um problema", haveAProblemMistake().getText());
		takeScreenshotFullScreen(true);
	}
	
}
