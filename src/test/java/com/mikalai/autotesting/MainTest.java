
package com.mikalai.autotesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class MainTest {

    @DataProvider(name = "consoleInputData")
    public Object[][] consoleInputData() {
        return new Object[][]{
                {"3 4 5", "Triangle type: Right-angled"},
                {"3 3 3", "Triangle type: Acute-angled"},
                {"2 3 4", "Triangle type: Obtuse-angled"},
                {"1 2 3", "These sides do not form a triangle."},
                {"0 3 4", "Invalid input: sides must be positive integers."},
                {"-1 3 4", "Invalid input: sides must be positive integers."},
                {"2.5 3 4", "Invalid input: please enter integers only."},
                {"abc 3 4", "Invalid input: please enter integers only."},
                {"2147483648 3 4", "Invalid input: please enter integers only."},
                {"3 4", "Invalid input: three sides are required."},
                {"", "Invalid input: three sides are required."}
        };
    }

    @Test(dataProvider = "consoleInputData")
    public void testRun(String input, String expected) {

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        input.getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream();

        PrintStream printStream =
                new PrintStream(outputStream, true, StandardCharsets.UTF_8);

        Main.run(inputStream, printStream);

        String actual = outputStream.toString(StandardCharsets.UTF_8);

        Assert.assertTrue(actual.stripTrailing().endsWith(expected),
                "Unexpected console output: " + actual);
    }

    @Test
    public void testMain() {

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        "3 4 5".getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream();

        try {
            System.setIn(inputStream);
            System.setOut(new PrintStream(
                    outputStream, true, StandardCharsets.UTF_8));

            Main.main(new String[]{});

            String actual =
                    outputStream.toString(StandardCharsets.UTF_8);

            Assert.assertTrue(
                    actual.stripTrailing().endsWith("Triangle type: Right-angled"));

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
