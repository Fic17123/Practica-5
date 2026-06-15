package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import view.view_lienzo;

public class logic_view_lienzo implements ActionListener, KeyListener {

    private view_lienzo vl;
    private subprocessMoveObject hilo1;

    public logic_view_lienzo(view_lienzo vl_) {

        this.vl = vl_;

        vl.btn_start.addActionListener(this);
        vl.btn_pause.addActionListener(this);
        vl.btn_resume.addActionListener(this);

        vl.pn_lienzo.addKeyListener(this);
        vl.pn_lienzo.setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vl.btn_start) {

            if (hilo1 == null || !hilo1.isAlive()) {
                hilo1 = new subprocessMoveObject(vl);
                hilo1.start();
            }

            vl.pn_lienzo.requestFocus();

        } else if (e.getSource() == vl.btn_pause) {

            if (hilo1 != null) {
                hilo1.setFlag(false);
            }

        } else if (e.getSource() == vl.btn_resume) {

            hilo1 = new subprocessMoveObject(vl);
            hilo1.start();

            vl.pn_lienzo.requestFocus();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {

            vl.pn_lienzo.setJugadorY(-10);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            vl.pn_lienzo.setJugadorY(10);

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            vl.pn_lienzo.setJugadorX(-10);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            vl.pn_lienzo.setJugadorX(10);
        }

        if (vl.pn_lienzo.hayColision()) {

            vl.pn_lienzo.sumarPunto();

            vl.pn_lienzo.setObjeto1(
                    (int) (Math.random() * 300),
                    (int) (Math.random() * 150));

            if (vl.pn_lienzo.getScore() == 10) {

                JOptionPane.showMessageDialog(
                        null,
                        "Ganaste!\nPuntaje: 10");

                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}