package org.example;

import org.testng.annotations.BeforeTest;
import steps.BaseSteps;
import tests.HomeTests;

public class Main {
    @BeforeTest
    public static void main(String[] args) {
        BaseSteps baseSteps = new BaseSteps("chrome");
        HomeTests homeTests = new HomeTests(baseSteps.getDriver());


        homeTests.controlTest();

        baseSteps.tearDown();
    }
}