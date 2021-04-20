package stepDefinitions;

import com.Pages.LoginPage;
import com.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;



public class LoginPageSteps {

    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    //first Scenario: Login page title

    @Given("User is on login page")
    public void user_is_on_login_page() {

        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Title of the Login Page:" + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }


    //Second Scenario: forgot password link
    //We don't need Given() again since it was already defined in first Scenario

    @Then("forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {

        Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
    }

    //3rd Scenario:  Login with valid credentials

    @When("User enters username {string}")
    public void user_enters_username(String un) {

        loginPage.enterUserName(un);

    }

    @When("User enters password {string}")
    public void user_enters_password(String pass) {

        loginPage.enterPassword(pass);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {

        loginPage.clickSignInButton();

    }

//    @Then("User gets the title of the home page")
//    public void user_gets_the_title_of_the_home_page() {
//
//        loginPage.isForgotPasswordLinkExist();
//    }
//
//    @Then("Page title of Account page should be {string}")
//    public void page_title_of_account_page_should_be(String string) {
//
//        loginPage.clickSignInButton();
//    }


}
