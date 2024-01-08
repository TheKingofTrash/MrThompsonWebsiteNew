import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends JFrame {
    public Student(JButton addTestButton, JFrame window, ArrayList attended, JPanel SpecifiedStd,
                   JTable StudentName, JTable GradeTable, JTextField MeanGradeField,
                   JTextField MeanGrade3Field, JTextField MeanAttField, JTextField MeanAtt7Field) throws IOException, ClassNotFoundException {

        final int[] x = {0};
        DefaultTableModel modelio = (DefaultTableModel) StudentName.getModel();
        modelio.addColumn("Date");
        modelio.addColumn("Attendance");

        DefaultTableModel modelino = (DefaultTableModel) StudentName.getModel();
        modelino.addColumn("Test Number");
        modelino.addColumn("Grade");

        addTestButton.addActionListener(ActionEvent-> {

            x[0] += 1;
            String test = "Test" + x[0];

            modelino.addRow(new String[]{test});
            GradeTable.revalidate();
            GradeTable.repaint();

        });


    }

    public Student(ArrayList<String> Datum, HashMap<String, String> name, JTable StudentName, JTable GradeTable, JTextField MeanGradeField,
                   JTextField MeanGrade3Field, JTextField MeanAttField, JTextField MeanAtt7Field) {
        final int[] x = {0};


        DefaultTableModel modelio = (DefaultTableModel) StudentName.getModel();


        for (int i = 0; i < Datum.size(); i++) {
            String thingy = Datum.get(i).toString();
            modelio.addRow(new String[]{thingy});
            StudentName.revalidate();
            StudentName.repaint();
        }
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < StudentName.getRowCount() ; i++) {
            String value = StudentName.getValueAt(i, 1).toString();

            if (value == "Absent") {
                a += 1;
            } else if (value == "Present") {
                b += 1;
            } else {
                c += 1;
            }
            int maximum = Math.max(b, a);
            int truemaximum = Math.max(maximum, c);
            String Finally;
             if (truemaximum == a) {
                Finally = "Absent";
                 MeanAttField.add(Finally);
             } else {
                 if (truemaximum == b) {
                     Finally = "Present";
                 } else {
                     Finally = "Excused";
                 }
                 MeanAttField.add(Finally);
             }
        }







                DefaultTableModel modelino = (DefaultTableModel) StudentName.getModel();

    }

    public Student(ArrayList<String> datum, HashMap<String, String> name, JTable studentName, JTable gradeTable) {
    }
}








