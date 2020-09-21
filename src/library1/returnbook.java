package library1;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class returnbook {
    private JTextField tn;
    private JTextField te;
    private JTextField tpg;
    private JTextField tp;
    private JTextField tpc;
    private JTextField ti;
    private JButton bs;
    private JTextField sti;
    private JTextField stn;
    private JTextField stfn;
    private JTextField stc;
    private JTextField stb;
    private JTextField sty;
    private JButton sbs;
    private JTextField td;
    private JButton returnButton;
    private JButton backButton;
    private JPanel p;
    private JTextField t;
    private JDateChooser date;
    public static JFrame frame;
    public returnbook() {


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


                    st = conn.prepareStatement("select  * from  issuebook where edition=? and book_name=?");
                    st.setString(1, s);
                    st.setString(2, s1);

                    rs = st.executeQuery();
                    rs.next();
                    ti.setText(rs.getString("book_id"));
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


                    st = conn.prepareStatement("select  * from  issuebook where id=?");
                    st.setString(1, s);


                    rs = st.executeQuery();
                    if (rs.next()) {
                        stfn.setText(rs.getString("name"));
                        stn.setText(rs.getString("fname"));
                        stc.setText(rs.getString("course"));
                        stb.setText(rs.getString("branch"));
                        sty.setText(rs.getString("year"));
                        t.setText(rs.getString("date"));
                        date.setRequestFocusEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Name Not Found");
                    }
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }

            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection conn=null;
                PreparedStatement st=null;
                PreparedStatement rt=null;

                ResultSet rs=null;
                try{
                    String username = "root";
                    String password = "bhargav$987";
                    String url = "jdbc:mysql://localhost:3306/library";
                    conn = DriverManager.getConnection(url, username, password);



                    String s=sti.getText();
                    String s1=stn.getText();
                    String s2=stfn.getText();
                    String s3=stc.getText();
                    String s4=stb.getText();
                    String s5=sty.getText();
                    String s6=ti.getText();
                    String s7=tn.getText();
                    String s8=te.getText();
                    String s9=tp.getText();
                    String s10=tpc.getText();
                    String s11=tpg.getText();
                    String s12=t.getText();
                    rt=conn.prepareStatement("delete  from issuebook where book_id=? and id=?");
                    rt.setString(1,s6);
                    rt.setString(2,s);
                    rt.execute();

                    st=conn.prepareStatement("insert  into return_book values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    st.setString(1,s6);
                    st.setString(2,s7);
                    st.setString(3,s8);
                    st.setString(4,s9);
                    st.setString(5,s10);
                    st.setString(6,s11);
                    st.setString(7,s);
                    st.setString(8,s1);
                    st.setString(9,s2);
                    st.setString(10,s3);
                    st.setString(11,s4);
                    st.setString(12,s5);
                    st.setString(13,s12);
                    st.setString(14,((JTextField)date.getDateEditor().getUiComponent()).getText());





                    st.execute();
                    JOptionPane.showMessageDialog(null,"Book Return Succesfully");
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
                    t.setText("");
                    ti.requestFocus();

                }catch(Exception e)
                {
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

    public static void main(String[] args) {
        frame= new JFrame("returnbook");
        frame.setContentPane(new returnbook().p);
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
