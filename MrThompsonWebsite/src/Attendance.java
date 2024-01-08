
    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import javax.swing.text.StyledDocument;
    import java.io.*;
    import java.util.ArrayList;
    import java.util.HashMap;


    public class Attendance extends JFrame {
        private JTextField enterClassHere;
        private JButton enterButton;
        private JButton enterButton1;
        private JScrollPane ClassPane;
        private JTabbedPane tabbedPane1;
        private JPanel panel1;
        private JPanel Tab;
        private JPanel TabPanel;
        private JTextField enterStudent;
        private JTextField chooseStudent;
        private JTextField MainenterEmail;
        private JPasswordField MainenterPassword;
        private JButton EmailButton;
        private JButton PasswordButton;
        private JPanel SignIn;
        private JTable table1;
        private JScrollPane StudentAttendance;
        private JButton enterButton2;
        private JButton enterButton3;
        private JButton absentButton;
        private JButton presentButton;
        private JLabel DateLabel;
        private JTextField DateField;
        private JPanel SpecifiedStd;
        private JTable StudentName;
        private JTable GradeTable;
        private JLabel MeanAtt;
        private JLabel MeanGrd;
        private JLabel MeanAtt7;
        private JLabel MeanGrd7;
        private JButton submitButton;
        private JButton excusedButton;
        private JTextField MeanAttField;
        private JTextField MeanGradeField;
        private JTextField MeanGrade3Field;
        private JButton addTestButton;
        private JButton button2;
        private JTable EpicTable;
        private JTextField textField5;
        private JButton submitCommentButton;
        private JButton removeStudentButton;
        private JTextField MeanAtt7Field;


        public Attendance(JFrame window, ArrayList attended) throws IOException, ClassNotFoundException {
            HashMap<String,String> classes = new HashMap();
            Homeroom homeroom = new Homeroom(classes, enterStudent,  chooseStudent,  table1,
                     enterButton2,  enterButton3,  absentButton,
                     presentButton,  DateLabel,  DateField,
                     SpecifiedStd,  tabbedPane1,  window,
                     attended,  excusedButton,  submitButton,  StudentName,  TabPanel, GradeTable, Tab,
                    removeStudentButton, MeanGradeField, MeanGrade3Field, MeanAttField, MeanAtt7Field);

            Login transfer = new Login(window, attended, MainenterEmail, MainenterPassword, PasswordButton);



            add(tabbedPane1);
            setTitle("Title");
            setSize(700, 350);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
            tabbedPane1.remove(Tab);
            tabbedPane1.remove(TabPanel);
            tabbedPane1.remove(SpecifiedStd);


            JTextPane x = new JTextPane();
            StyledDocument doc = x.getStyledDocument();



            PasswordButton.addActionListener(ActionEvent -> {
                String text = MainenterPassword.getText();
                String textp = MainenterEmail.getText();
                if (textp.equals("MrT")&& text.equals("1234"))
                {tabbedPane1.remove(SignIn);
                    tabbedPane1.add(Tab);
                    tabbedPane1.revalidate();
                    tabbedPane1.repaint();}


            });

            DefaultTableModel modelmaster = (DefaultTableModel) EpicTable.getModel();
            modelmaster.addColumn("Classes");

            enterButton.addActionListener(ActionEvent -> {

                String newClass = enterClassHere.getText();

                attended.add(newClass);
                for (int i = 0; i < attended.size(); i++) {
                    Object[] thing = {attended.get(i)};
                        modelmaster.addRow(thing);
                        tabbedPane1.revalidate();
                        tabbedPane1.repaint();
                    }
            });


            enterButton1.addActionListener(ActionEvent -> {
                int chosenStudent = EpicTable.getSelectedRow();
                String choose = EpicTable.getValueAt(chosenStudent,0).toString();
                String name = choose;
                tabbedPane1.addTab(name, TabPanel);
                tabbedPane1.revalidate();
                tabbedPane1.repaint();

            });
            DefaultTableModel modelio = (DefaultTableModel) StudentName.getModel();
            modelio.addColumn("Date");
            modelio.addColumn("Attendance");
            modelio.addColumn("Comments");

            DefaultTableModel modelino = (DefaultTableModel) GradeTable.getModel();
            modelino.addColumn("Test Number");
            modelino.addColumn("Grade");

            new FileAttempt(attended);
        }


    }





