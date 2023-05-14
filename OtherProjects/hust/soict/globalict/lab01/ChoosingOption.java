package OtherProjects.hust.soict.globalict.lab01;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        // int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket",
        //         "Confirmation", JOptionPane.YES_NO_OPTION);
        // // int option = JOptionPane.showConfirmDialog(null, "Do you want to change to
        // // the first class ticket" );
        // JOptionPane.showMessageDialog(null, "You've chose: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        // System.exit(0);

        String[] options = { "I do","I don't" };
        int x = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket",
                "Confirmation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
}
