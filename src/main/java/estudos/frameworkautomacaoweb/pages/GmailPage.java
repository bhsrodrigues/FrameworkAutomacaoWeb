package estudos.frameworkautomacaoweb.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import estudos.frameworkautomacaoweb.common.BasePage;

public class GmailPage extends BasePage{
	
	public GmailPage(WebDriver driver) {
		super(driver);
	}
	
	/***
	 * Método para validar se é o campo de e-mail do Gmail está válido.
	 * @author Bruno Henrique
	 */
	public void validateGmailField() {
		if (!getElementAriaLabelValue(emailField()).equals(null)) {
			assertMessages("E-mail ou telefone", getElementAriaLabelValue(emailField()));
		}else {
			assertTrue(false);
		}
		
	}
	
	private WebElement nextButtonEmail() {
		return waitVisibleElement(By.id("identifierNext"));
	}
	
	private WebElement emailField() {
		return waitVisibleElement(By.id("identifierId"));
	}
	
	private WebElement passwordField() {
		return waitVisibleElement(By.xpath("//*[@type='password']"));
	}
	
	private WebElement nextButtonPassword() {
		return waitVisibleElement(By.id("passwordNext"));
	}
	
	public void fillEmail(Map<String, String> map) {
		emailField().sendKeys(map.get("email"));
		nextButtonEmail().click();
		passwordField().sendKeys(map.get("senha"));
		
	}
	
	private WebElement writeEmailButton() {
		return waitVisibleElement(By.xpath("//*[(@gh='cm') and (text()='Escrever')]"));
	}
	
	public void clickEnterEmailButton() {
		nextButtonPassword().click();
	}
	
	public void validateLogin() {
		assertMessages("escrever", writeEmailButton().getText().toLowerCase());
	}
	
	private WebElement fieldEmailTo() {
		return waitVisibleElement(By.xpath("//*[contains(@class,'aoD') and contains(@class,'hl')]"));
	}
	
	private WebElement inputEmailTo() {
		return waitVisibleElement(By.name("to"));
	}
	
	private WebElement fieldSubject() {
		return waitVisibleElement(By.xpath("//*[@placeholder='Assunto']"));
	}
	
	public void clickOnWriteButton() {
		writeEmailButton().click();
	}

	private WebElement emailText() {
		return waitVisibleElement(By.xpath("//*[@aria-label='Corpo da mensagem' and contains(@class,'editable')]"));
	}

	private WebElement buttonSentEmail() {
		return waitVisibleElement(By.xpath("//*[@role='button' and contains(text(),'Enviar')]"));
	}
	
	public void fillEmailMessage(Map<String,String> map) {
		/*if (!fieldEmailTo().equals(null)){
			fieldEmailTo().click();
		}*/
		inputEmailTo().sendKeys(map.get("para"));
		fieldSubject().sendKeys(map.get("assunto"));
		emailText().click();
		emailText().sendKeys(map.get("mensagem"));
	}

	private WebElement emailSentMessage() {
		return waitVisibleElement(By.xpath("//span[text()='Mensagem enviada.']"));
	}
	
	public void clickOnSentButton() {
		buttonSentEmail().click();
	}
	
	public void validateEmailSent() {
		assertTrue(!emailSentMessage().equals(null));
	}
	
	private WebElement buttonUserInfo() {
		return waitVisibleElement(By.xpath("//*[contains(@aria-label,'gmail.com)') and @role='button']"));
	}
	
	private WebElement linkLogout() {
		return waitVisibleElement(By.id("gb_71"));
	}
	
	public void logoutGmail() {
		buttonUserInfo().click();
		linkLogout().click();
	}
	
	//Processo para remover contas
	private WebElement removeAccountOption() {
		return waitVisibleElement(By.xpath("//div[contains(@class,'vR13fe') and contains(@class,'k6Zj8d') and contains(@class,'SmR8') and contains(.,'Remover uma conta')]"));
	}
	
	private List<WebElement> removeAccountList() {
		return waitAllVisibleElements(By.xpath("//*[@role='link']//*[@class='n3x5Fb']"));
	}
	
	private WebElement removeAccountConfirmationLink() {
		return waitVisibleElement(By.xpath("//*[contains(@class,'M9Bg4d')]//*[contains(@class,'RveJvd') and contains(.,'Sim, remover')]"));
	}
	
	private WebElement removeFirstAccountItem() {
		return waitVisibleElement(By.xpath("//*[@role='link']//*[@class='n3x5Fb'][1]"));
	}
	
	public void removeAccount() {
		
		int totalItens;
		
		try {
			totalItens = removeAccountList().size();
		}catch(org.openqa.selenium.TimeoutException ex) {
			totalItens = 0;
		}
		
		
		if (totalItens > 0) {
			removeAllAccounts(totalItens);
		}else {
			removeUniqueAccount();
			
		}
				
	}
	
	private void removeAllAccounts(int size) {
		for (int x = 0; x < size; x++) {
			removeProccess();
		}
		
	}
	
	private WebElement changeAccount() {
		return waitVisibleElement(By.xpath("//*[@aria-label='Alternar entre contas']"));
	}
	
	private void removeUniqueAccount(){
		changeAccount().click();
		try {
			Thread.sleep(5000);
		}catch(Exception ex) {
			
		}finally{
		
			removeProccess();
		}
	}
	
	private void removeProccess(){
		removeAccountOption().click();
		removeFirstAccountItem().click();
		removeAccountConfirmationLink().click();
	}
	
}
