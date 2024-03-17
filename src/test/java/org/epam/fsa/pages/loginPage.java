package org.epam.fsa.pages;

import org.epam.fsa.base.BaseTest;
import org.epam.fsa.utils.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Properties;

public class loginPage extends CommonToAllPage {

    BaseTest base;

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    private WebElement userName;

    public WebElement getUserName() {
        return userName;
    }

    @FindBy(name = "password")
    private WebElement passWord;

    public WebElement getPassWord() {
        return passWord;
    }

    public void attemptLogin(LinkedHashMap<String,String> data,Properties prop){
        getUserName().sendKeys(data.get("userName"));
        getPassWord().sendKeys(data.get("passWord"));
        getLoginButton().click();
    }


    @FindBy(xpath = "//*[@name='password']/following::div[1]")
    private WebElement loginBtn;

    public WebElement getLoginButton() {
        return loginBtn;
    }
}
