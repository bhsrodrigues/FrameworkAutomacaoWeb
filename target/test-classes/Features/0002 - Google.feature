#Author: Bruno Henrique (bhsrodrigues)

@tudo @google @pesquisa
Feature: Pesquisa no Google
  Eu pretendo realizar uma pesquisa no Google e navegar no site encontrado

	@pesquisaglobo
  Scenario: Pesquisa no Google
  	Given Eu esteja na página do Google
  	When pesquiso pelo site "globo.com"
  	Then será exibido o site pesquisado

	@techtudo
  Scenario: Acessar o Tech Tudo
    When Clico no link da tech tudo - tech
    Then será exibida a página do TechTudo com o título "TechTudo - A Tecnologia Descomplicada"