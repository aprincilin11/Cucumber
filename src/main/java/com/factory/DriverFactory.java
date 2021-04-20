package com.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>(); // Creating an obj for ThreadLocal class

    /* Thread Local is a Class in synchronization
    this method is used to initialize the Thread local driver on the basis of the given driver
     we have to give parameter as a browser and will return tldriver */

    //WebDriver is having 2 methods
    //1st method init_driver()
    public static WebDriver init_driver(String browser) {              // Initiating the browser

        System.out.println("Browser value : " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());
        }

        /*
        //WebDriverManager is a dependency to update the drivers automatically when it's getting updated
        WebDriverManager automates the browser setup in the Selenium code.
         By default, it downloads the latest version of the browser binary and also the binary for the appropriate platform
         It supports various browsers like Google Chrome, Firefox, IE, Edge, Opera, etc.*/

        // Local thread setup by giving the object of Chrome driver for parallel threading
        else if (browser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            tldriver.set(new FirefoxDriver());
        } else {
            System.out.println("Please enter the correct browser value" + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    //2nd method getDriver()
    public static synchronized WebDriver getDriver() {
        return tldriver.get();
        //sync: this is used to get the driver with ThreadLocal, here we r executing multiple threads all r with
        // chrome browser - parallel execution
        // WebDriver is having set() and get(), so we set the driver first and get that driver
    }
}

/*
Java ThreadLocal class provides thread-local variables. It enables you to create variables that can only be read and write by the same thread.
If two threads are executing the same code and that code has a reference to a ThreadLocal variable then the two threads can't see the local variable of each other.
 */
