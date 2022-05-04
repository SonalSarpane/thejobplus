package com.theJobPlus.runner;
//import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
//import in.automationtesting.practice.utility.ExtentReport;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/homePage.feature",
        glue = {"/Users/sonal/Documents/TheJobPlus/src/test/java/com.theJobPlus/stepDefinitions/HomeStepDefinations.java"},
        dryRun = true,
        monochrome = true,
        //tags = {"@login, @homepage"},
        tags = {"@smoke"}
)

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs cucumber Features", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void testDownClass() {
        testNGCucumberRunner.finish();
    }

}