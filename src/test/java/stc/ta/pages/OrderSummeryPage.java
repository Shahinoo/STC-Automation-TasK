package stc.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static stc.ta.stepDefs.Hooks.driver;

public class OrderSummeryPage {

    /**
     * Locators of the Order summer page
     */
    String summeryGroupClass = "//div[@class='summary-group']";
    private By paymentMethodHeader = By.xpath("//div[@class='option-group']/h3[@class='payment-header']");

    private By orderSummeryHeader = By.xpath("//div[@class='total']/h3[@class='payment-header']");
    private By selectedPlanText = By.xpath("//span[@id='order-tier-name']");
    private By selectedPlanPriceAndCurrency = By.xpath("//span[@id='order-tier-price']");
    private By totalPriceAndCurrency = By.xpath("//span[@id='order-total-price']");
    private By nextForChoosingMethodBTN = By.xpath(summeryGroupClass + "//button[@id='btnChoosePaymentMethod']");

    private By discoveryAddonCardImg = By.className("card-img");
    private By discoveryPriceText = By.id("order-discovery+-addon-price");
    private By discoveryAddonNameForPremium = By.id("order-discovery+-addon-name");

    /**
     * get Web elements to use in the assertions
     */
    public WebElement paymentMethodHeaderWebEle() {
        return driver.findElement(paymentMethodHeader);
    }

    public WebElement orderSummeryHeaderWebEle() {
        return driver.findElement(orderSummeryHeader);
    }

    public WebElement selectedPlanTitleWebEle() {
        return driver.findElement(selectedPlanText);
    }

    public WebElement selectedPlanPriceAndCurrencyWebEle() {
        return driver.findElement(selectedPlanPriceAndCurrency);
    }

    public WebElement totalPriceAndCurrencyWebEle() {
        return driver.findElement(totalPriceAndCurrency);
    }

    public WebElement getDiscoveryPriceWebEle() {
        return driver.findElement(discoveryPriceText);
    }

    public WebElement getDiscoveryAddonCardImgWebEle() {
        return driver.findElement(discoveryAddonCardImg);
    }

    public WebElement getDiscoveryAddonNameForPremiumWebEle() {
        return driver.findElement(discoveryAddonNameForPremium);
    }

    /**
     * Functions of the order summer page
     */
    public void clickOnNextAfterSelectMethod() {
        driver.findElement(nextForChoosingMethodBTN).click();
    }

    public void clickOnDiscoveryAddonCardImg() {
        driver.findElement(discoveryAddonCardImg).click();
    }
}
