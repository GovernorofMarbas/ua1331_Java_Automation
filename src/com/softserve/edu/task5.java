package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class task5 {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();

        driver.get("https://www.greencity.cx.ua/#/greenCity");

        List<WebElement> aLinks = driver.findElements(By.cssSelector("a[class*='footer_social-link']"));
        System.out.println(aLinks.size());

        for (WebElement link : aLinks) {
            WebElement img = link.findElement(By.tagName("img"));
            String alt = img.getAttribute("alt");
            System.out.println("Соцсеть: " + alt);
        }

        Thread.sleep(4000);
        driver.quit();
    }
}
