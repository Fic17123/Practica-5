package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_lienzo;

public class view_lienzo extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public JButton btn_start;
    public JButton btn_pause;
    public JButton btn_resume;

    public lienzo pn_lienzo;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    view_lienzo frame = new view_lienzo();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public view_lienzo() {

        setTitle("Atrapa el Cuadrado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 340);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 0, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        setContentPane(contentPane);

 
        JPanel pn_control = new JPanel();
        pn_control.setBounds(10, 10, 395, 40);

        contentPane.add(pn_control);

        btn_start = new JButton("START");
        pn_control.add(btn_start);

        btn_pause = new JButton("PAUSE");
        pn_control.add(btn_pause);

        btn_resume = new JButton("RESUME");
        pn_control.add(btn_resume);

  
        pn_lienzo = new lienzo();
        pn_lienzo.setBounds(10, 60, 395, 230);

        contentPane.add(pn_lienzo);

  
        new logic_view_lienzo(this);

        setLocationRelativeTo(null);
    }
}