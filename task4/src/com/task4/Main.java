package com.task4;
import com.polynomial.task2.Polynomial;
import com.grid.task3.GridTraversal;

public class Main {
    public static void main(String[] args) {
        polynomailTests();
        gridTest();

    }
    static void polynomailTests(){
        System.out.println("── addTerms + toString (5 cases) ──");

        Polynomial t1 = new Polynomial();
        t1.addTerms(3, 2); t1.addTerms(-1, 1); t1.addTerms(5, 0);
        System.out.println("1. Expected 3x^2-x+5    : " + t1);

        Polynomial t2 = new Polynomial();
        t2.addTerms(1, 4);
        System.out.println("2. Expected x^4         : " + t2);

        Polynomial t3 = new Polynomial();
        t3.addTerms(-2, 3); t3.addTerms(-3, 0);
        System.out.println("3. Expected -2x^3-3     : " + t3);

        Polynomial t4 = new Polynomial();
        t4.addTerms(7, 0);
        System.out.println("4. Expected 7           : " + t4);

        Polynomial t5 = new Polynomial();
        t5.addTerms(5, 5); t5.addTerms(3, 3); t5.addTerms(1, 1);
        System.out.println("5. Expected 5x^5+3x^3+x : " + t5);

        // ── getCoefficient ───────────────────────────────────
        System.out.println("\n── getCoefficient (5 cases) ──");

        Polynomial gc = new Polynomial();
        gc.addTerms(4, 3); gc.addTerms(2, 1);
        System.out.println("1. coeff(3) in 4x^3+2x  -> got: " + gc.getCoefficient(3) + "  (exp 4.0)");
        System.out.println("2. coeff(2) absent       -> got: " + gc.getCoefficient(2) + "  (exp 0.0)");
        System.out.println("3. coeff(1) in 4x^3+2x  -> got: " + gc.getCoefficient(1) + "  (exp 2.0)");

        Polynomial gc2 = new Polynomial();
        gc2.addTerms(-7, 0);
        System.out.println("4. coeff(0) in -7        -> got: " + gc2.getCoefficient(0) + "  (exp -7.0)");

        Polynomial gc3 = new Polynomial();
        gc3.addTerms(9, 5);
        System.out.println("5. coeff(5) in 9x^5      -> got: " + gc3.getCoefficient(5) + "  (exp 9.0)");

        // ── setCoeffiecient ──────────────────────────────────
        System.out.println("\n── setCoeffiecient (5 cases) ──");

        Polynomial sc = new Polynomial();
        sc.addTerms(4, 3); sc.addTerms(2, 1);
        sc.setCoeffiecient(3, 5);
        System.out.println("1. 4x^3+2x, change x^3 coeff to 5   : " + sc + "  (exp 5x^3+2x)");

        sc.setCoeffiecient(2, 7);
        System.out.println("2. add new term 7x^2                 : " + sc + "  (exp 5x^3+7x^2+2x)");

        sc.setCoeffiecient(1, 0);
        System.out.println("3. set x^1 coeff to 0                : " + sc + "  (exp 5x^3+7x^2)");

        Polynomial sc2 = new Polynomial();
        sc2.addTerms(1, 1);
        sc2.setCoeffiecient(1, -1);
        System.out.println("4. change x to -x                    : " + sc2 + "  (exp -x)");

        Polynomial sc3 = new Polynomial();
        sc3.addTerms(2, 2);
        sc3.setCoeffiecient(0, 10);
        System.out.println("5. add constant 10 to 2x^2           : " + sc3 + "  (exp 2x^2+10)");

        // ── evaluate ─────────────────────────────────────────
        System.out.println("\n── evaluate (5 cases) ──");

        Polynomial ev = new Polynomial();
        ev.addTerms(2, 2); ev.addTerms(3, 1); ev.addTerms(4, 0);
        System.out.println("1. 2x^2+3x+4 at x=2   -> got: " + ev.evaluate(2)    + "  (exp 18.0)");
        System.out.println("2. 2x^2+3x+4 at x=0   -> got: " + ev.evaluate(0)    + "  (exp 4.0)");
        System.out.println("3. 2x^2+3x+4 at x=-1  -> got: " + ev.evaluate(-1)   + "  (exp 3.0)");

        Polynomial ev2 = new Polynomial();
        ev2.addTerms(1, 3);
        System.out.println("4. x^3 at x=3          -> got: " + ev2.evaluate(3)  + "  (exp 27.0)");

        Polynomial ev3 = new Polynomial();
        ev3.addTerms(5, 0);
        System.out.println("5. 5 at x=100          -> got: " + ev3.evaluate(100) + "  (exp 5.0)");

        // ── addFunctions ─────────────────────────────────────
        System.out.println("\n── addFunctions (5 cases) ──");

        Polynomial a1 = new Polynomial(); a1.addTerms(3, 2); a1.addTerms(5, 0);
        Polynomial a2 = new Polynomial(); a2.addTerms(2, 2); a2.addTerms(1, 1);
        System.out.println("1. (3x^2+5)+(2x^2+x)      = " + a1.addFunctions(a2) + "  (exp 5x^2+x+5)");

        Polynomial a3 = new Polynomial(); a3.addTerms(1, 1);
        Polynomial a4 = new Polynomial(); a4.addTerms(1, 1);
        System.out.println("2. x + x                  = " + a3.addFunctions(a4) + "  (exp 2x)");

        Polynomial a5 = new Polynomial(); a5.addTerms(4, 3);
        Polynomial a6 = new Polynomial(); a6.addTerms(-4, 3);
        System.out.println("3. 4x^3 + (-4x^3)         = " + a5.addFunctions(a6) + "  (exp 0)");

        Polynomial a7 = new Polynomial(); a7.addTerms(2, 2);
        Polynomial a8 = new Polynomial();
        System.out.println("4. 2x^2 + 0               = " + a7.addFunctions(a8) + "  (exp 2x^2)");

        Polynomial a9  = new Polynomial();
        a9.addTerms(1, 3); a9.addTerms(1, 2); a9.addTerms(1, 1); a9.addTerms(1, 0);
        Polynomial a10 = new Polynomial();
        a10.addTerms(1, 3); a10.addTerms(-1, 1);
        System.out.println("5. (x^3+x^2+x+1)+(x^3-x) = " + a9.addFunctions(a10) + "  (exp 2x^3+x^2+1)");

        // ── derivate ─────────────────────────────────────────
        System.out.println("\n── derivate (5 cases) ──");

        Polynomial d1 = new Polynomial();
        d1.addTerms(4, 3); d1.addTerms(-2, 1); d1.addTerms(5, 0);
        System.out.println("1. d/dx[4x^3-2x+5]     = " + d1.derivate() + "  (exp 12x^2-2)");

        Polynomial d2 = new Polynomial();
        d2.addTerms(3, 2); d2.addTerms(1, 1); d2.addTerms(-2, 0);
        System.out.println("2. d/dx[3x^2+x-2]      = " + d2.derivate() + "  (exp 6x+1)");

        Polynomial d3 = new Polynomial();
        d3.addTerms(7, 0);
        System.out.println("3. d/dx[7] (constant)  = " + d3.derivate() + "  (exp 0)");

        Polynomial d4 = new Polynomial();
        d4.addTerms(1, 4);
        System.out.println("4. d/dx[x^4]           = " + d4.derivate() + "  (exp 4x^3)");

        Polynomial d5 = new Polynomial();
        d5.addTerms(5, 5); d5.addTerms(3, 3); d5.addTerms(1, 1);
        System.out.println("5. d/dx[5x^5+3x^3+x]   = " + d5.derivate() + "  (exp 25x^4+9x^2+1)");

        System.out.println();
    }
    static void gridTest(){
        GridTraversal.solveAndPrint(new int[][]{
                {1, 2, 5, 4, 3},
                {2, 3, 1, 3, 1},
                {3, 3, 2, 1, 1},
                {5, 2, 2, 4, 2},
                {5, 2, 1, 1, 1}
        });

        // Case 2: 3x3 known path
        System.out.println("Case 2 – 3x3 known path:");
        GridTraversal.solveAndPrint(new int[][]{
                {2, 1, 1},
                {1, 1, 2},
                {1, 2, 1}
        });

        // Case 3: 3x3 no path
        System.out.println("Case 3 – 3x3 no path (all 2s):");
        GridTraversal.solveAndPrint(new int[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        // Case 4: 4x4 known path
        System.out.println("Case 4 – 4x4 known path:");
        GridTraversal.solveAndPrint(new int[][]{
                {3, 1, 1, 1},
                {1, 1, 1, 3},
                {1, 2, 1, 1},
                {1, 1, 1, 1}
        });

        // Case 5: random grid
        System.out.println("Case 5 – Random grid:");
        GridTraversal.solveAndPrint(GridTraversal.griGenarator());
    }


}