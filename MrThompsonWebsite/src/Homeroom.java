import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.Array;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Homeroom extends JFrame {

    public Homeroom(HashMap<String, String>classes, JTextField enterStudent, JTextField chooseStudent, JTable table1,
                    JButton enterButton2, JButton enterButton3, JButton absentButton,
                    JButton presentButton, JLabel DateLabel, JTextField DateField,
                    JPanel SpecifiedStd, JTabbedPane tabbedPane1, JFrame window,
                    ArrayList attended, JButton excusedButton, JButton submitButton, JTable StudentName, JPanel TabPanel, JTable GradeTable, JPanel Tab,
                    JButton removeStudentButton, JTextField MeanGradeField,
                    JTextField MeanGrade3Field, JTextField MeanAttField, JTextField MeanAtt7Field)
                     {

        HashMap<String, String> Name = new HashMap<>();
        ArrayList<String> Datum = new ArrayList<>();

        Student student = new Student(Datum,Name,StudentName, GradeTable, MeanGradeField,
                 MeanGrade3Field, MeanAttField,  MeanAtt7Field );

        //HashMap<String, String> Name = FileManagement.readName();
        //ArrayList<String> Datum = FileManagement.readDatum();



        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.addColumn("Student");
        model.addColumn("Attendance");
        model.addColumn("Comments");

        String date = new SimpleDateFormat("yyyy-dd-MM").format(new Date());
        DateField.setText(date);


        enterButton2.addActionListener(ActionEvent-> {
            String newClass = enterStudent.getText();
            String student2 = newClass.toString();
            classes.put(Tab.getName(),student2);
            for (int i = 0; i < classes.size(); i++) {
                model.addRow(new String[]{classes.get(Tab.getName())});
                table1.revalidate();
                table1.repaint();
            }



        });

        SpecifiedStd.getName();

        absentButton.addActionListener(ActionEvent->{
            table1.setValueAt("Absent", table1.getSelectedRow(),1);
        });

        presentButton.addActionListener(ActionEvent->{
            table1.setValueAt("Present", table1.getSelectedRow(),1);
        });

        excusedButton.addActionListener(ActionEvent-> {
                    table1.setValueAt("Excused", table1.getSelectedRow(), 1);
        });

        enterButton3.addActionListener(ActionEvent ->{
            tabbedPane1.add(SpecifiedStd);
            tabbedPane1.revalidate();
            tabbedPane1.repaint();
        });

        removeStudentButton.addActionListener(ActionEvent-> {
            classes.remove(Tab.getName(), table1.getValueAt(table1.getSelectedRow(), 1));
            model.removeRow(table1.getSelectedRow());
        });

        //ArrayList<String> things = new ArrayList<>();




        DefaultTableModel modelio = (DefaultTableModel) StudentName.getModel();



        submitButton.addActionListener(ActionEvent->{
            String time = DateField.getText();
            Datum.add(time);


            for (int i = 0; i < table1.getRowCount(); i++) {

                String name = table1.getValueAt(i, 0).toString();
                String att = table1.getValueAt(i, 1).toString();
                //things.add(table1.getValueAt(i,0).toString());
                Name.put(name,att);

            }
            System.out.println(Name);
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt("",i,1);
            }
            try {
                FileManagement.writeDatum(Datum);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                FileManagement.writeName(Name);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        enterButton3.addActionListener(ActionEvent->{
            String chooseStu = chooseStudent.getText();
            String chosen = chooseStu.toString();
            tabbedPane1.add(chosen, SpecifiedStd);

            for (int i = 0; i < Datum.size(); i++) {
                Object[] please = {Datum.get(i)};
                modelio.addRow(please);
                StudentName.revalidate();
                StudentName.repaint();

                Set Namess = Name.keySet() ;
                System.out.println(Namess.toArray()[i]);
                System.out.println(chosen);

                if (chosen.equals(Namess.toArray()[i])) {
                    String Finally = Name.get(chosen);
                    System.out.println(Finally);
                    modelio.setValueAt(Finally, i, 1);
                    System.out.println("henlo");
                    tabbedPane1.revalidate();
                    tabbedPane1.repaint();

                }
                else{
                    System.out.println("Does work");
                }
            }

        });






    }
    public void Emilio(ArrayList<String> Datum){
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("data.txt"))){
            ois.writeObject(Datum);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    }




