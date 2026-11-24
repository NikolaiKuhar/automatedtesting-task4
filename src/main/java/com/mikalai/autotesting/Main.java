
package com.mikalai.autotesting;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        run(System.in, System.out);
    }

    public static void run(InputStream input, PrintStream output) {

        Scanner scanner = new Scanner(input);

        output.println("Triangle Classification Program");
        output.println("Enter three positive integers:");

        try {
            output.print("Side a: ");
            int a = Integer.parseInt(scanner.next());

            output.print("Side b: ");
            int b = Integer.parseInt(scanner.next());

            output.print("Side c: ");
            int c = Integer.parseInt(scanner.next());

            TriangleType result = Triangle.classify(a, b, c);

            switch (result) {
                case INVALID_INPUT ->
                        output.println("Invalid input: sides must be positive integers.");

                case NOT_A_TRIANGLE ->
                        output.println("These sides do not form a triangle.");

                case RIGHT ->
                        output.println("Triangle type: Right-angled");

                case ACUTE ->
                        output.println("Triangle type: Acute-angled");

                case OBTUSE ->
                        output.println("Triangle type: Obtuse-angled");
            }

        } catch (NumberFormatException e) {
            output.println("Invalid input: please enter integers only.");

        } catch (NoSuchElementException e) {
            output.println("Invalid input: three sides are required.");
        }
    }
}
