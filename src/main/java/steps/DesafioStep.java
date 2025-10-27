package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DesafioPage;
import utils.Screenshot;
import java.io.IOException;

import static utils.SetupDriver.quitDriver;


public class DesafioStep {


   DesafioPage desafioPage = new DesafioPage();

   @After
   public void fechar(){
      quitDriver();
   }


   @Given("Acessar o site {string}")
    public void acessar_o_site(String site) {
    desafioPage.acessarSite(site);
    System.out.println("Pagina acessada");

    }
    @Given("Escolher a opção Forms na página inicial")
    public void escolher_a_opção_forms_na_página_inicial() {
    desafioPage.acessarTelaForms();
    System.out.println("Pagina Forms selecionada");
    }

    @Given("Clicar no submenu Practice Form")
    public void clicar_no_submenu_practice_form() {
    desafioPage.acessarTelaPracticeForm();
    System.out.println("Menu selecionado Practice Form");

    }
    @When("Preencher todo o formulário com valores aleatórios")
    public void preencher_todo_o_formulário_com_valores_aleatórios() throws InterruptedException {
    desafioPage.preencherFormulario();
    System.out.println("Formulario preenchido");

    }
    @When("O Arquivo utilizado para upload, precisa ser um .txt qualquer, e precisa estar na devida pasta do github ao ser publicado o projeto")
    public void o_arquivo_utilizado_para_upload_precisa_ser_um_txt_qualquer_e_precisa_estar_na_devida_pasta_do_github_ao_ser_publicado_o_projeto() {
    desafioPage.anexarArquivo();
    System.out.println("Arquivo anexado");

    }
    @When("Submter o formulário")
    public void submter_o_formulário() {
    desafioPage.btnSubmit();
    System.out.println("Formulario submetido");

    }
    @Then("Garantir que um popup foi aberto após o submit")
    public void garantir_que_um_popup_foi_aberto_após_o_submit() throws IOException, InterruptedException {
    Thread.sleep(2000);
    Screenshot.takeScreenshot("TelaPopUp");
    Thread.sleep(2000);
    desafioPage.validarPopUp();
    System.out.println("PopUp validado");
    }

    @Then("Fechar o popup")
    public void fechar_o_popup() {
    desafioPage.fecharPopUp();
    System.out.println("PopUp fechado");

    }

}
