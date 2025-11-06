Feature: Desafio Qa Automation

  @tag
  Scenario: CT004-Widgets na página inicial

    Given Acessar o site "https://demoqa.com/"
    And Escolher a opção Widgets na página inicial
    When Clicar no submenu Progress Bar
    And Clicar no botão Start
    And Parar antes dos 25%
    Then Validar que o valor da progress Bar é menor ou igual aos 25%
    And Apertar Start novamente e ao chegar aos 100%, resetar a progress bar

