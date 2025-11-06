package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
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
//        quitDriver();

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
    public void fechar_a_nova_janela_aberta() throws IOException, InterruptedException {
        desafioPage.fecharNovaJanela();
        Thread.sleep(2000);
        Screenshot.takeScreenshot("CT002_Retornando_Tela_TOOLS_QA");

    }

    //#############################CT003-Elements na página inicial#############################//

    @Given("Escolher a opção Elements na página inicial")
    public void escolher_a_opção_elements_na_página_inicial() {
        desafioPage.opcaoElements();

    }

    @When("Clicar no submenu Web Tables")
    public void clicar_no_submenu_web_tables() throws IOException, InterruptedException {
        desafioPage.opcaoWebTable();
        Thread.sleep(1500);
        Screenshot.takeScreenshot("CT003-antes_criar_registro");

    }

    @When("Criar um novo registro")
    public void criar_um_novo_registro() throws IOException, InterruptedException {
        desafioPage.criarRegistro();
        Thread.sleep(1500);
        Screenshot.takeScreenshot("CT003-Novo_registro_incluido");

    }

    @When("Editar o novo registro criado")
    public void editar_o_novo_registro_criado() throws InterruptedException, IOException {
        desafioPage.editarRegistro();
        Thread.sleep(1500);
        Screenshot.takeScreenshot("CT003-Registro_alterado");

    }

    @When("Deletar o novo registro criado.")
    public void deletar_o_novo_registro_criado() throws IOException, InterruptedException {
        desafioPage.deleteRegistro();
        Thread.sleep(1500);
        Screenshot.takeScreenshot("CT003-Registro_deletado");

    }

    @Then("Criar {int} novos registros de forma dinâmica através do cucumber")
    public void criar_novos_registros_de_forma_dinâmica_através_do_cucumber(Integer qtd) throws InterruptedException, IOException {
        desafioPage.criarRegistroAleatorios(qtd);
        Thread.sleep(1500);
        desafioPage.scroolSelectRows();
        Screenshot.takeScreenshot("CT003-12_novos_registros");

    }

    @Then("Deletar todos os novos registros criados")
    public void deletar_todos_os_novos_registros_criados() throws InterruptedException, IOException {
        desafioPage.deletarRegistrosCriados();
        Screenshot.takeScreenshot("CT003-Todos_registros_foram_deletados");
    }

    //#############################CT004-Widgets na página inicial#############################//

    @Given("Escolher a opção Widgets na página inicial")
    public void escolher_a_opção_widgets_na_página_inicial() throws InterruptedException {
        desafioPage.opcaoWidgets();

    }

    @When("Clicar no submenu Progress Bar")
    public void clicar_no_submenu_progress_bar() throws InterruptedException {
        desafioPage.opcaoProgressBar();

    }

    @When("Clicar no botão Start")
    public void clicar_no_botão_start() {
        desafioPage.btnStar();
    }

    @When("Parar antes dos {int}%")
    public void parar_antes_dos(int porc) throws InterruptedException {
        desafioPage.pararAntes25(porc);
    }

    @Then("Validar que o valor da progress Bar é menor ou igual aos {int}%")
    public void validar_que_o_valor_da_progress_bar_é_menor_ou_igual_aos(int porc) {
        desafioPage.validarValorMenorOuIgualA25(porc);
    }

    @Then("Apertar Start novamente e ao chegar aos {int}%, resetar a progress bar")
    public void apertar_start_novamente_e_ao_chegar_aos_resetar_a_progress_bar(int porc) throws InterruptedException {
        desafioPage.apertarStartEEsperarReset(porc);

    }
}


