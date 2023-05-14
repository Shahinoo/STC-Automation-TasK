package stc.ta.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import stc.ta.pages.OrderSummeryPage;

import java.time.Duration;

import static stc.ta.stepDefs.Hooks.driver;

public class OrderSummeryStepDef {
    OrderSummeryPage orderSummeryPage = new OrderSummeryPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    SoftAssert softAssert = new SoftAssert();

    @Then("{string} is selected")
    public void isSelected(String plan) {
        softAssert.assertEquals(orderSummeryPage.paymentMethodHeaderWebEle().getText(), "Payment Method", "assert on payment method header");
        System.out.println(orderSummeryPage.paymentMethodHeaderWebEle().getText());
        softAssert.assertEquals(orderSummeryPage.orderSummeryHeaderWebEle().getText(), "Order summary", "assert on order summery header");
        System.out.println(orderSummeryPage.orderSummeryHeaderWebEle().getText());
        softAssert.assertTrue(orderSummeryPage.selectedPlanTitleWebEle().getText().contains(plan), plan + "plan should be displayed");
        System.out.println(orderSummeryPage.selectedPlanTitleWebEle().getText());
        softAssert.assertAll();
    }

    @And("The selected plan price and currency should be {string}")
    public void theSelectedPlanPriceIs(String price) {
        softAssert.assertEquals(orderSummeryPage.selectedPlanPriceAndCurrencyWebEle().getText(), price);
        System.out.println(orderSummeryPage.selectedPlanPriceAndCurrencyWebEle().getText());
        softAssert.assertAll();

    }

    @And("Total price should be {string}")
    public void totalPriceShouldBe(String totalPrice) {
        Assert.assertTrue(orderSummeryPage.totalPriceAndCurrencyWebEle().getText().contains(totalPrice), "Total price should be zero");
        System.out.println(orderSummeryPage.totalPriceAndCurrencyWebEle().getText());
    }

    @When("User click on Next button")
    public void userClickOnNextButton() {
        orderSummeryPage.clickOnNextAfterSelectMethod();
    }

    @And("User select Discovery+ package from the extra packages")
    public void userSelectDiscoveryPackageFromTheExtraPackages() {
        wait.until(ExpectedConditions.elementToBeClickable(orderSummeryPage.getDiscoveryAddonCardImgWebEle()));
        System.out.println(orderSummeryPage.getDiscoveryAddonCardImgWebEle().isDisplayed());
        orderSummeryPage.clickOnDiscoveryAddonCardImg();
    }

    @Then("Discovery package price for {string} is {string}")
    public void discoveryPackagePriceIs(String plan, String discoveryValue) {
        switch (plan) {
            case ("Premium"):
                softAssert.assertTrue(orderSummeryPage.getDiscoveryAddonNameForPremiumWebEle().getText().contains(discoveryValue),
                        "Assert that discovery package for premium is included");
                System.out.println(orderSummeryPage.getDiscoveryAddonNameForPremiumWebEle().getText());
                break;
            case ("Lite"):
                softAssert.assertTrue(orderSummeryPage.getDiscoveryPriceWebEle().getText().contains(discoveryValue),
                        "Assert that discovery package price for lite is 0");
                System.out.println(orderSummeryPage.getDiscoveryPriceWebEle().getText());
                break;
            case ("Classic"):
                softAssert.assertTrue(orderSummeryPage.getDiscoveryPriceWebEle().getText().contains(discoveryValue),
                        "Assert that discovery package price for classic is 0");
                System.out.println(orderSummeryPage.getDiscoveryPriceWebEle().getText());
                break;
            default:
                System.out.println("Please insert correct Plan");
        }
        softAssert.assertAll();
    }

}

