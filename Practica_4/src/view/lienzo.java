package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class lienzo extends JPanel {

    private Point jugador = new Point(10, 90);
    private Point objeto1 = new Point(200, 100);

    private int score = 0;
    private ImageIcon fondo;

    public lienzo() {
        setFocusable(true);
        fondo = new ImageIcon("src/img/fondo1.jpg");
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) {
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
        g.setColor(Color.BLUE);
        g.drawRect(objeto1.x, objeto1.y, 50, 50);
        g.setColor(Color.RED);
        g.fillRect(objeto1.x + 5, objeto1.y + 5, 40, 40);
        g.setColor(Color.WHITE);
        g.fillOval(jugador.x, jugador.y, 45, 45);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Puntos: " + score, 260, 20);
    }
    public void setJugadorX(int x) {
        jugador.x += x;
        if (jugador.x < 0)
            jugador.x = 0;
        if (jugador.x > getWidth() - 45)
            jugador.x = getWidth() - 45;
        repaint();
    }
    public void setJugadorY(int y) {
        jugador.y += y;
        if (jugador.y < 0)
            jugador.y = 0;
        if (jugador.y > getHeight() - 45)
            jugador.y = getHeight() - 45;
        repaint();
    }
    public void setObjeto1(int x, int y) {
        objeto1.setLocation(x, y);
        repaint();
    }
    public boolean hayColision() {
        return jugador.x + 45 >= objeto1.x &&
               jugador.x <= objeto1.x + 50 &&
               jugador.y + 45 >= objeto1.y &&
               jugador.y <= objeto1.y + 50;
    }
    public void sumarPunto() {
        score++;
        repaint();
    }
    public int getScore() {
        return score;
    }
}