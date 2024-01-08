import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManagement {
    public static void writeDatum(ArrayList<String> datum) throws IOException {
        File file = new File("Datum.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(datum);
    }

    public static void writeName(HashMap<String, String> name) throws IOException {
        File file = new File("Name.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(name);
    }

    public static ArrayList<String> readDatum() throws IOException, ClassNotFoundException {
        File file = new File("Datum.txt");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (ArrayList<String>) ois.readObject();
    }
    public static HashMap<String,String> readName() throws IOException, ClassNotFoundException {
        File file = new File("Name.txt");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (HashMap<String, String>) ois.readObject();
    }


}
