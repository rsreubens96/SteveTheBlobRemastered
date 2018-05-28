import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextPane textPaneMain;
	private boolean yes;
	private boolean no;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yes = true;
			}
		});
		panel.add(btnNewButton);
		
		this.textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(textField);
		this.textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				no = false;
			}
		});
		panel.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textPaneMain = new JTextPane();
		textPaneMain.setForeground(Color.GREEN);
		textPaneMain.setBackground(Color.BLACK);
		textPaneMain.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		textPaneMain.setEditable(false);
		scrollPane.setViewportView(textPaneMain);
		
		this.run();
		
	}
	
	public void appendMain(String message) {
		StyledDocument doc = this.textPaneMain.getStyledDocument();
		SimpleAttributeSet design = new SimpleAttributeSet();
		StyleConstants.setForeground(design, Color.GREEN);
		try {
			doc.insertString(doc.getLength(), message + "\n", design);
		} catch (Exception e) {
			this.appendMain(e.toString());
		}
		int len = this.textPaneMain.getDocument().getLength();
		this.textPaneMain.setCaretPosition(len);
	}
	
	public void clearTextBox() {
		this.textField.setText("");
	}
	
	public void run() {
		this.appendMain("Steve is back.");
		this.appendMain("Fuck you dickhead");
		this.appendMain("What is your fucking name");
	}

}
