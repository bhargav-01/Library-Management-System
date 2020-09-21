package library1;

import javafx.scene.layout.Border;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class home {
    private JPanel panel1;
    private JButton bs;
    private JButton bn;
    private JButton bns;
    private JLabel newbook;
    private JLabel statistics;
    private JLabel newstudent;
    private JButton bi;
    private JButton br;
    private JButton ba;
    private JPanel p1;
    private JLabel issueBookLabel;
    private JLabel returnBookLabel;
    private JLabel aboutLabel;
    public static JFrame frame;
    public home() {
        bn.setBorder(new MatteBorder(0,0,2,0, Color.blue));
        bs.setBorder(new MatteBorder(0,0,2,0, Color.blue));
        bns.setBorder(new MatteBorder(0,0,2,0, Color.blue));
        bi.setBorder(new MatteBorder(0,0,2,0, Color.blue));
        br.setBorder(new MatteBorder(0,0,2,0, Color.blue));
        ba.setBorder(new MatteBorder(0,0,2,0, Color.blue));





        bn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              frame.setVisible(false);
              newbook b=new  newbook();
              b.main(new String[]{"1","2"});
            }
        });
        bns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                student s=new student();
                s.main(new String[]{"1","2"});
            }
        });
        bi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                issue1 s=new issue1();
                s.main(new String[]{"1","2"});
            }
        });
        br.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        br.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                returnbook s=new returnbook();
                s.main(new String[]{"1","2"});
            }
        });
        bs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                statatics s=new statatics();
                s.main(new String[]{"1","2"});
            }
        });
        ba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                frame.setVisible(false);
                about s=new about();
                s.main(new String[]{"1","2"});
            }
        });
        bn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_ENTER) {
                    frame.setVisible(false);
                    newbook b=new  newbook();
                    b.main(new String[]{"1","2"});
                }

                if(k==KeyEvent.VK_RIGHT) {
                    bs.requestFocus();

                }
                if(k==KeyEvent.VK_DOWN) {
                    bi.requestFocus();

                }

            }
        });
        bs.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_RIGHT) {
                    bns.requestFocus();

                }
                if(k==KeyEvent.VK_DOWN) {
                    br.requestFocus();

                }
                if(k==KeyEvent.VK_ENTER) {
                    frame.setVisible(false);

                    statatics s=new statatics();
                    s.main(new String[]{"1","2"});
                }

                if(k==KeyEvent.VK_LEFT) {
                    bn.requestFocus();

                }

            }
        });
        bns.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_LEFT) {
                    bs.requestFocus();

                }
                if(k==KeyEvent.VK_ENTER) {
                    frame.setVisible(false);
                    student s=new student();
                    s.main(new String[]{"1","2"});

                }
                if(k==KeyEvent.VK_DOWN) {
                    ba.requestFocus();

                }

            }
        });
        bi.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_RIGHT) {
                    br.requestFocus();

                }
                if(k==KeyEvent.VK_ENTER) {
                    frame.setVisible(false);
                    issue1 s=new issue1();
                    s.main(new String[]{"1","2"});
                }



                if(k==KeyEvent.VK_UP) {
                    bn.requestFocus();

                }

            }
        });
        br.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_LEFT) {
                    bi.requestFocus();

                }
                if(k==KeyEvent.VK_UP) {
                    bs.requestFocus();

                }
                if(k==KeyEvent.VK_RIGHT) {
                    ba.requestFocus();

                }
                if(k==KeyEvent.VK_ENTER) {
                    frame.setVisible(false);
                    returnbook s=new returnbook();
                    s.main(new String[]{"1","2"});

                }

            }
        });
        ba.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int k=e.getKeyCode();
                if(k==KeyEvent.VK_LEFT) {
                    br.requestFocus();

                }
                if(k==KeyEvent.VK_UP) {
                    bns.requestFocus();

                }
                if(k==KeyEvent.VK_ENTER) {
                    frame.setVisible(false);
                    about s=new about();
                    s.main(new String[]{"1","2"});

                }


            }
        });

    }

    public static void main(String[] args) {
        frame = new JFrame("home");
        frame.setContentPane(new home().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
