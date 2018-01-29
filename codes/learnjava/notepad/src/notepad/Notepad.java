package notepad;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private String path;
	
	private JTextArea textArea;
	
	private boolean isSave = true;//假设文件已经保存

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
	 * Create the frame.
	 */
	public Notepad() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				if(!isSave) {
					int result = JOptionPane.showConfirmDialog(null, "是否需要保存", "提示", JOptionPane.YES_NO_OPTION);
					if(result == 0) {
						save();
					}
				}
				System.exit(0);
			}
		});
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				//ctrl+o的组合键
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
					
				}
			}
		});
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isSave = false;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isSave = false;
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isSave = false;
			}
		});
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu file = new JMenu("文件");
		bar.add(file);
		
		JMenuItem open = new JMenuItem("打开");
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				if(file != null) {
					path = file.getPath();
					String content = FileUtil.readFile(file.getPath());
					textArea.setText(content);
				}
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
				isSave = true;
			}
		});
		file.add(open);
		file.add(save);
		file.add(saveAs);
		
	}
	
	public void save() {
		if(path == null) {
			saveAs();
		}else {
			String content = textArea.getText();
			FileUtil.writeFile(path, content);
		}
		isSave = true;
	}
	
	public void saveAs() {
		JFileChooser chooser = new JFileChooser();
		chooser.showSaveDialog(null);
		File file = chooser.getSelectedFile();
		if(file != null) {
			path = file.getPath();
			String content = textArea.getText();
			FileUtil.writeFile(path, content);
		}
	}

}
