import java.util.Scanner;
import javax.swing.JOptionPane;

public class calTwoDoubles {
    public static void main(String[] args){
        String strNum1, strNum2;
        // Scanner keyboard = new Scanner(System.in);
        strNum1 = JOptionPane.showInputDialog("Please enter double number 1 :");
        strNum2 = JOptionPane.showInputDialog("Please enter double number 2: ");
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1+num2;
        double diff = Math.abs(num1-num2);
        double product = num1*num2;
        double quotient = 0.0;
        
        System.out.println("Sum : " + sum);

        System.out.println("Difference: " + diff);

        System.out.println("Product: " + product);

        if (num2 != 0) {
            quotient = num1 / num2;
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }

        System.out.println("Quotient: " + quotient);
    }
}
