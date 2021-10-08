package ilstu.edu;

/** Represents a term in a polynomial */
public class Term {

    /** Fields */
    /** Value of the coefficient in a polynomial term */
    private int coefficient;
    /** Value of the variable's exponent in a polynomial term */
    private int exponent;

    /** Constructors */
    public Term() {};

    /**
     * Instantiates a Term object with all fields specified
     * @param coefficient Value of the coefficient in a polynomial term
     * @param exponent Value of the variable's exponent in a polynomial term
     */
    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    /** Public Methods */
    /**
     * Adds two terms together
     * @param secondTerm The second term
     * @return The term that is the summation of the two terms or null if the exponents of the terms do not match
     */
    public Term addTerm(Term secondTerm) {
        if (this.exponent != secondTerm.getExponent())
            return null;
        else { // if sum can be expressed as a single term
            int sumOfCoefficients = this.coefficient + secondTerm.coefficient;
            Term termAfterSummation = new Term(sumOfCoefficients, this.exponent);
            return termAfterSummation;
        }
    }

    /**
     * Gets the term's coefficient
     * @return The term's coefficient value
     */
    public int getCoefficient() { return coefficient;}

    /**
     * Gets the term's exponent
     * @return The term's exponent value
     */
    public int getExponent() {return exponent;}

    @Override
    public String toString() {
        if (exponent == 0) {
            return Integer.toString(coefficient);
        }
        else if (exponent == 1) {
            return coefficient + "x";
        }
        else {
            return coefficient + "x^" + exponent;
        }
    }

}
