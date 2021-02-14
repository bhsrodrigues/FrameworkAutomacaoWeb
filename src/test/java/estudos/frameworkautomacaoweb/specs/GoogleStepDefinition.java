package estudos.frameworkautomacaoweb.specs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import estudos.frameworkautomacaoweb.common.CommonFunctions;
import estudos.frameworkautomacaoweb.drivermanager.SetUp;
import estudos.frameworkautomacaoweb.pages.GooglePage;

public class GoogleStepDefinition extends SetUp{

	static GooglePage googlePage;
	
	@Given("^Eu esteja na página do Google$")
	public void eu_esteja_na_página_do_Google() throws Throwable {
	    setUpBrowser();
	    googlePage = new GooglePage(CommonFunctions.driver);
	    googlePage.navigateTo("https://www.google.com.br");
	}

	@When("^pesquiso pelo site \"([^\"]*)\"$")
	public void pesquiso_pelo_site(String site) throws Throwable {
	    googlePage.searchSite(site);
	}
	
	@Then("^será exibido o site pesquisado$")
	public void será_exibido_o_site_pesquisado() throws Throwable {
	    googlePage.validateGloboAccess();
	}

	@When("^Clico no link da tech tudo - tech$")
	public void clico_no_link_da_tech_tudo_tech() throws Throwable {
	    googlePage.techtudoLinkClick();
	}

	@Then("^será exibida a página do TechTudo com o título \"([^\"]*)\"$")
	public void será_exibida_a_página_do_TechTudo_com_o_título(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    googlePage.validateTechTudoTitle();
	    tearDownBrowser();
	}
	
}
