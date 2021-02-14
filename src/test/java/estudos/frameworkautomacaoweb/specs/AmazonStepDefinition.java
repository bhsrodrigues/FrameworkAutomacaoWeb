package estudos.frameworkautomacaoweb.specs;

import java.util.Map;


import estudos.frameworkautomacaoweb.common.CommonFunctions;
import estudos.frameworkautomacaoweb.drivermanager.SetUp;
import estudos.frameworkautomacaoweb.pages.AmazonPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonStepDefinition extends SetUp{

	AmazonPage amazonPage;
	private String book = null;
	
	@Given("^eu acesse a página \"([^\"]*)\"$")
	public void eu_acesse_a_página(String url) throws Throwable {
		setUpBrowser();
	    amazonPage = new AmazonPage(CommonFunctions.driver);
	    amazonPage.navigateTo(url);
	    
	}

	@Then("^o acesso ocorrerá com sucesso$")
	public void o_acesso_ocorrerá_com_sucesso() throws Throwable {
	    amazonPage.validateAmazonTitle();
	}

	@When("^eu pesquiso o livro \"([^\"]*)\"$")
	public void eu_pesquiso_o_livro(String book) throws Throwable {
	    this.book = book;
		amazonPage.searchBook(book);
	    
	}

	@When("^adiciono ao carrinho$")
	public void adiciono_ao_carrinho() throws Throwable {
	    amazonPage.addToCart(book);
	    amazonPage.validateAddToCartMessage();
	}

	@When("^acesso a página do carrinho$")
	public void acesso_a_página_do_carrinho() throws Throwable {
	    amazonPage.clickSeeCart();
	}

	@Then("^o produto será exibido na sacola$")
	public void o_produto_será_exibido_na_sacola() throws Throwable {
	    amazonPage.validateCart(book);
	}

	@When("^Eu acesso a página de login$")
	public void eu_acesso_a_página_de_login() throws Throwable {
		amazonPage.accessLoginScreen();
	}

	@When("^e informo dados de login inválidos$")
	public void e_informo_usuario_e_senha_inválidos(DataTable arg1) throws Throwable {
	    Map<String, String> loginMap = arg1.asMap(String.class, String.class);
	    amazonPage.fillLoginAmazon(loginMap);
	}

	@When("^clico em logar$")
	public void clico_em_logar() throws Throwable {
	    amazonPage.amazonLoginButtonClick();
	}

	@Then("^Eu vejo critica de usuário não cadastrado/inválido$")
	public void eu_vejo_critica_de_usuário_não_cadastrado_inválido() throws Throwable {
		amazonPage.validateWrongLogin();
	    tearDownBrowser();
	}

}
