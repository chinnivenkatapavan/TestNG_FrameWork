package com.askomdch.testData;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginCredentials")
    public Object[][] LoginCredentialsData(){
        return new Object[][]{
                {"b@gmail.com","1234567890","Unknown email address. Check again or try your username."},
                {"beginner_Framework@gmail.com","12354658910","Error: The password you entered for the email address beginner_Framework@gmail.com is incorrect. Lost your password?"},
                {"beginner_Framework@gmail.com","1234567890",""}
        };
    }

    @DataProvider(name = "loginCredential")
    public Object[][] loginCredentialData(){
        return new Object[][]{
                {"beginner_Framework@gmail.com","1234567890"}
        };
    }

}
