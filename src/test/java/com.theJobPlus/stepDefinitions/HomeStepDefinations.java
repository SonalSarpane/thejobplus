package com.theJobPlus.stepDefinitions;

import com.theJobPlus.base.BaseTest;
import com.theJobPlus.pages.homepage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeStepDefinations extends BaseTest {

    private homepage h1;
    @When("^I opened the browser and enterend the URL$")
    public void i_opened_the_browser_and_enterend_the_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       System.out.println("hello");
    }

    @When("^I click on Shop Menu$")
    public void i_click_on_Shop_Menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("hello");
    }

    @Then("^click on Home menu button$")
    public void click_on_Home_menu_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("hello");
    }

    @Then("^verify whether the everything works fine$")
    public void verify_whether_the_everything_works_fine() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("hello");
    }
}
