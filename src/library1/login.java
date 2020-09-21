package library1;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import library1.signup;


import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
    private JButton bl;
    private JPasswordField tp;
    private JButton bs;
    private JButton bp;
    private JTextField tu;
    private JLabel user;
    private JLabel password;
    public JPanel p;
    public  static JFrame frame;
    public login() {

        p.setBorder(new SoftBevelBorder(5));
        bl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection conn=null;
                PreparedStatement st=null;
                ResultSet rs=null;
                try{
                    String username = "root";
                    String password = "bhargav$987";
                    String url = "jdbc:mysql://localhost:3306/library";
                    conn = DriverManager.getConnection(url, username, password);
                    String s=tu.getText();
                    st=conn.prepareStatement("select password from login where user=?");
                    st.setString(1,s);
                    rs=st.executeQuery();
                    rs.next();

                    char pass[]=tp.getPassword();
                    String s1=new String(pass);
                    if(s1.equals(rs.getString("password")))
                    {     frame.setVisible(false);
                         home h=new home();
                         h.main(new String[]{"1","20"});

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Wrong Password");
                    }

                }catch(Exception e)
                {
                    System.out.print(e.getMessage());
                }
            }

        });
        bs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                signup ob=new signup();
                ob.main(new String[]{"1", "2"});
            }
        });
        bp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                 forgotpasswor q=new forgotpasswor();
                q.main(new String[]{"1", "2"});
            }
        });
    }

    public static void main(String[] args) {
         frame = new JFrame("login");
        frame.setContentPane(new login().p);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

