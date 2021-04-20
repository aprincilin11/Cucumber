package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    private By username = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPasswrd = By.linkText("Forgot your password?");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkExist(){
       return driver.findElement(forgotPasswrd).isDisplayed();
    }
    public void enterUserName(String name){
         driver.findElement(username).sendKeys("delina_11@yahoo.co.in");
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys("Password");
    }
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }

    public  AccountPage doLogin(String un, String pass){
        driver.findElement(username).sendKeys(un);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();
        return new AccountPage(driver);
    }
}
