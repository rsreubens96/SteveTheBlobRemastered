import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField userInputField;
	private JTextPane consoleTextPane;
	private JButton btnStart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(419, 0, 776, 707);
		contentPane.add(scrollPane);
		
		consoleTextPane = new JTextPane();
		consoleTextPane.setEditable(false);
		consoleTextPane.setBackground(Color.BLACK);
		scrollPane.setViewportView(consoleTextPane);
		
		userInputField = new JTextField();
		userInputField.setBounds(569, 707, 465, 54);
		contentPane.add(userInputField);
		userInputField.setColumns(10);
		
		JButton btnYes = new JButton("YES");
		btnYes.setBounds(419, 707, 152, 54);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNo.setBounds(1032, 707, 152, 54);
		contentPane.add(btnNo);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startButton();
			}
		});
		btnStart.setBounds(115, 404, 89, 23);
		contentPane.add(btnStart);
		this.appendMain("Hi");
	}
	
	public void appendMain(String message) {
		StyledDocument doc = this.consoleTextPane.getStyledDocument();
		SimpleAttributeSet design = new SimpleAttributeSet();
		StyleConstants.setForeground(design, Color.GREEN);
		try {
			doc.insertString(doc.getLength(), message + "\n", design);
		} catch (Exception e) {
			this.appendMain(e.toString());
		}
		int len = this.consoleTextPane.getDocument().getLength();
		this.consoleTextPane.setCaretPosition(len);
	}
	
	public void startButton() {
		Main main = new Main(this);
		main.run();
		btnStart.setEnabled(false);
		
	}
}
