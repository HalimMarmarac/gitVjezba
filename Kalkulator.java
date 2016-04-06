
package misc;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")

public class Kalkulator extends JFrame implements ActionListener {
	
	JButton bt[];
	String natp[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "sqrt", "+", "-", "*", "/", "kva", "="};
	
	char op;
	double rez;

	JTextField jtf;
	JLabel jlab;

	public calc() {
		super("Kalkulator");
		rez = 0;
		op = '+';
		setSize(230, 280);
		setResizable(false);
		setLayout(new BorderLayout());
		Container cont = getContentPane();
		cont.add(jtf = new JTextField(), BorderLayout.NORTH);
		cont.add(jlab = new JLabel("0.0"), BorderLayout.CENTER);
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(6, 3));
		bt = new JButton[natp.length];
		for (int k = 0; k < natp.length; k++) {
			bt[k] = new JButton(natp[k]);
			bt[k].addActionListener(this);
			jp.add(bt[k]);
		}
		bt[natp.length - 1].setForeground(Color.red);
		cont.add(jp, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		int k;
		for (k = 0; k < bt.length; k++)
			if (e.getSource() == bt[k])
				break;
		if (k < 10) {
			String text;
			text = jtf.getText();
			text = text + bt[k].getText();
			jtf.setText(text);
			return;
		}
		if (bt[k].getText().equals(".")) {
			String text;
			text = jtf.getText();
			text = text + ".";
			jtf.setText(text);
			bt[k].setEnabled(false);
		}
		// ubaciti mnozenje i dijljenje
		if (bt[k].getText().equals("+") || bt[k].getText().equals("-") || bt[k].getText().equals("=")
				|| bt[k].getText().equals("*") || bt[k].getText().equals("/")) {

			double pod = Double.parseDouble(jtf.getText());
			switch (op) {
			case '+':
				rez += pod;
				break;
			case '-':
				rez -= pod;
				break;
			case '*':
				rez *=  pod;
				break;
			case '/':
				rez /= pod;
				break;
			// ubaciti casove za mnozenje i djeljenje

			}
			op = bt[k].getText().charAt(0);
			jtf.setText("");
			bt[10].setEnabled(true);
			jlab.setText(Double.toString(rez));
			return;
		}
		if (bt[k].getText().equals("sqrt")) {
			try{
				String textToBroj = jtf.getText();
				rez = Double.parseDouble(textToBroj);
				rez = Math.sqrt(rez);
				jtf.setText("");
				jlab.setText(Double.toString(rez));
				
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
			return;
		}
		if (bt[k].getText().equals("kva")) {
			try{
				String textToBroj = jtf.getText();
				rez = Double.parseDouble(textToBroj);
				rez = Math.pow(rez,2);
				jtf.setText("");
				jlab.setText(Double.toString(rez));
				
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
			return;
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		calc k = new calc();
		k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		k.setVisible(true);
	}
	
	
	
	

}
