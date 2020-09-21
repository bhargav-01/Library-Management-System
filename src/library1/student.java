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

public class student {
    private JTextField ts;
    private JTextField tfn;
    private JTextField tn;
    private JComboBox tc;
    private JComboBox tb;
    private JComboBox ty;
    private JPanel p;
    private JPanel p1;
    private JPanel p7;
    private JButton br;
    private JButton bb;
    public static  JFrame frame;
    public student() {
        br.addActionListener(new ActionListener() {
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
                    String s = ts.getText();
                    String s1 = tn.getText();
                    String s2 = tfn.getText();
                    String s3 = (String) tc.getSelectedItem();
                    String s4 = (String) tb.getSelectedItem();
                    String s5 = (String) ty.getSelectedItem();

                    st = conn.prepareStatement("insert into student values(?,?,?,?,?,?) ");
                    st.setString(1, s);
                    st.setString(2, s1);
                    st.setString(3, s2);
                    st.setString(4, s3);
                    st.setString(5, s4);
                    st.setString(6, s5);
                    st.execute();
                    JOptionPane.showMessageDialog(null, "Register succesfully");
                   ts.setText("");
                    tfn.setText("");
                    tn.setText("");
                   tc.setSelectedIndex(1);
                    tb.setSelectedIndex(1);
                    ty.setSelectedIndex(1);

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        });
        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                home h = new home();
                h.main(new String[]{"1", "2"});
            }
        });

        ts.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k = e.getKeyCode();
                if (k == KeyEvent.VK_DOWN || k == KeyEvent.VK_ENTER) {
                    tn.requestFocus();

                }

            }
        });

        tn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k = e.getKeyCode();
                if (k == KeyEvent.VK_DOWN || k == KeyEvent.VK_ENTER) {
                    tfn.requestFocus();

                }
                if (k == KeyEvent.VK_UP) {
                    ts.requestFocus();

                }
            }
        });
        tfn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k = e.getKeyCode();
                if (k == KeyEvent.VK_DOWN || k == KeyEvent.VK_ENTER) {
                    tc.requestFocus();

                }
                if (k == KeyEvent.VK_UP) {
                    tn.requestFocus();

                }
            }
        });

    }

    public static void main(String[] args) {
        frame = new JFrame("student");
        frame.setContentPane(new student().p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300,50);
        frame.pack();
        frame.setVisible(true);
    }


}
