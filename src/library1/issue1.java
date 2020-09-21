package library1;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.Vector;

public class issue1{
    private JTextField te;
    private JTextField tp;
    private JTextField tpc;
    private JTextField tpg;
    private JTextField tn;
    private JTextField ti;
    private JButton bs;
    private JPanel p1;
    public  JPanel p;
    private JLabel bookNameLabel;
    private JLabel pagesLabel;
    private JLabel publisherLabel;
    private JLabel priceLabel;
    private JLabel editionLabel;
    private JLabel bookIdLabel;
    private JTextField sti;
    private JTextField stn;
    private JTextField stfn;
    private JTextField stc;
    private JTextField stb;
    private JTextField sty;
    private JButton sbs;
    private JPanel p3;
    private JButton bb;
    private JButton bi;
    private JLabel studentIDLabel;
    private JLabel fatherNameLabel;
    private JLabel courseLabel;
    private JLabel branchLabel;
    private JLabel yearLabel;
    private JDateChooser date;
    private JPanel p7;
    private JTable it;
    private JScrollPane s1;
    public JScrollPane s;
    private JPanel pan;
    private JButton backButton;
    public static  JFrame frame;
    public issue1() {
        String[] a = {"Book Id", "Book Name", "Edition", "Publisher", "Price", "Pages", "Student Id", "Student Name", "Father Name", "Course", "Branch", "year", "Issue date"};
        it.setModel(new DefaultTableModel(null, a));
        it.getTableHeader().setFont(new Font("Calibri",Font.BOLD,20));
        it.getTableHeader().setOpaque(false);
        it.getTableHeader().setForeground(Color.white);
        it.getTableHeader().setBackground(new Color(10, 33, 131));

        table_upadate();
        bs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;
                try {
                    String username = "root";
                    String password = "bhargav$987";
                    String url = "jdbc:mysql://localhost:3306/library";
                    conn = DriverManager.getConnection(url, username, password);
                    String s = te.getText();
                    String s1 = tn.getText();


                    st = conn.prepareStatement("select  * from  book where edition=? and name=?");
                    st.setString(1, s);
                    st.setString(2, s1);

                    rs = st.executeQuery();
                    rs.next();
                    ti.setText(rs.getString("id"));
                    tp.setText(rs.getString("publicer"));
                    tpc.setText(rs.getString("price"));
                    tpg.setText(rs.getString("pages"));

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }

            }
        });
        sbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;
                try {
                    String username = "root";
                    String password = "bhargav$987";
                    String url = "jdbc:mysql://localhost:3306/library";
                    conn = DriverManager.getConnection(url, username, password);
                    String s = sti.getText();


                    st = conn.prepareStatement("select  * from  student where id=?");
                    st.setString(1, s);


                    rs = st.executeQuery();
                    if (rs.next()) {
                        stn.setText(rs.getString("name"));
                        stfn.setText(rs.getString("fname"));
                        stc.setText(rs.getString("course"));
                        stb.setText(rs.getString("branch"));
                        sty.setText(rs.getString("year"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Name Not Found");
                    }
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }

            }
        });
        bi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;
                try {
                    String username = "root";
                    String password = "bhargav$987";
                    String url = "jdbc:mysql://localhost:3306/library";
                    conn = DriverManager.getConnection(url, username, password);

                    String s = sti.getText();
                    String s1 = stn.getText();
                    String s2 = stfn.getText();
                    String s3 = stc.getText();
                    String s4 = stb.getText();
                    String s5 = sty.getText();
                    String s6 = tn.getText();
                    String s7 = te.getText();
                    String s8 = ti.getText();
                    String s9 = tp.getText();
                    String s10 = tpc.getText();
                    String s11 = tpg.getText();


                    st = conn.prepareStatement("insert  into issuebook values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    st.setString(1, s8);
                    st.setString(2, s6);
                    st.setString(3, s7);
                    st.setString(4, s9);
                    st.setString(5, s10);
                    st.setString(6, s11);
                    st.setString(7, s);
                    st.setString(8, s1);
                    st.setString(9, s2);
                    st.setString(10, s3);
                    st.setString(11, s4);
                    st.setString(12, s5);
                    st.setString(13, ((JTextField) date.getDateEditor().getUiComponent()).getText());


                    st.execute();
                    JOptionPane.showMessageDialog(null, "Book Issued");
                    sti.setText("");
                    stn.setText("");
                    stfn.setText("");
                    stc.setText("");
                    stb.setText("");
                    sty.setText("");
                    ti.setText("");
                    tn.setText("");
                    te.setText("");
                    tp.setText("");
                    tpc.setText("");
                    tpg.setText("");
                    ti.requestFocus();



                    table_upadate();

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        });



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                home h=new home();
                h.main(new String[]{"1","2"});
            }
        });
    }
    public void table_upadate()
    {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            String username = "root";
            String password = "bhargav$987";
            String url = "jdbc:mysql://localhost:3306/library";
            conn = DriverManager.getConnection(url, username, password);


            st = conn.prepareStatement("select  * from issuebook");
            rs = st.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c = rsm.getColumnCount();
            DefaultTableModel d = (DefaultTableModel) it.getModel();

            d.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("book_id"));
                    v2.add(rs.getString("book_name"));
                    v2.add(rs.getString("edition"));
                    v2.add(rs.getString("publicer"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("pages"));
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("fname"));
                    v2.add(rs.getString("course"));
                    v2.add(rs.getString("branch"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("date"));


                }
                d.addRow(v2);
            }
        } catch (Exception x) {
            System.out.print(x);
        }


    }

    public static void main(String[] args) {
        frame = new JFrame("issue1");
        frame.setContentPane(new issue1().pan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Calendar c = Calendar.getInstance();
        date = new JDateChooser(c.getTime());
        date.setDateFormatString("dd/MM/yyyy");
        Font f = new Font("Calibri", 0, 18);
        date.setFont(f);
    }
}
