package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Login {
    public static boolean isClose = false;
    public static void main(String[] args) {
//        设置主题
        try {
            //设置主题
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();//主面板
        frame.setSize(400, 330);//面板大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        消除边框
        frame.setTitle("QQ登陆");
        frame.setUndecorated(true);
        JPanel panel1 = new JPanel();//上面板
        panel1.setPreferredSize(new Dimension(0,180));
        JPanel panel2 = new JPanel();//下面板
        panel2.setPreferredSize(new Dimension(0,150));
        BorderLayout borderLayout = new BorderLayout();//四边布局
        frame.setLayout(borderLayout);//设置主面板布局
        /*主面板添加上下面板*/
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        JLabel label1=new JLabel();
        label1.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\ideaproject\\qqlogin\\src\\images\\qq.jpg") );
        panel1.add(label1);//上面板添加图片标签
        MouseA mousea = new MouseA(frame);
        panel1.addMouseListener(mousea);
        panel1.addMouseMotionListener(mousea);
        //下面板分为3个面板
        BorderLayout panel2Layout = new BorderLayout();//四边布局
        panel2.setLayout(panel2Layout);
        JPanel panell = new JPanel();
        panell.setPreferredSize(new Dimension(125,0));
        JPanel panelc = new JPanel();
        JPanel panelr = new JPanel();
        panelr.setPreferredSize(new Dimension(100,0));
        panel2.add(panell,BorderLayout.WEST);
        panel2.add(panelc,BorderLayout.CENTER);
        panel2.add(panelr,BorderLayout.EAST);
        //左面板添加图片
        JLabel labell=new JLabel();
        labell.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\ideaproject\\qqlogin\\src\\images\\touxiang.jpg") );
        panell.add(labell);
        //下面板中间部分添加表格布局
        GridLayout centerLayout = new GridLayout(4,1);
        panelc.setLayout(centerLayout);
        //四个部分，用户名，密码，复选框，登陆按钮

        JTextField username = new JTextField("dd");
        JPasswordField password = new JPasswordField();
        String info1 = "QQ号码/手机/邮箱";
//        String info2 = "密码";
        username.setText(info1);
//        password.setText(info2);
        username.addFocusListener(new MyFocusListener(info1, username));//添加焦点事件反映
//        password.addFocusListener(new MyFocusListener(info2, password));
//        password.setEchoChar('f');
        JPanel remAuto = new JPanel();
        GridLayout gridLayout = new GridLayout(1,2);
        JCheckBox rememberPassword = new JCheckBox("记住密码");
        JCheckBox autoLogin= new JCheckBox("自动登陆");
        JButton loginButton = new JButton("登陆");
        loginButton.setForeground(Color.white);
        loginButton.setBackground(new Color(102, 153, 255));
        panelc.add(username);
        panelc.add(password);
        remAuto.add(rememberPassword);
        remAuto.add(autoLogin);
        panelc.add(remAuto);
        panelc.add(loginButton);
        //下面板右边添加流式布局
        JLabel reg=new JLabel("注册账号");
        //设置字体颜色
        reg.setForeground(new Color(0x26, 0x85, 0xe3));
        //设置字体
        reg.setFont(new Font("黑体", Font.PLAIN, 14));
        //设置鼠标样式
        reg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JLabel findPassword =new JLabel("找回密码");
        findPassword.setForeground(new Color(0x26,0x85,0xe3));
        findPassword.setFont(new Font("黑体", Font.PLAIN, 14));
        findPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        FlowLayout panelrFlow = new FlowLayout();
        panelr.setLayout(panelrFlow);
//        设置间距
        panelrFlow.setVgap(15);
        panelr.add(reg);
        panelr.add(findPassword);






        frame.setVisible(true);
    }
}
