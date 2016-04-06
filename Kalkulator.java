package Zadaæa17;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Kalkulator extends JFrame implements ActionListener {
	JButton bt[];
	String natp[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "C", "+", "-", "*", "/", "sqrt", "="};
	char op;
	double rez;

	JTextField jtf;
	JLabel jlab;

	public Kalkulator() {
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
			//bt[k].setBackground(Color.BLACK);
		   // bt[k].setForeground(Color.WHITE);
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
		//ubaciti mnozenje i dijljenje
		if (bt[k].getText().equals("+") || bt[k].getText().equals("-") || bt[k].getText().equals("=")) {
			double pod = Double.parseDouble(jtf.getText());
			switch (op) {
			case '+':
				rez += pod;
				break;
			case '-':
				rez -= pod;
				break;
				//ubaciti casove za mnozenje i djeljenje
				
			}
			op = bt[k].getText().charAt(0);
			jtf.setText("");
			bt[10].setEnabled(true);
			jlab.setText(Double.toString(rez));
			return;
		}
		if (bt[k].getText().equals("C")) {
			rez = 0.0;
			op = '+';
			jtf.setText("");
			jlab.setText("");
			return;
		}
		//ubaciti za sqrt i za kvadrat ifove
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Kalkulator k = new Kalkulator();
		k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		k.show(true);
	}

}
