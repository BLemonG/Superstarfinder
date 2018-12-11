package Superstar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.io.File;

import javax.swing.JToolBar;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class Superstarfinder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultTableModel dm=new DefaultTableModel();
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Superstarfinder frame = new Superstarfinder();
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
	public Superstarfinder() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(101, 124, 244, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnFindSuperstar = new JButton("Find Superstar");
		btnFindSuperstar.setBounds(10, 68, 224, 29);
		panel.add(btnFindSuperstar);
		btnFindSuperstar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnFindSuperstar.addActionListener(new ActionListener() {
			private AbstractButton txt_dateiNamenFeld;

			public void actionPerformed(ActionEvent e) {
				
//				Superstar supi1 = new Superstar(comboBox);
//				AbstractButton txt_dateiNamenFeld;
				setTitle(txt_dateiNamenFeld.getText());
			}
		});
		btnFindSuperstar.setForeground(Color.BLACK);
		btnFindSuperstar.setBackground(Color.LIGHT_GRAY);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.RED);
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(170, 33, 64, 24);
		
			
			comboBox.addItem("1.txt");
			comboBox.addItem("2.txt");
			comboBox.addItem("3.txt");
			comboBox.addItem("4.txt");
			comboBox.addItem("5.txt");
			
		panel.add(comboBox);
		comboBox.setEditable(true);
		comboBox.setToolTipText("serrhad");
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JTextPane txtpnDateiname = new JTextPane();
		txtpnDateiname.setBackground(Color.RED);
		txtpnDateiname.setForeground(Color.BLACK);
		txtpnDateiname.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnDateiname.setText("        Dateiname:");
		txtpnDateiname.setBounds(10, 33, 150, 24);
		panel.add(txtpnDateiname);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 15, 645, 270);
		{
			JTable table1 = new JTable(dm);;
			scroll.setViewportView(table1);
			getContentPane().add(scroll);
		}
		
		JEditorPane dtrpnDerSuperstarIst = new JEditorPane();
		dtrpnDerSuperstarIst.setBounds(47, 58, 107, 20);
		dtrpnDerSuperstarIst.setText("Der Superstar ist:");
		contentPane.add(dtrpnDerSuperstarIst);
		
		JButton btnFindSuperstar = new JButton("Find Superstar");
		btnFindSuperstar.setBounds(10, 68, 224, 29);
		panel.add(btnFindSuperstar);
		btnFindSuperstar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnFindSuperstar.addActionListener(new ActionListener() {
			private AbstractButton txt_dateiNamenFeld;

			public void actionPerformed(ActionEvent e) {
				
				Superstar supi1 = new Superstar(comboBox);
//				AbstractButton txt_dateiNamenFeld;
				setTitle(txt_dateiNamenFeld.getText());
			}
		});
		
		
		textField = new JTextField();
		textField.setBounds(155, 58, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
