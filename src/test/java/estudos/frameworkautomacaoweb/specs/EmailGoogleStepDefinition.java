package estudos.frameworkautomacaoweb.specs;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import estudos.frameworkautomacaoweb.common.CommonFunctions;
import estudos.frameworkautomacaoweb.drivermanager.SetUp;
import estudos.frameworkautomacaoweb.pages.GmailPage;

public class EmailGoogleStepDefinition extends SetUp{
	
	private static GmailPage gmailPage;
	
	@Given("^Eu esteja na página de login do Gmail$")
	public void eu_esteja_na_página_de_login_do_Gmail() throws Throwable {
		setUpBrowser();
		gmailPage = new GmailPage(CommonFunctions.driver);
		gmailPage.navigateTo("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
	}

	@When("^Eu informo meus dados de login$")
	public void eu_informo_meus_dados_de_login(DataTable arg1) throws Throwable {
		Map<String,String> map = arg1.asMap(String.class, String.class);
		gmailPage.fillEmail(map);
	}
	
	@When("^clico no botão login$")
	public void clico_no_botão_login() throws Throwable {
	    gmailPage.clickEnterEmailButton();
	}

	@Then("^Eu acesso meu e-mail com sucesso$")
	public void eu_acesso_meu_e_mail_com_sucesso() throws Throwable {
		gmailPage.validateLogin();
	}
	
	@Given("^Eu esteja na página do Gmail$")
	public void eu_esteja_na_página_do_Gmail() throws Throwable {
		
	}

	@When("^Eu clico no botão escrever$")
	public void eu_clico_no_botão_escrever() throws Throwable {
		gmailPage.clickOnWriteButton();
	}

	@When("^Preencho os dados do email$")
	public void preencho_os_dados_do_email(DataTable arg1) throws Throwable {
	    Map<String, String> list = arg1.asMap(String.class, String.class);
	    gmailPage.fillEmailMessage(list);
	}

	@When("^Clico em enviar$")
	public void clico_em_enviar() throws Throwable {
		gmailPage.clickOnSentButton();
	}

	@Then("^O email será enviado com sucesso$")
	public void o_email_será_enviado_com_sucesso() throws Throwable {
		gmailPage.validateEmailSent();
	}
	
	@Given("^Eu esteja logado no Gmail$")
	public void eu_esteja_logado_no_Gmail() throws Throwable {
	}

	@When("^clico na opção de logout$")
	public void clico_na_opção_de_logout() throws Throwable {
		gmailPage.logoutGmail();
	}

	@When("^removo minha conta$")
	public void removo_minha_conta() throws Throwable {
		gmailPage.removeAccount();
	}

	@Then("^será exibido campo para acessar email novamente$")
	public void será_exibido_campo_para_acessar_email_novamente() throws Throwable {
		gmailPage.validateGmailField();
		tearDownBrowser();
	}

}
