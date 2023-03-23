package tests;

import dev.failsafe.internal.util.Assert;

public class CustomAssertions {
    public static void isTextEqual (String expectedText, String currentText) {
        String errorMessage = "Text " + currentText + " is not as expected. Expected was: " + expectedText;

        Assert.isTrue(expectedText.equals(currentText), errorMessage);
    }
}
