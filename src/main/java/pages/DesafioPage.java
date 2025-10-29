package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utils.SetupDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static utils.SetupDriver.getDriver;

public class DesafioPage {

    private WebDriver driver;


    public DesafioPage() {

        this.driver = getDriver();
    }

    // ============================== Registros aleatorios ==============================
    private String nomeAleatorio() {
        String[] nomes = {"Ricardo", "Otavio", "Antonio", "Sergio", "Marcos", "Bruna", "Bruno", "Sonia", "Igor", "Juliana", "Kleber", "Ana"};
        return nomes[new Random().nextInt(nomes.length)];
    }

    private String sobrenomeAleatorio() {
        String[] sobrenomes = {"Costa", "Souza", "Rodrigues", "Silva", "Zidane", "Messi", "Pereira", "Acosta", "Correa", "Souza", "Perez", "Costacurta"};
        return sobrenomes[new Random().nextInt(sobrenomes.length)];
    }

    private String departamentoAleatorio() {
        String[] departamentos = {"QA", "Dev", "RH", "Financeiro", "Vendas", "Marketing", "Diretor", "Desempregado", "Analista", "Infraestrutura"};
        return departamentos[new Random().nextInt(departamentos.length)];
    }


    //#############################CT001 - CT001-Forms da paginal inicial#############################//
    // Metodos //
    public void acessarSite(String site) {
        driver.get(site);
    }

    public void acessarTelaForms() {
        driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[2]/div/div[3]/h5")).click();
    }

    public void acessarTelaPracticeForm() {

        driver.findElement(By.xpath("//*[text()='Practice Form']")).click();
    }

