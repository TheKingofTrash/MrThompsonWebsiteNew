import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("Datum.txt");
        File Namefile = new File("Name.txt");

        file.createNewFile();
        Namefile.createNewFile();

        JFrame window = new JFrame("Thompson Site");
        window.setSize(500,500);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<String> attended = new ArrayList<>();

        //Login login = new Login(window, attended, Attendance.MainenterEmail, Attendance.MainenterPassword, Attendance.PasswordButton);

        Attendance attendance = new Attendance(window, attended);

        //FileAttempt fileAttempt = new FileAttempt(attended);


    }
}