package com.polynomial.task2;

public class Main {

    public static void main(String[] args) {
        tests();
    }
    public static void  tests(){
        System.out.println("Adding terms & printing");
        System.out.println();
        Polynomial p = new Polynomial();
        p.addTerms(3, 2);   // 3X^2
        p.addTerms(5, 0);   // 5 (constant term)
        p.addTerms(-1, 1);  // -X


        System.out.println("p: " + p);

        System.out.println();
        System.out.println("-----------------------------------------------------");;

        System.out.println("test 2");
        Polynomial y = new Polynomial();
        y.addTerms(4, 3);   // 4X^3
        y.addTerms(2, 1);   // 2X

        System.out.println("Coefficient of X^3: " + y.getCoefficient(3)); // 4
        System.out.println("Coefficient of X^2: " + y.getCoefficient(2)); // 0 (not present)

        y.setCoeffiecient(3, 5); // change 4X^3 → 5X^3
        y.setCoeffiecient(2, 7); // new term X^2

        System.out.println("After setCoefficient: " + p);

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("test 3:evaluating");

        Polynomial z = new Polynomial();
        z.addTerms(2, 2);   // 2X^2
        z.addTerms(3, 1);   // 3X
        z.addTerms(4, 0);   // 4

        System.out.println("p(2) = " + z.evaluate(2)); // 2*4 + 3*2 + 4 = 8 + 6 + 4 = 18
        System.out.println("p(0) = " + z.evaluate(0)); // 0 + 0 + 4 = 4

        System.out.println();
        System.out.println("-----------------------------------------------------");

        System.out.println("Test 4 : com.polynomial.task2.Polynomial Addition");
        Polynomial p1 = new Polynomial();
        p1.addTerms(3, 2);   // 3X^2
        p1.addTerms(5, 0);   // 5

        Polynomial p2 = new Polynomial();
        p2.addTerms(2, 2);   // 2X^2
        p2.addTerms(1, 1);   // X

        Polynomial sum = p1.addFunctions(p2);
        System.out.println("p1 + p2 = " + sum);

        System.out.println();
        System.out.println("-----------------------------------------------------");

        System.out.println("Test 5: derivative");
        Polynomial f = new Polynomial();
        f.addTerms(4, 3);   // 4X^3
        f.addTerms(-2, 1);  // -2X
        f.addTerms(5, 0);   // 5

        Polynomial deriv = f.derivate();
        System.out.println("p derivative = " + deriv);

    }

}