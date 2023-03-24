package org.example;

import steps.BaseSteps;
import tests.HomeTests;

public class Main {
    public static void main(String[] args) {
        BaseSteps.getInstance().setDriver("chrome");
        HomeTests homeTests = new HomeTests();


        homeTests.controlTest();

        BaseSteps.getInstance().tearDown();
    }
}