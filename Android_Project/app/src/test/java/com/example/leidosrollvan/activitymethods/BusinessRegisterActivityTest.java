package com.example.leidosrollvan.activitymethods;

import android.net.Uri;

import com.example.leidosrollvan.dataClassesForMethods.EmailPasswordResponseModel;

import org.junit.Assert;
import org.junit.Test;

public class BusinessRegisterActivityTest {

    private final EmailCheckMethods emailCheckClass = new EmailCheckMethods();
    private final PasswordCheckMethods passwordCheckClass = new PasswordCheckMethods();
    private final BusinessNameMobileCheckMethods nameMobile = new BusinessNameMobileCheckMethods();

    @Test
    public void test_empty_email(){

        EmailPasswordResponseModel actual = emailCheckClass.checkEmail("");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();

        expected.setStatus(false);
        expected.setMessage("Email is Required!");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    public void test_incorrect_email(){

        EmailPasswordResponseModel actual = emailCheckClass.checkEmail("someemail");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();
        expected.setStatus(false);
        expected.setMessage("Please provide valid email!");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }
    @Test
    public void test_email_without_char(){

        EmailPasswordResponseModel actual = emailCheckClass.checkEmail("someemail.com");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();
        expected.setStatus(false);
        expected.setMessage("Please provide valid email!");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    public void test_email_without_dot(){

        EmailPasswordResponseModel actual = emailCheckClass.checkEmail("some@emailcom");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();
        expected.setStatus(false);
        expected.setMessage("Please provide valid email!");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    public void test_correct_email(){

        EmailPasswordResponseModel actual = emailCheckClass.checkEmail("some@email.com");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();
        expected.setStatus(true);
        expected.setMessage("OK");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    public void test_empty_password(){

        EmailPasswordResponseModel actual = passwordCheckClass.checkPassword("");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();
        expected.setStatus(false);
        expected.setMessage("Password is Required!");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());

    }

    @Test
    public void test_incorrect_password(){

        EmailPasswordResponseModel actual = passwordCheckClass.checkPassword("12345");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();
        expected.setStatus(false);
        expected.setMessage("Minimum password length should be 6 characters");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());

    }

    @Test
    public void test_correct_password(){

        EmailPasswordResponseModel actual = passwordCheckClass.checkPassword("123456");

        EmailPasswordResponseModel expected = new EmailPasswordResponseModel();
        expected.setStatus(true);
        expected.setMessage("OK");

        Assert.assertEquals(expected.getMessage(), actual.getMessage());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());

    }

    @Test
    public void test_empty_business_name(){
        boolean actual = nameMobile.checkBusinessName("");
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_correct_business_name(){
        boolean actual = nameMobile.checkBusinessName("someBusinessName");
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_empty_business_mobile(){
        boolean actual = nameMobile.checkBusinessMobile("");
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_correct_business_mobile(){
        boolean actual = nameMobile.checkBusinessMobile("021423423");
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_nullable_uri(){
        Uri uri = null;
        boolean actual = nameMobile.checkUri(uri);
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

}
