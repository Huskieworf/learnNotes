import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Notepad extends JFrame {
    /*文件选项*/
    private JPanel contentPane;
    /*打开路径*/
    private String path;
    /*文本输入*/
    private JTextArea textArea;
    /*文件是否保存flag*/
    private boolean isSave;

    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) {
        /**miss1  EventQueue.invokeLater*/
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Notepad frame = new Notepad();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 构造方法
     */
    public Notepad() {
        //设置点击关闭无响应，先判断是否应该保存
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //设置边界
        setBounds(400, 200, 800, 500);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        //添加窗口监听事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                /**miss2 为什么yes可以正常退出而no不能*/
                if (!isSave) {
                    int option = JOptionPane.showConfirmDialog(null, "是否需要保存", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        save();
                        System.exit(0);
                    }
                    if (option == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }

                    if (option == JOptionPane.CANCEL_OPTION) {
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                }
            }
        });
        textArea = new JTextArea();
        //热键的功能设置
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //ctrl+o的组合键
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
                    open();
                }
                //ctrl+s的组合键
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
                    save();
                }
                //ctrl+shift+s的组合键
                if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) {
                    saveAs();
                }
            }
        });
        //文本内容是否变化，如果变化将isSave的flag设置为false
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                isSave = false;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                isSave = false;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                isSave = false;
            }
        });
        //设置文本的滚动条
        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        //设置文件菜单选项
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu file = new JMenu("文件");
        bar.add(file);
        JMenuItem open = new JMenuItem("打开");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        JMenuItem save = new JMenuItem("保存");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        JMenuItem saveAs = new JMenuItem("另存为");
        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAs();
            }
        });
        file.add(open);
        file.add(save);
        file.add(saveAs);
    }

    /**
     * 保存
     */
    public void save() {
        if(path==null){
            saveAs();
        }
        else {
            String content = textArea.getText();
            FileUtil.writeFile(path,content);
            isSave=true;
        }
    }

    /**
     * 另存为
     */
    public void saveAs() {
        JFileChooser chooser=new JFileChooser();
        chooser.showSaveDialog(null);
        File file = chooser.getSelectedFile();
        if(file != null){
            String content = textArea.getText();
            path=file.getPath();
            FileUtil.writeFile(path,content);
        }
        isSave=true;
    }

    /**
     * 打开文件
     */
    public void open() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        if (file != null) {
            path=file.getPath();
            String content = FileUtil.readFile(path);
            textArea.setText(content);
        }
    }
}
