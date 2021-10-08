package ilstu.edu;

import java.util.Scanner;

/** Driver class for program */
public class Main {

    /** Objects needed later */
    private static Scanner keyboard = new Scanner(System.in);

    /** Main Method */
    public static void main(String [] args) {

        displayWelcomeSign();
        String addAnotherPolynomial = "n";
        do {
            // Get the first polynomial
            System.out.println("Please enter your first polynomial: ");
            Polynomial firstPolynomial = new Polynomial(keyboard.nextLine());

            // Get the second polynomial
            System.out.println("Please enter the second polynomial: ");
            Polynomial secondPolynomial = new Polynomial(keyboard.nextLine());

            // Add the polynomials together and output the result
            Polynomial sumOfPolynomials = firstPolynomial.addPolynomial(secondPolynomial);
            System.out.println("\nThe sum is: \n" + sumOfPolynomials + "\n");

            // Ask if the user wants to add more polynomials
            addAnotherPolynomial = askForStringWithinLength("Would you like to add two more polynomials? ", 100);
            System.out.println(); // For formatting purposes only
        } while (addAnotherPolynomial.equals("y"));

        // Displays the exit message
        System.out.println("Thank you for using the Polynomial Addition Program.");
    }

    /** Helper Methods */
    /**
     * Displays the welcome sign
     */
    private static void displayWelcomeSign() {
        System.out.println("""
                Welcome to the Polynomial Addition Program.
                """);
    }

    /**
     * Asks for a String that is within a certain length
     * @param informationRequestMessage The request message
     * @param lengthUpperBound The upper bound for length
     * @return A String within a length determined by the upper bound
     */
    private static String askForStringWithinLength(String informationRequestMessage, int lengthUpperBound) {
        boolean isWithinCorrectLength = false;
        String output = "";
        while (isWithinCorrectLength == false) {
            System.out.print(informationRequestMessage);
            output = keyboard.nextLine();
            if (output.length() <= lengthUpperBound)
                isWithinCorrectLength = true;
            if (output.length() > lengthUpperBound)
                System.out.println("input not of valid length " + "(" + lengthUpperBound + ")");
        }
        return output;
    }

}
