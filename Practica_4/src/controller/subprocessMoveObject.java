package controller;

import view.view_lienzo;

public class subprocessMoveObject extends Thread {

    private view_lienzo vl;
    private boolean flag = true;

    public subprocessMoveObject(view_lienzo vl_) {
        this.vl = vl_;
    }

    private int getRandomX() {
        return (int) (Math.random() * (vl.pn_lienzo.getWidth() - 50));
    }

    private int getRandomY() {
        return (int) (Math.random() * (vl.pn_lienzo.getHeight() - 50));
    }

    @Override
    public void run() {

        while (flag) {

            try {

                Thread.sleep(5000);

                vl.pn_lienzo.setObjeto1(
                        getRandomX(),
                        getRandomY());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}