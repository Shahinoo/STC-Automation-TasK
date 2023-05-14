package stc.ta.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions

        (
                features = "src/main/resources/features",
                glue = "stc.ta.stepDefs",
                tags = "@smoke",
                plugin = {"pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cukes.xml",
                        "rerun:target/rerun.txt"
                }
        )
public class Runner extends AbstractTestNGCucumberTests {
}
