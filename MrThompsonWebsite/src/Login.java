import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends JFrame {

    public Login(JFrame window, ArrayList attended, JTextField MainenterEmail, JPasswordField MainenterPassword,
                 JButton passwordButton) {


        String text = MainenterEmail.getText();
        String textp = MainenterPassword.getText();
        if (text.equals("MrT") && textp.equals("1234")){
            try {
                new Attendance(window, attended);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else;
        System.out.println("Wrong");
    }
}

