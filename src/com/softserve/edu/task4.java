package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class task4 {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();

        driver.get("https://www.greencity.cx.ua/#/greenCity");

        driver.findElement(By.className("header_sign-up-link")).click();
        Thread.sleep(2000);

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.size());


        for (WebElement input : inputs) {
            System.out.println(input.getAttribute("type"));
        }

        Thread.sleep(4000);
        driver.quit();
    }
}
