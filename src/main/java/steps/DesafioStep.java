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
    public void fechar() {
        quitDriver();
    }


 //#############################CT001 - CT001-Forms da paginal inicial#############################//

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
        Screenshot.takeScreenshot("CT001_Tela_PopUp");
        Thread.sleep(2000);
        desafioPage.validarPopUp();
        System.out.println("PopUp validado");
    }

    @Then("Fechar o popup")
    public void fechar_o_popup() {
        desafioPage.fecharPopUp();
        System.out.println("PopUp fechado");

    }

 //#############################CT002-Alerts, Frame e Windows na página inicial#############################//

    @Given("Escolher a opção Alerts, Frame & Windows na página inicial")
    public void escolher_a_opção_alerts_frame_windows_na_página_inicial() {
        desafioPage.opcaoAlertsFrameWindows();
    }

    @When("Clicar no submenu Browser Windows")
    public void clicar_no_submenu_browser_windows() {
        desafioPage.opcaoSubMenuBrowserWindows();

    }

    @When("Clicar no botão new Windows")
    public void clicar_no_botão_new_windows() {
        desafioPage.btnNewWindows();

    }

    @Then("Certifica-se que uma nova janela foi aberta, e validar a msg This is a sample page")
    public void certifica_se_que_uma_nova_janela_foi_aberta_e_validar_a_msg_this_is_a_sample_page() throws IOException {
        desafioPage.validarMsgNovaJanela();
        Screenshot.takeScreenshot("CT002_Validacao_Mensagem");

    }

    @Then("Fechar a nova janela aberta")
    public void fechar_a_nova_janela_aberta() throws IOException {
        desafioPage.fecharNovaJanela();
        Screenshot.takeScreenshot("CT002_Retornando_Tela_TOOLS_QA");

    }


}
