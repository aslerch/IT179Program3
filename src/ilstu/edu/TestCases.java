package ilstu.edu;

public class TestCases {

    public static void main(String[] args) {
        Polynomial poly1 = new Polynomial("4x^3 + 2x - 7");
        Polynomial poly2 = new Polynomial("-10x^4 + 2x^3 - 2x + 3");
        Polynomial poly3 = poly1.addPolynomial(poly2);
        System.out.println(poly3);
    }



}
