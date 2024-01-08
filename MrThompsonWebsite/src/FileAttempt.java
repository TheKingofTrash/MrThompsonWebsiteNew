import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileAttempt {
    FileAttempt(ArrayList attended) throws IOException, ClassNotFoundException {
        File file = new File("Classes.txt");
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(attended);

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        attended = (ArrayList<String>) objectInputStream.readObject();

    }
}
