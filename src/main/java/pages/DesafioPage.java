package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static utils.SetupDriver.getDriver;

public class DesafioPage {

    private WebDriver driver;

    public DesafioPage() {

        this.driver = getDriver();
    }



    //CT001 - CT001-Forms da paginal inicial
    // Metodos de cada steps
    public void acessarSite(String site){
        driver.get(site);
    }

    public void acessarTelaForms(){
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
    public void anexarArquivo(){
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\SanclerParucciDaCost\\IdeaProjects\\Qa-Automation\\src\\test\\resources\\file\\automacao.txt");
    }

    public void btnSubmit(){

        driver.findElement(By.id("submit")).click();
    }

    public void validarPopUp(){
        String popup = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        assertEquals("Thanks for submitting the form", popup);
    }

    public void fecharPopUp(){

        driver.findElement(By.id("closeLargeModal")).click();
    }


}