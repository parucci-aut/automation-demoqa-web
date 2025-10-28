import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

import static utils.SetupDriver.quitDriver;


@RunWith(Cucumber.class)
    @CucumberOptions(

           features = "src/test/resources/features/",
            plugin = {"pretty"},
//            tags = "@tag",
            monochrome = false
            //tags = {""}

    )

public class DesafioRunner {


}