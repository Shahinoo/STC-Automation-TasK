package stc.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static stc.ta.stepDefs.Hooks.driver;

public class SubscribePackagePage {

    /**
     * Locators of Subscribe page
     */
    private By countryList = By.id("country-name");
    private By enLanguageBTN = By.linkText("English");
    private By saudiCountry = By.id("sa");
    private By bahrainCountry = By.id("bh");
    private By kuwaitCountry = By.id("kw");
    // lite plan locators
    private By litePlanTitle = By.id("name-lite");
    private By litePrice = By.xpath("//*[@id=\"currency-lite\"]/b");
    private By liteCurrency = By.cssSelector("div#currency-classic > i");
    private By startLiteTrialBtn = By.id("lite-selection");
    // classic plan locators
    private By classicPlanTitle = By.id("name-classic");
    private By classicPrice = By.xpath("//*[@id=\"currency-classic\"]/b");
    private By classicCurrency = By.cssSelector("div#currency-lite > i");
    private By startClassicTrialBtn = By.id("classic-selection");
    // premium plan locators
    private By premiumPlanTitle = By.id("name-premium");
    private By premiumPrice = By.xpath("//*[@id=\"currency-premium\"]/b");
    private By premiumCurrency = By.cssSelector("div#currency-premium > i");
    private By startPremiumTrialBtn = By.id("premium-selection");
    // discovery addon locators
    private String discoveryAddonValue = "//div[@class='plan-section extensions']//div[2]//div[2]//div";
    private By discoveryAddonValueOfLite = By.xpath(discoveryAddonValue + "[1]");
    private By discoveryAddonValueOfClassic = By.xpath(discoveryAddonValue + "[2]");
    private By discoveryAddonValueOfPremium = By.xpath(discoveryAddonValue + "[3]");

    /**
     * get Web elements to use it in the assertions
     */
    public WebElement litePlanTitleWebEle() {
        return driver.findElement(litePlanTitle);
    }

    public WebElement classicPlanTitleWebEle() {
        return driver.findElement(classicPlanTitle);
    }

    public WebElement premiumPlanTitleWebEle() {
        return driver.findElement(premiumPlanTitle);
    }

    public WebElement litePlanPriceWebEle() {
        return driver.findElement(litePrice);
    }

    public WebElement classicPlanPriceWebEle() {
        return driver.findElement(classicPrice);
    }

    public WebElement premiumPlanPriceWebEle() {
        return driver.findElement(premiumPrice);
    }

    public WebElement litePlanCurrencyWebEle() {
        return driver.findElement(liteCurrency);
    }

    public WebElement classicPlanCurrencyWebEle() {
        return driver.findElement(classicCurrency);
    }

    public WebElement premiumPlanCurrencyWebEle() {
        return driver.findElement(premiumCurrency);
    }

    public WebElement discoveryLiteValueWebEle() {
        return driver.findElement(discoveryAddonValueOfLite);
    }

    public WebElement discoveryClassicValueWebEle() {
        return driver.findElement(discoveryAddonValueOfClassic);
    }

    public WebElement discoveryPremiumValueWebEle() {
        return driver.findElement(discoveryAddonValueOfPremium);
    }

    /**
     * Functions of Subscribe page
     * 1. navigate
     * 2. select a Country
     * 3. select a plan
     */
    public void navigateToSubscriptionPage() {
        driver.navigate().to("https://subscribe.stctv.com/sa-ar");
    }

    /**
     * this function for selecting a Country based on the examples data
     *
     * @param country
     */
    public void selectCountry(String country) {
        driver.findElement(enLanguageBTN).click();
        driver.findElement(countryList).click();
        switch (country) {
            case "saudi arabia":
                driver.findElement(saudiCountry).click();
                System.out.println(country);
                break;
            case "bahrain":
                driver.findElement(bahrainCountry).click();
                System.out.println(country);
                break;
            case "kuwait":
                driver.findElement(kuwaitCountry).click();
                System.out.println(country);
                break;
            default:
                System.out.println("Please select from these countries: SA, BH, KW");
        }
    }

    /**
     * this function for selecting a plan based on the examples from features file
     *
     * @param plan
     */
    public void selectPlan(String plan) {
        switch (plan) {
            case ("Lite"):
                driver.findElement(startLiteTrialBtn).click();
                break;
            case ("Classic"):
                driver.findElement(startClassicTrialBtn).click();
                break;
            case ("Premium"):
                driver.findElement(startPremiumTrialBtn).click();
                break;
            default:
                System.out.println("enter valid plan");
        }
        System.out.println("the selected plan is: " + plan);

    }
}
