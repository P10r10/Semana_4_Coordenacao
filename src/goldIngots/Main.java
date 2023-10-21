package goldIngots;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static JTextField frameSettings(JButton jb) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));
        JLabel lb1 = new JLabel("Gold in scale: ", SwingConstants.RIGHT);
        JTextField tf1 = new JTextField();
        frame.add(lb1);
        frame.add(tf1);
        frame.add(jb);
        frame.setSize(300, 150);
        frame.setVisible(true);
        return tf1;
    }

    public static void main(String[] args) {

        JButton bt1 = new JButton("Stop");
        JTextField tf = frameSettings(bt1);
        Scale scale = new Scale(tf);
        Digger digger = new Digger(scale);
        Goldsmith goldsmith = new Goldsmith(scale);

        goldsmith.start();
        digger.start();

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goldsmith.interrupt();
                digger.interrupt();
            }
        });
    }
}
