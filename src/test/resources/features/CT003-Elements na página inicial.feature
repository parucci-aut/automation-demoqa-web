Feature: Desafio Qa Automation

  Scenario: CT003-Elements na página inicial

    Given Acessar o site "https://demoqa.com/"
    And Escolher a opção Elements na página inicial
    When Clicar no submenu Web Tables
    And Criar um novo registro
    And Editar o novo registro criado
    And Deletar o novo registro criado.
    Then Criar 12 novos registros de forma dinâmica através do cucumber
    And Deletar todos os novos registros criados
