package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;

public class task2 {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();

        driver.get("https://www.greencity.cx.ua/#/greenCity");

        List<WebElement> elements = driver.findElements(By.cssSelector("*"));
        Set<String> uniqueColors = new HashSet<>();

        for (WebElement element : elements) {
            uniqueColors.add(element.getCssValue("color"));
            uniqueColors.add(element.getCssValue("background-color"));
        }
        System.out.println("Number of unique colors " + uniqueColors.size());

        Thread.sleep(4000);
        driver.quit();
    }
}
