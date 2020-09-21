package library1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class newbook {
    private JTextField ti;
    private JTextField tn;
    private JTextField tp;
    private JTextField te;
    private JTextField tpg;
    private JTextField tpc;
    private JButton ba;
    private JButton bd;
    private JPanel p;
    private JPanel p7;
    private JPanel p1;
    public  static  JFrame frame;
    public newbook() {
        ba.addActionListener(new ActionListener() {
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
                    String s=ti.getText();
                    String s1=tn.getText();
                    String s2=te.getText();
                    String s3=tp.getText();
                    String s4=tpc.getText();
                    String s5=tpg.getText();


                    st=conn.prepareStatement("insert into book values(?,?,?,?,?,?) ");
                    st.setString(1,s);
                    st.setString(2,s1);
                    st.setString(3,s2);
                    st.setString(4,s3);
                    st.setString(5,s4);
                    st.setString(6,s5);
                    st.execute();
                    JOptionPane.showMessageDialog(null,"Book succefully added in Library");
                    ti.setText("");
                    tn.setText("");
                    te.setText("");
                    tp.setText("");
                    tpc.setText("");
                    tpg.setText("");
                    ti.requestFocus();

                }catch(Exception e)
                {
                    System.out.print(e.getMessage());
                }
            }
        });
        bd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                home h=new home();
                h.main(new String[]{"1","2"});
            }
        });
        ti.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_DOWN ||k==KeyEvent.VK_ENTER) {
                    tn.requestFocus();

                }
            }
        });
        tn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_DOWN ||k==KeyEvent.VK_ENTER) {
                    te.requestFocus();

                }
                if(k==KeyEvent.VK_UP) {
                    ti.requestFocus();

                }
            }
        });

        te.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_DOWN ||k==KeyEvent.VK_ENTER) {
                    tp.requestFocus();

                }
                if(k==KeyEvent.VK_UP) {
                    tn.requestFocus();

                }
            }
        });
        tp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_DOWN ||k==KeyEvent.VK_ENTER) {
                    tpc.requestFocus();

                }
                if(k==KeyEvent.VK_UP) {
                    te.requestFocus();

                }
            }
        });
        tpc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_DOWN ||k==KeyEvent.VK_ENTER) {
                    tpg.requestFocus();

                }
                if(k==KeyEvent.VK_UP) {
                    tp.requestFocus();

                }
            }
        });
        tpg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();

                if(k==KeyEvent.VK_UP) {
                    tpc.requestFocus();

                }
            }
        });


    }

    public static void main(String[] args) {
         frame = new JFrame("newbook");
        frame.setContentPane(new newbook().p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300,50);
        frame.pack();
        frame.setVisible(true);
    }
}
