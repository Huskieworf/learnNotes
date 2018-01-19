package login;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseA extends MouseAdapter {
    //按下时鼠标的x与y
    private int oldX;
    private int oldY;
    private JFrame frame ;
    //按下时界面的x与y
    private int frameX;
    private int frameY;
    //是否被鼠标按住
    private boolean isPressed = false;

    public MouseA(JFrame frame) {
        this.frame = frame;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            isPressed = true;
        }
        oldX = e.getXOnScreen();
        oldY = e.getYOnScreen();
        //界面的X
        frameX = frame.getX();
        frameY = frame.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(isPressed) {
            int newX = e.getXOnScreen();
            int newY = e.getYOnScreen();
            frame.setLocation(newX-oldX+frameX, newY-oldY+frameY);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        //获取点击时鼠标的位置
        int mx = e.getX();
        int my = e.getY();
        if(mx > 375 && mx < 400 && my > 0 && my < 30) {
            Login.isClose = true;
        }else {
            Login.isClose = false;
        }
        frame.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //获取点击时鼠标的位置
        int mx = e.getX();
        int my = e.getY();
        //最小化
        if(mx > 350 && mx < 375 && my > 0 && my < 30) {
            System.out.println("最小化");
            frame.setExtendedState(JFrame.ICONIFIED);
            //程序退出
        }else if(mx > 375 && mx < 400 && my > 0 && my < 30) {
            System.out.println("程序退出");
            System.exit(0);
        }
    }
}
