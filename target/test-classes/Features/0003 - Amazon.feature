@tudo @amazon
Feature: Utilizar serviços da Amazon
  I want to use this template for my feature file

	Background: Eu esteja na página da Amazon
		Given eu acesse a página "https://www.amazon.com.br/"
		Then o acesso ocorrerá com sucesso

  @selecionarproduto
  Scenario: Adicionar produto na sacola
    When eu pesquiso o livro "A Dança da Morte"
    	And adiciono ao carrinho
    	And acesso a página do carrinho
    Then o produto será exibido na sacola

  @loginincorreto
  Scenario: Login sem sucesso
    When Eu acesso a página de login
    	And e informo dados de login inválidos
    	| email | bhsrodriguesteste@gmail.com |
      | senha | Senhaincorreta              | 
    	And clico em logar
    Then Eu vejo critica de usuário não cadastrado/inválido

      