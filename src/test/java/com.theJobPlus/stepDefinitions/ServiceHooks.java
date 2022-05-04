package com.theJobPlus.stepDefinitions;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.theJobPlus.base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ServiceHooks<TestContext> {

    private BaseTest baseTest;
    TestContext testContext;

    public ServiceHooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void init() {
        baseTest = new BaseTest();
        baseTest.initialization();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        Reporter.assignAuthor("WebsiteAutomation - Sonal Sarpane Londhe");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                File sourcePath = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                Files.copy(sourcePath, destinationPath);
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
            }
        }
    }

    @After(order = 0)
    public void AfterSteps() {
        baseTest.tearDown();
    }
}
