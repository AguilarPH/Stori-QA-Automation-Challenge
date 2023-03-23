package org.example;

import steps.BaseSteps;
import tests.HomeTests;

public class Main {
    public static void main(String[] args) {
        BaseSteps baseSteps = new BaseSteps("chrome");
        HomeTests homeTests = new HomeTests(baseSteps.getDriver());



        homeTests.controlTest();
//        homeTests.switchTabTest();

        baseSteps.tearDown();
    }
}