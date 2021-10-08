package ilstu.edu;

public class TestCases {

    public static void main(String[] args) {
        Polynomial poly1 = new Polynomial("-2x^4 + 3x^3 + 0x^1");
        Polynomial poly2 = new Polynomial("2x^4 - 5x^3 - 5");
        Polynomial poly3 = poly1.addPolynomial(poly2);
        System.out.println(poly3);
    }



}