    public void preencherFormulario() throws InterruptedException {
        driver.findElement(By.id("firstName")).sendKeys("Sancler");
        driver.findElement(By.id("lastName")).sendKeys("Parucci");
        driver.findElement(By.id("userEmail")).sendKeys("san.parucci@gmail.com");
        driver.findElement(By.xpath("//*[text()='Male']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0949177617");

        //Selecionar mês e dia no calendario
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement SelectCalendario = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(SelectCalendario);
        select.selectByIndex(9);
        Thread.sleep(2000);

        WebElement selectDia = driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[5]"));
        JavascriptExecutor ScrollDia = (JavascriptExecutor) driver;
        ScrollDia.executeScript("arguments[0].scrollIntoView(true);", selectDia);
        driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[5]")).click();

        //Scroll e preenchimento para o campo Subject
        WebElement ScrollCampoSubject = driver.findElement(By.xpath("//*[@id='subjectsContainer']/div/div[1]"));
        JavascriptExecutor Scroll = (JavascriptExecutor) driver;
        Scroll.executeScript("arguments[0].scrollIntoView(true);", ScrollCampoSubject);

        driver.findElement(By.id("subjectsInput")).click();
        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label")).click();

        //Sroll para o final da pagina
        JavascriptExecutor scrollFinalPagina = (JavascriptExecutor) driver;
        scrollFinalPagina.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        driver.findElement(By.id("currentAddress")).sendKeys("Automação Web");

        //campo "State"
        driver.findElement(By.xpath("//*[@id='state']/div/div[1]")).click();
        driver.findElement(By.id("react-select-3-input")).sendKeys("ncr");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);

        //Select do campos "City"
        driver.findElement(By.xpath("//*[@id='city']/div/div[1]")).click();
        driver.findElement(By.id("react-select-4-input")).sendKeys("Noida");
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    //Anexando arquivo
    public void anexarArquivo() {
        Path caminho = Paths.get("src", "test", "resources", "file", "automacao.txt");
        String localArquivo = caminho.toAbsolutePath().toString();
        driver.findElement(By.id("uploadPicture")).sendKeys(localArquivo);

    }

    public void btnSubmit() {
        driver.findElement(By.id("submit")).click();
    }

    public void validarPopUp() {
        String popup = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        assertEquals("Thanks for submitting the form", popup);
    }

    public void fecharPopUp() {
        driver.findElement(By.id("closeLargeModal")).click();
    }

    //#############################CT002-Alerts, Frame e Windows na página inicial#############################//
    // Metodos //

    public void opcaoAlertsFrameWindows() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]/h5")).click();
    }

    public void opcaoSubMenuBrowserWindows() {
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();
    }

    public void btnNewWindows() {
        driver.findElement(By.id("windowButton")).click();
    }


    public void validarMsgNovaJanela() {
        SetupDriver.setNavegadorPrincipal(driver.getWindowHandle());
        for (String novaJanela : driver.getWindowHandles()) {
            if (!novaJanela.equals(driver.getWindowHandle())) {
                driver.switchTo().window(novaJanela);
            }
        }

        String mensagem = driver.findElement(By.id("sampleHeading")).getText();
        assertEquals(mensagem, "This is a sample page");
        System.out.println(mensagem);

    }

    public void fecharNovaJanela() {
        driver.close();
        driver.switchTo().window(SetupDriver.getNavegadorPrincipal());
        String menuAlertsFrameWindows = driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).getText();
        assertEquals(menuAlertsFrameWindows, "Alerts, Frame & Windows");
        driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();
        System.out.println(menuAlertsFrameWindows);
    }

    //#############################CT003-Elements na página inicial#############################//

    public void opcaoElements() {
        driver.findElement(By.xpath("//*[text()='Elements']")).click();

    }

    public void opcaoWebTable() throws InterruptedException {
        driver.findElement(By.id("item-3")).click();

    }

    public void criarRegistro() throws InterruptedException {
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Sancler");
        driver.findElement(By.id("lastName")).sendKeys("Parucci");
        driver.findElement(By.id("userEmail")).sendKeys("sancler@teste.com.br");
        driver.findElement(By.id("age")).sendKeys("44");
        driver.findElement(By.id("salary")).sendKeys("12000");
        driver.findElement(By.id("department")).sendKeys("Manager QA");
        driver.findElement(By.id("submit")).click();


    }

    public void editarRegistro() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td' and text()='Sancler']" +
                "/ancestor::div[@class='rt-tr-group']//span[@title='Edit']")).click();

        driver.findElement(By.id("firstName")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.findElement(By.id("lastName")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.findElement(By.id("userEmail")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.findElement(By.id("age")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.findElement(By.id("salary")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.findElement(By.id("department")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        Thread.sleep(2000);

        driver.findElement(By.id("firstName")).sendKeys("Marcos");
        driver.findElement(By.id("lastName")).sendKeys("Pereira");
        driver.findElement(By.id("userEmail")).sendKeys("marcoaurelio@teste.com.br");
        driver.findElement(By.id("age")).sendKeys("20");
        driver.findElement(By.id("salary")).sendKeys("1200");
        driver.findElement(By.id("department")).sendKeys("Estagiario");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();

    }

    public void deleteRegistro() {
        driver.findElement(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td' and text()='Marcos']" +
                "/ancestor::div[@class='rt-tr-group']//span[@title='Delete']")).click();
    }

    public void criarRegistroAleatorios(Integer qtd) throws InterruptedException {
        for (int i = 1; i <= qtd; i++) {
            driver.findElement(By.id("addNewRecordButton")).click();

            String firstName = nomeAleatorio();
            String lastName = sobrenomeAleatorio();
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@automacao.com";
            String departamento = departamentoAleatorio();
            int age = ThreadLocalRandom.current().nextInt(18, 65);
            int salary = ThreadLocalRandom.current().nextInt(1500, 35000);

            driver.findElement(By.id("firstName")).sendKeys(firstName);
            driver.findElement(By.id("lastName")).sendKeys(lastName);
            driver.findElement(By.id("userEmail")).sendKeys(email);
            driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
            driver.findElement(By.id("salary")).sendKeys(String.valueOf(salary));
            driver.findElement(By.id("department")).sendKeys(departamento);
            Thread.sleep(500);


            driver.findElement(By.id("submit")).click();
            Thread.sleep(500);

        }

    }

    public void scroolSelectRows() throws InterruptedException {

        WebElement SelectPagina = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"));
        WebElement btnAdicionar = driver.findElement(By.id("addNewRecordButton"));

        //Scroll Down até Rows
        JavascriptExecutor ScrollDown = (JavascriptExecutor) driver;
        ScrollDown.executeScript("arguments[0].scrollIntoView(true);", SelectPagina);

        //Selecionar paginação de 20
        SelectPagina.click();
        Select select = new Select(SelectPagina);
        select.selectByIndex(2);
        Thread.sleep(1500);

        //Scrool Up até botão Add
        JavascriptExecutor ScrollUp = (JavascriptExecutor) driver;
        ScrollUp.executeScript("arguments[0].scrollIntoView(true);", btnAdicionar);
        Thread.sleep(1500);

    }

    public void deletarRegistrosCriados() throws InterruptedException {
        Thread.sleep(3000);

        // Cada linha de registro está dentro de div.rt-tr-group
        List<WebElement> registros = driver.findElements(By.xpath("//div[contains(@class,'rt-tr-group')]"));
        boolean encontrou = false;

        // Enquanto ainda existir linha com e-mail de automação
        while (!registros.isEmpty()) {
            boolean deletouNaIteracao = false;

            for (WebElement linha : registros) {
                try {
                    List<WebElement> colunaEmail = linha.findElements(By.xpath(".//div[@class='rt-td']"));
                    if (colunaEmail.size() < 4) continue; // pula linhas vazias

                    String email = colunaEmail.get(3).getText(); // coluna 4 = e-mail

                    if (email.endsWith("@automacao.com")) {
                        encontrou = true;

                        // Clica no botão de deletar dentro da mesma linha
                        WebElement btnDelete = linha.findElement(By.xpath(".//span[@title='Delete']"));
                        btnDelete.click();

                        System.out.println("Deletado: " + email);
                        Thread.sleep(400);
                        deletouNaIteracao = true;
                        break; // recarrega a lista depois de cada exclusão
                    }
                } catch (StaleElementReferenceException e) {
                    // DOM recarregou, apenas ignora e recarrega
                }
            }

            // Recarrega as linhas após uma exclusão
            if (deletouNaIteracao) {
                registros = driver.findElements(By.xpath("//div[contains(@class,'rt-tr-group')]"));
            } else {
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum registro com provedor de email @automacao.com foram encontrados.");
        } else {
            System.out.println("Todos os registros com provedor de email @automação.com foram deletados!");
        }
    }


}






