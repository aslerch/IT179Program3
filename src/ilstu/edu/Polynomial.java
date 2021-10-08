package ilstu.edu;

import java.util.ArrayList;
import java.util.Iterator;

/** Represents polynomial expressions */
public class Polynomial {

    /** Fields */
    private Node termsHead, termsTail;

    /** Constructors */
    /**
     * Default Constructor
     */
    public Polynomial() {}

    /**
     * Instantiates a Polynomial object
     * @param polynomial
     */
    public Polynomial(String polynomial) {
        String[] polynomialBreakdown = polynomial.split(" ");
        int coefficient = 0;
        int exponent = 0;
        for (int i = 0; i < polynomialBreakdown.length; i++) {
            String signOfTerm = "";
            if (polynomialBreakdown[i].equals("+") || polynomialBreakdown[i].equals("-")) {
                if (polynomialBreakdown[i].equals("-"))
                    signOfTerm = "-";
            }
            else { // element does not contain a "+" nor "-"
                if (polynomialBreakdown[i].contains("^")) {
                    String [] parsedExponentTerm = polynomialBreakdown[i].split("x\\^");
                    coefficient = Integer.parseInt(signOfTerm + parsedExponentTerm[0]);
                    exponent = Integer.parseInt(parsedExponentTerm[1]);
                }
                else if ( polynomialBreakdown[i].contains("x")) {
                    String [] parsedLinearTerm = polynomialBreakdown[i].split("x");
                    coefficient = Integer.parseInt(parsedLinearTerm[0]);
                    exponent = 1;
                }
                else {
                    coefficient = Integer.parseInt(signOfTerm + polynomialBreakdown[i]);
                    exponent = 0;
                }
            }
            if (i % 2 == 0) {
                Term newTerm = new Term(coefficient, exponent);
                addTermToPolynomial(newTerm);
            }
        }
    }

    /** Public Methods */
    /**
     * Adds a term to the polynomial
     * @param term The term to be added
     */
    public void addTermToPolynomial(Term term) {
        if (termsHead == null)
            addFirst(term);
        else
            addToTheEnd(term);
    }

    @Override
    public String toString() {
        Node current = termsHead;
        String output = "";
        while (current != null) {
            output += current.termData;
            if (current.next != null && current.termData.getCoefficient() >= 0)
                output += " + ";
            current = current.next;
        }
        return output;
    }

    /**
     * Adds two polynomials together
     * @param secondPolynomial The polynomial to be added
     * @return The polynomial that resulted from adding the two polynomials
     */
    public Polynomial addPolynomial(Polynomial secondPolynomial) {
        Node firstCurrent = termsHead;
        Node secondCurrent = secondPolynomial.termsHead;
        Polynomial summationPolynomial = new Polynomial();
        while (firstCurrent != null || secondCurrent != null) {
            if (firstCurrent == null) {
                summationPolynomial.addTermToPolynomial(secondCurrent.termData);
                secondCurrent = secondCurrent.next;
            }
            else if (secondCurrent == null) {
                summationPolynomial.addTermToPolynomial(firstCurrent.termData);
                firstCurrent = firstCurrent.next;
            }
            else {
                Term summationTerm = firstCurrent.termData.addTerm(secondCurrent.termData);
                if (summationTerm == null) {
                    if (firstCurrent.termData.getExponent() > secondCurrent.termData.getExponent()) {
                        summationPolynomial.addTermToPolynomial(firstCurrent.termData);
                        firstCurrent = firstCurrent.next;
                    }
                    else {
                        summationPolynomial.addTermToPolynomial(secondCurrent.termData);
                        secondCurrent = secondCurrent.next;
                    }
                }
                else {
                    summationPolynomial.addTermToPolynomial(summationTerm);
                    firstCurrent = firstCurrent.next;
                    secondCurrent = secondCurrent.next;
                }
            }
        }
        return summationPolynomial;
    }

    /** Private Methods */
    /**
     * Adds a node to the beginning of the list
     * @param term The term to be added
     */
    private void addFirst(Term term) {
        termsHead = new Node(term, termsHead);
        termsTail = termsHead;
    }

    /**
     * Adds a node to the end of the list
     * @param term The term to be added
     */
    private void addToTheEnd(Term term) {
        Node current = termsHead;
        while (current.next != null)
            current = current.next;
        Node newNode = new Node(term, termsTail.next);
        termsTail = newNode;
        current.next = newNode;
    }

    /**
     * Gets a term at a specified index
     * @param index Index of the term to be returned
     * @return A term
     */
    private Term getTerm(int index) {
        if ( index < 0)
            throw new IndexOutOfBoundsException(Integer.toString(index));
        Node current = termsHead;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return current.termData;
    }

    /** Building block for polynomial class */
    private class Node {

        /** Fields */
        private Term termData;
        private Node next;

        /** Constructors */
        /**
         * Instantiates a node with the term specified and next set to null
         * @param termData The term to be added
         */
        private Node(Term termData, Node next) {
            this.termData = termData;
            this.next = next;
        }

    }

}
