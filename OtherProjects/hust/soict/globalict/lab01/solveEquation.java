package OtherProjects.hust.soict.globalict.lab01;
import javax.swing.JOptionPane;

import java.util.Scanner;

public class solveEquation {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[] options = { "first-degree with one variable", "first-degree with two varible",
                "second degree with one varible" };
        int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice ",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            System.out.println("Enter number a: ");
            double a = keyboard.nextDouble();
            System.out.println("Enter number b: ");
            double b = keyboard.nextDouble();
            if (a == 0) {
                if (b == 0)
                    System.out.println("Infinite solution");
                else
                    System.out.println("No solution");
            } else {
                double root = (double) -b / a;
                System.out.println("Solution is " + root);
            }
        } else if (x == 1) {
            System.out.println("Enter number a11: ");
            double a11 = keyboard.nextDouble();
            System.out.println("Enter number a12: ");
            double a12 = keyboard.nextDouble();
            System.out.println("Enter number b1: ");
            double b1 = keyboard.nextDouble();

            System.out.println("Enter number a21: ");
            double a21 = keyboard.nextDouble();
            System.out.println("Enter number a22: ");
            double a22 = keyboard.nextDouble();
            System.out.println("Enter number b2: ");
            double b2 = keyboard.nextDouble();

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - a12 * b2;
            double D2 = a11 * b2 - a21 * b1;
            // Check if the determinant is zero
            if (D == 0) {
                // Check if the system of equations has infinitely many solutions
                if ((D1 == 0) && (D2 == 0)) {
                    System.out.println("The system of equations has infinitely many solutions.");
                } else {
                    System.out.println("The system of equations has no solution.");
                }
            } else {
                // Calculate the values of x and y
                double x1 = (double) D1 / D;
                double x2 = (double) D2 / D;

                System.out.println("Solution:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        } else if (x == 2) {
            System.out.println("Enter number a: ");
            double a = keyboard.nextDouble();
            System.out.println("Enter number b: ");
            double b = keyboard.nextDouble();
            System.out.println("Enter number c: ");
            double c = keyboard.nextDouble();
            if (a == 0) {
                if (b == 0) {
                    if (c == 0)
                        System.out.println("Infinite solution");
                    else
                        System.out.println("No solution");
                } else {
                    double root = (double) -c / b;
                    System.out.println("Solution is " + root);
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta > 0) {
                    // Two real and distinct roots
                    double root1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double root2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("Two real and distinct roots:");
                    System.out.println("Root 1 = " + root1);
                    System.out.println("Root 2 = " + root2);
                } else if (delta == 0) {
                    // One real and repeated root
                    double root = -b / (2 * a);
                    System.out.println("One real and repeated root:");
                    System.out.println("Root = " + root);
                } else {
                    System.out.println("No real solution");
                }

            }
        }
    }
}
