package library1;

import javafx.scene.shape.Circle;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.*;
import java.util.Vector;

public class statatics {
    private JTable it;
    private JTable rt;
    private JPanel p;
    private JPanel p1;
    private JButton backButton;
    private JPanel p2;
    private JPanel p5;
    private JPanel p6;
    private JPanel p7;
    private JPanel p8;
    private JPanel p9;
    private JPanel p10;
    public  static  JFrame frame;

    public statatics() {
        String []a={"Book Id","Book Name","Edition","Publisher","Price","Pages","Issue Date"};
        it.setModel(new DefaultTableModel(null, a));
        it.getTableHeader().setFont(new Font("Calibri",Font.BOLD,20));
        it.getTableHeader().setOpaque(false);
        it.getTableHeader().setForeground(Color.white);
        it.getTableHeader().setBackground(new Color(14, 61, 255));

        String []b={"Student Id","Student Name","Father Name","Course","Branch","Year","Return Date"};
        rt.setModel(new DefaultTableModel(null, b));
        rt.getTableHeader().setFont(new Font("Calibri",Font.BOLD,20));
        rt.getTableHeader().setOpaque(false);
        rt.getTableHeader().setForeground(Color.white);
        rt.getTableHeader().setBackground(new Color(24, 43, 223));


        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            String username = "root";
            String password = "bhargav$987";
            String url = "jdbc:mysql://localhost:3306/library";
            conn = DriverManager.getConnection(url, username, password);


            st=conn.prepareStatement("select book_id,book_name,edition,publicer,price,pages,date  from issuebook");
            rs=st.executeQuery();
            ResultSetMetaData rsm=rs.getMetaData();
            int c=rsm.getColumnCount();
            DefaultTableModel d=(DefaultTableModel)it.getModel();

            d.setRowCount(0);
            while (rs.next())
            {
                Vector v2=new Vector();
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("book_id"));
                    v2.add(rs.getString("book_name"));
                    v2.add(rs.getString("edition"));
                    v2.add(rs.getString("publicer"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("pages"));
                    v2.add(rs.getString("date"));


                }
                d.addRow(v2);
            }
        } catch (Exception x) {
            System.out.print(x);
        }
        try {

            String username = "root";
            String password = "bhargav$987";
            String url = "jdbc:mysql://localhost:3306/library";
            conn = DriverManager.getConnection(url, username, password);


            st=conn.prepareStatement("select id,name,fname,course,branch,year,return_date  from return_book");
            rs=st.executeQuery();
            ResultSetMetaData rsm=rs.getMetaData();
            int c=rsm.getColumnCount();
            DefaultTableModel d=(DefaultTableModel)rt.getModel();

            d.setRowCount(0);
            while (rs.next())
            {
                Vector v2=new Vector();
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("fname"));
                    v2.add(rs.getString("course"));
                    v2.add(rs.getString("branch"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("return_date"));


                }
                d.addRow(v2);
            }
        } catch (Exception x) {
            System.out.print(x);
        }
        backButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionEvent) {
               frame.setVisible(false);
                home h=new home();
                h.main(new String[]{"1","2"});
            }
        });
    }

    public static void main(String[] args) {
       frame = new JFrame("statatics");
        frame.setContentPane(new statatics().p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
