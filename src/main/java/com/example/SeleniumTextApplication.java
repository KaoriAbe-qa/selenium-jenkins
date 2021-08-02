package com.example;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SeleniumTextApplication {

	public static void main(String[] args) {
		//ファイルパス指定
		System.setProperty("webdriver.chrome.driver", "C:/rks/chromedriver_win32_91/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://qiita.com/");
		
		//要素取得
		driver.findElement(By.name("q")).sendKeys("selenium備忘録",Keys.ENTER);
		System.out.println(driver.getTitle());
		
		//画面操作
		File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//スクショとって指定場所に保存
		try {
			Files.copy(tempFile.toPath(), new File("C:/eclipse/" + tempFile.getName()).toPath());
		} catch (IOException e) {
			System.out.println("スクショ失敗");
		}
		
		driver.quit();	//ブラウザの破棄
		
	}

}
