# Projeto Framework Web (Selenium + Java)

Projeto de Framework para automção Web com usando Selenium, Java e Cucumber.

Observações para execução local

- O projeto foi criado e atualizado usando o Eclipse IDE, com isso é recomendado usar a mesma ferramenta;
- Nesta última atualização foi usada a versão 21 do Java, então caso necessário, abra a configurações de Java Build Path em `Botão direito sobre o projeto > Build Path > Configure Build Path > Java Build Path > Aba Libraries` e atualizar as informações do JRE System Library para as seguintes versão correspondente do Java JDK.
- Ocasionalmente o Eclipse atualiza o o path "FrameworkWebAutomacaoWeb/src" ao atualizar dependências do build. Caso isso ocorra, é necessário remover essa opção no Java Build Path, então basta acessar `Botão direito sobre o projeto > Build Path > Configure Build Path > Java Build Path > Aba Source`. 
- Por precaução, no path "FrameworkWebAutomacaoWebsrc/main/java", verifique se os filtros `**/*.java` e `**/*RunTest.java` estão salvos na configuração `"Included"`

Atualizações previstas para o período 2025 ~ 2026: 

| Módulo                    								| Status        |
|-----------------------------------------------------------|---------------|
| Uso do Chrome For Testing para navegação com Chrome 		| Done [^1]	 	|
| Atualização de dependências/POM.xml						| Done [^2]		|
| Inserção de outros navegadores							| In Progress	|
| Refactor da gestão de driver 								| In Progress	|
| Atualização da versão do Java								| Done			|
| Refactor de códigos do Java e Selenium (quando aplicavel)	| To Do			|
| Criação de novas features para prática					| To Do			|
| Possibilidade de ler o navegador via arquivo de configuração e/ou POM.xml | To Do (estudo de viabilidade) |

[^1]: Para a alteração do Chrome For Testing e a correta execução e compatibilidade com o `chromedriver` usado no projeto é necessário efetuar o download da versão [139.0.7258.66 do Chrome for Testing] (https://storage.googleapis.com/chrome-for-testing-public/139.0.7258.66/win64/chrome-win64.zip)  e extrair os arquivos no diretório `Navegador\chrome` localizado no projeto.

[^2]: Por conta da mudança de como é integrado o Cucumber com o JUnit 5, apenas dependências do Cucumber, Selenium e a própria versão de target do Java foram  no POM.xml neste momento. Futuramente - provavelmente em outro projeto/repositório - será inserido o JUnit 5 com demais dependências atualizadas. 