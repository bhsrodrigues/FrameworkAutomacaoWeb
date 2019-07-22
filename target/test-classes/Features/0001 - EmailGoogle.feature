#Author: Bruno Henrique (bhsrodrigues)

@tudo @google @gmail
Feature: Envio de Email via Google (Gmail)
  Como usuário de email do google, desejo acessar e enviar um email via Gmail

  Scenario: 0001 - Efetuar login
    Given Eu esteja na página de login do Gmail
    When Eu informo meus dados de login
      | email | bhsrodriguesteste@gmail.com |
      | senha |                             |
    And clico no botão login
    Then Eu acesso meu e-mail com sucesso

  Scenario: 0002 - Enviar email
    Given Eu esteja na página do Gmail
    When Eu clico no botão escrever
    And Preencho os dados do email
      | para     | bhsrodriguesteste@gmail.com |
      | assunto  | E-mail de teste             |
      | mensagem | Este é um email de teste    |
    And Clico em enviar
    Then O email será enviado com sucesso

	Scenario: 0003 - Realizar logout
		Given Eu esteja logado no Gmail
		When clico na opção de logout
			And removo minha conta
		Then será exibido campo para acessar email novamente