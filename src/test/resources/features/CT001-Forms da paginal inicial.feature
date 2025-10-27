Feature: Desafio Qa Automation

  Scenario: CT001-Forms da paginal inicial

  Given Acessar o site "https://demoqa.com/"
  And Escolher a opção Forms na página inicial
  And Clicar no submenu Practice Form
  When Preencher todo o formulário com valores aleatórios
  And O Arquivo utilizado para upload, precisa ser um .txt qualquer, e precisa estar na devida pasta do github ao ser publicado o projeto
  And Submter o formulário
  Then Garantir que um popup foi aberto após o submit
  And Fechar o popup
