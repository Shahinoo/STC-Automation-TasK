package stc.ta.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import stc.ta.data.JsonDataReader;
import stc.ta.pages.SubscribePackagePage;

import java.io.IOException;

public class SubscribePackageStepDef {
    SubscribePackagePage subscribePackagePage = new SubscribePackagePage();
    SoftAssert softAssert = new SoftAssert();
    JsonDataReader jsonReader = new JsonDataReader();


    @Given("User on subscribe page")
    public void userOnSubscribePage() {
        subscribePackagePage.navigateToSubscriptionPage();
    }

    @When("User select a {string} from the countries list")
    public void userSelectAFromTheCountriesList(String country) {
        subscribePackagePage.selectCountry(country);
    }

    @Then("The Three types of packages are displayed")
    public void theThreeTypesOfPackagesAreDisplayed() {
        softAssert.assertTrue(subscribePackagePage.litePlanTitleWebEle().isDisplayed(), "Lite Plan title should be displayed");
        System.out.println(subscribePackagePage.litePlanTitleWebEle().getText());
        softAssert.assertTrue(subscribePackagePage.classicPlanTitleWebEle().isDisplayed(), "Classic Plan title should be displayed");
        System.out.println(subscribePackagePage.classicPlanTitleWebEle().getText());
        softAssert.assertTrue(subscribePackagePage.premiumPlanTitleWebEle().isDisplayed(), "Premium Plan title should be displayed");
        System.out.println(subscribePackagePage.premiumPlanTitleWebEle().getText());
        softAssert.assertAll();

    }

    @And("The currency for all plans in the selected {string} should be as the table")
    public void theCurrencyForAllPlansInTheSelectedShouldBeAsTheTable(String country, DataTable dt) {
        switch (country) {
            case ("saudi arabia"):
                softAssert.assertEquals(subscribePackagePage.litePlanCurrencyWebEle().getText().contains(dt.cell(1, 0)), true);
                softAssert.assertEquals(subscribePackagePage.classicPlanCurrencyWebEle().getText().contains(dt.cell(1, 0)), true);
                softAssert.assertEquals(subscribePackagePage.premiumPlanCurrencyWebEle().getText().contains(dt.cell(1, 0)), true);
                softAssert.assertEquals(subscribePackagePage.classicPlanCurrencyWebEle().getText(), "SAR/month");
                softAssert.assertAll();
                System.out.println(dt.cell(1, 0));
                break;
            case ("bahrain"):
                softAssert.assertEquals(subscribePackagePage.litePlanCurrencyWebEle().getText().contains(dt.cell(1, 1)), true);
                softAssert.assertEquals(subscribePackagePage.classicPlanCurrencyWebEle().getText().contains(dt.cell(1, 1)), true);
                softAssert.assertEquals(subscribePackagePage.premiumPlanCurrencyWebEle().getText().contains(dt.cell(1, 1)), true);
                softAssert.assertAll();
                System.out.println(dt.cell(1, 1));
                break;
            case ("kuwait"):
                softAssert.assertEquals(subscribePackagePage.litePlanCurrencyWebEle().getText().contains(dt.cell(1, 2)), true);
                softAssert.assertEquals(subscribePackagePage.classicPlanCurrencyWebEle().getText().contains(dt.cell(1, 2)), true);
                softAssert.assertEquals(subscribePackagePage.premiumPlanCurrencyWebEle().getText().contains(dt.cell(1, 2)), true);
                softAssert.assertAll();
                System.out.println(dt.cell(1, 2));
                break;
            default:
                System.out.println("Please Insert the correct Currency on the data table");
        }
    }

    @And("The Prices for the all plans in the selected {string} should be as expected on the json file")
    public void thePricesForTheAllPlansInTheSelectedShouldBeAsExpectedOnJsonFile(String country) throws IOException, ParseException {
        jsonReader.JsonReader();
        switch (country) {
            case "saudi arabia":
                softAssert.assertEquals(subscribePackagePage.litePlanPriceWebEle().getText(), jsonReader.sa_litePrice);
                System.out.println(subscribePackagePage.litePlanPriceWebEle().getText());
                softAssert.assertEquals(subscribePackagePage.classicPlanPriceWebEle().getText(), jsonReader.sa_classicPrice);
                System.out.println(subscribePackagePage.classicPlanPriceWebEle().getText());
                softAssert.assertEquals(subscribePackagePage.premiumPlanPriceWebEle().getText(), jsonReader.sa_premiumPrice);
                System.out.println(subscribePackagePage.premiumPlanPriceWebEle().getText());
                softAssert.assertAll();
                break;
            case "bahrain":
                softAssert.assertEquals(subscribePackagePage.litePlanPriceWebEle().getText(), jsonReader.bh_litePrice);
                System.out.println(subscribePackagePage.litePlanPriceWebEle().getText());
                softAssert.assertEquals(subscribePackagePage.classicPlanPriceWebEle().getText(), jsonReader.bh_classicPrice);
                System.out.println(subscribePackagePage.classicPlanPriceWebEle().getText());
                softAssert.assertEquals(subscribePackagePage.premiumPlanPriceWebEle().getText(), jsonReader.bh_premiumPrice);
                System.out.println(subscribePackagePage.premiumPlanPriceWebEle().getText());
                softAssert.assertAll();
                break;
            case "kuwait":
                softAssert.assertEquals(subscribePackagePage.litePlanPriceWebEle().getText(), jsonReader.kw_litePrice);
                System.out.println(subscribePackagePage.litePlanPriceWebEle().getText());
                softAssert.assertEquals(subscribePackagePage.classicPlanPriceWebEle().getText(), jsonReader.kw_classicPrice);
                System.out.println(subscribePackagePage.classicPlanPriceWebEle().getText());
                softAssert.assertEquals(subscribePackagePage.premiumPlanPriceWebEle().getText(), jsonReader.kw_premiumPrice);
                System.out.println(subscribePackagePage.premiumPlanPriceWebEle().getText());
                softAssert.assertAll();
                break;
        }
    }

    @And("Discovery add-ons is included as an extra for all plans")
    public void discoveryAddOnsIsIncludedAsAnExtraForAllPlans() {
        Assert.assertEquals(subscribePackagePage.discoveryLiteValueWebEle().getText(), "Included",
                "Discovery package should be included with lite plan");
        System.out.println(subscribePackagePage.discoveryLiteValueWebEle().getText());

        Assert.assertEquals(subscribePackagePage.discoveryClassicValueWebEle().getText(), "Included",
                "Discovery package should be included with classic plan");
        System.out.println(subscribePackagePage.discoveryClassicValueWebEle().getText());

        Assert.assertEquals(subscribePackagePage.discoveryPremiumValueWebEle().getText(), "Included",
                "Discovery package should be included with premium plan");
        System.out.println(subscribePackagePage.discoveryPremiumValueWebEle().getText());
    }

    @And("Start a trial for a {string} for the {string}")
    public void startATrialForAForThe(String plan, String country) {
        subscribePackagePage.selectCountry(country);
        subscribePackagePage.selectPlan(plan);
    }
}


