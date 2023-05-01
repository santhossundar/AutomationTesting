package org.automation;

import org.automation.test.LoginTest;

public class Main {
    public static void main(String[] args) {
        LoginTest loginTest = new LoginTest();
        loginTest.setup();
        loginTest.login();
        loginTest.teardown();
    }
}