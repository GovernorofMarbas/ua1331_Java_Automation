package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class task3 {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();

        driver.get("https://www.greencity.cx.ua/#/greenCity");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        int count = 0;

        for (WebElement button : buttons){
            String buttonType = button.getAttribute("type");
            System.out.println("Image type: " + buttonType);
        }

        System.out.println("Number of buttons "+buttons.size());

        Thread.sleep(4000);
        driver.quit();
    }
}
