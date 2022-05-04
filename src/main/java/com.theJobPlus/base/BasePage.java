package com.theJobPlus.base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

        protected WebDriver driver;
        private WebDriverWait wait;
        private JavascriptExecutor js;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            js = (JavascriptExecutor) driver;
            PageFactory.initElements(this.driver, this);
            wait = new WebDriverWait(this.driver, 20);
        }

        protected List<WebElement> getOptions(WebElement element) {
            Select loginDropdown = new Select(element);
            return loginDropdown.getOptions();
        }

        protected void waitForElementToBeVisible(WebElement element) {
            int attempts = 0;
            while (attempts < 2) {
                try {
                    wait.until(ExpectedConditions.visibilityOf(element));
                    break;
                } catch (Exception e) {
                    System.out.println("Element is not visible, hence retrying" +attempts);
                }
                attempts++;
            }
        }

        protected void waitForElementPresence(By element) {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        protected String waitForAlertPresense() {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        }

        protected void waitForAllElementsToBeVisible(List<WebElement> element) {
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
        }

        protected void writeText(String value, WebElement element) {
            element.sendKeys(value);
        }

        protected void pressKeyEnter(WebElement element) {
            element.sendKeys(Keys.ENTER);
        }

        protected void click(WebElement element) {
            element.click();
        }

        protected void smallSleep() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        protected List<String> getListElements(List<WebElement> elements, List<String> list) {
            for (WebElement element : elements) {
                list.add(element.getText());
            }
            return list;
        }
        protected void waitForElementToBeClickable(WebElement element) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        protected void scrollUpToElementToBeVisible(WebElement element)
        {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }
        protected void clickForAction(WebElement element) {
            Actions action=new Actions(driver);
            action.moveToElement(element).click().perform();
        }
        protected String getPageTitle() {
            return driver.getTitle();
        }
}
