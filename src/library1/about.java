package library1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class about {
    private JButton backButton;
    private JPanel p;
    public static JFrame frame;
    public about() {
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
        frame = new JFrame("about");
        frame.setContentPane(new about().p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300,100);
        frame.pack();
        frame.setVisible(true);
    }
}
