Feature: Desafio Qa Automation

  Scenario: CT002-Alerts Frame e Windows na página inicial

    Given Acessar o site "https://demoqa.com/"
    And Escolher a opção Alerts, Frame & Windows na página inicial
    When Clicar no submenu Browser Windows
    And Clicar no botão new Windows
    Then Certifica-se que uma nova janela foi aberta, e validar a msg This is a sample page
    And Fechar a nova janela aberta