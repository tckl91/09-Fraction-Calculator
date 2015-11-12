//Kai Cheng

package fractionCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FractionCalculator extends JFrame {
	private JTextField screen;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero;
	private JButton add, subtract, multiply, divide;
	private JButton negation, invertion, backspace, fraction, clear, clearAll;
	private String num1 = "0", num2 = "", answer = "", display = "", memory = "0";
	private JPanel content;
	boolean operation = false;

	public FractionCalculator() {
		screen = new JTextField("0", 43);
		content = new JPanel();
		screen.setEditable(false);

		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		
		fraction = new JButton("/");
		negation = new JButton("negate");
		invertion = new JButton("invert");
		backspace = new JButton(((char) 8592) + "");
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton(((char) 215) + "");
		divide = new JButton(((char) 247) + "");
		clear = new JButton("clear");
		clearAll = new JButton("clear all");

		Dimension d = new Dimension(90, 35);
		NumString s = new NumString();
		Calculate cal = new Calculate();
		Delete del = new Delete();
		
		one.setPreferredSize(d);
		two.setPreferredSize(d);
		three.setPreferredSize(d);
		four.setPreferredSize(d);
		five.setPreferredSize(d);
		six.setPreferredSize(d);
		seven.setPreferredSize(d);
		eight.setPreferredSize(d);
		nine.setPreferredSize(d);
		zero.setPreferredSize(d);
		fraction.setPreferredSize(d);
		negation.setPreferredSize(d);
		invertion.setPreferredSize(d);
		backspace.setPreferredSize(d);
		add.setPreferredSize(d);
		subtract.setPreferredSize(d);
		multiply.setPreferredSize(d);
		divide.setPreferredSize(d);
		clear.setPreferredSize(d);
		clearAll.setPreferredSize(d);
		
		one.addActionListener(s);
		two.addActionListener(s);
		three.addActionListener(s);
		four.addActionListener(s);
		five.addActionListener(s);
		six.addActionListener(s);
		seven.addActionListener(s);
		eight.addActionListener(s);
		nine.addActionListener(s);
		zero.addActionListener(s);
		fraction.addActionListener(s);
		add.addActionListener(cal);
		subtract.addActionListener(cal);
		multiply.addActionListener(cal);
		divide.addActionListener(cal);
		negation.addActionListener(cal);
		invertion.addActionListener(cal);
		backspace.addActionListener(del);
		clear.addActionListener(del);
		clearAll.addActionListener(del);

		content.setLayout(new FlowLayout());
		content.add(screen, BorderLayout.NORTH);
		content.add(one);
		content.add(two);
		content.add(three);
		content.add(four);
		content.add(five);
		content.add(six);
		content.add(seven);
		content.add(eight);
		content.add(nine);
		content.add(zero);
		content.add(fraction);
		content.add(add);
		content.add(subtract);
		content.add(multiply);
		content.add(divide);
		content.add(negation);
		content.add(invertion);
		content.add(backspace);
		content.add(clear);
		content.add(clearAll);

		this.setContentPane(content);
	}

	private class NumString implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			JButton input = (JButton) event.getSource();
			display = screen.getText();
			
			if (operation == true) {
				memory = display;
			}

			operation = false;
			
			try {
				if (input.equals(one)) {
					if (num1.equals("0")) {
						num1 = "1";
					}
					else {
						num1 += "1";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(two)) {
					if (num1.equals("0")) {
						num1 = "2";
					}
					else {
						num1 += "2";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(three)) {
					if (num1.equals("0")) {
						num1 = "3";
					}
					else {
						num1 += "3";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(four)) {
					if (num1.equals("0")) {
						num1 = "4";
					}
					else {
						num1 += "4";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(five)) {
					if (num1.equals("0")) {
						num1 = "5";
					}
					else {
						num1 += "5";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(six)) {
					if (num1.equals("0")) {
						num1 = "6";
					}
					else {
						num1 += "6";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(seven)) {
					if (num1.equals("0")) {
						num1 = "7";
					}
					else {
						num1 += "7";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(eight)) {
					if (num1.equals("0")) {
						num1 = "8";
					}
					else {
						num1 += "8";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(nine)) {
					if (num1.equals("0")) {
						num1 = "9";
					}
					else {
						num1 += "9";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(zero)) {
					if (!num1.equals("0")) {
						num1 += "0";
					}
					screen.setText(num1);
				}
				
				else if (input.equals(fraction)) {
					num1 += "/";
					screen.setText(num1);
				}
			} 
			catch (ArithmeticException e) {
				screen.setText("Arithmetic Error");
			}
		}
	}

	private class Calculate implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			operation = true;
			
			try {
				JButton src = (JButton) event.getSource();
				Fraction m = new Fraction(memory);
				num2 = screen.getText();
				
				if (num2.substring(0, 1).equals("/") || num2.substring(num2.length() - 1, num2.length()).equals("/")) {
					throw new ArithmeticException();
				}
				
				Fraction n2 = new Fraction(num2);
				
				if (src.equals(add)) {
					m = m.add(n2);
					answer = m.toString();
					screen.setText(answer);
					num1 = "";
					memory = answer;
				}
				
				else if (src.equals(subtract)) {
					m = m.subtract(n2);
					answer = m.toString();
					screen.setText(answer);
					num1 = "";
					memory = answer;
				}
				
				else if (src.equals(multiply)) {
					m = m.multiply(n2);
					answer = m.toString();
					screen.setText(answer);
					num1 = "";
					memory = answer;
				}
				
				else if (src.equals(divide)) {
					m = m.divide(n2);
					answer = m.toString();
					screen.setText(answer);
					num1 = "";
					memory = answer;
				}
				
				else if (src.equals(negation)) {
					answer = n2.negate().toString();
					screen.setText(answer);
					num1 = "";
				}
				
				else if (src.equals(invertion)) {
					answer = n2.inverse().toString();
					screen.setText(answer);
					num1 = "";
				}

			}
			catch (ArithmeticException e) {
				screen.setText("Error");
				num1 = "";
			}
		}
	}

	private class Delete implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			JButton src = (JButton) event.getSource();
			
			if (src.equals(clear)) {
				num1 = "";
				screen.setText("");
			}
			
			else if (src.equals(backspace)) {
				if (num1.length() > 0) {
					num1 = num1.substring(0, num1.length() - 1);
					screen.setText(num1);
				}
			}
			
			else if (src.equals(clearAll)) {
				num1 = "";
				memory = "0";
				screen.setText(null);
				operation = false;
			}
		}
	}

	public class Fraction implements Comparable<Fraction> {
		public int numerator;
		public int denominator;

		Fraction(int numumerator, int denominator) {
			if (denominator == 0) {
				throw new ArithmeticException("Denominator Cannot Be 0.");
			}
			if (denominator < 0){
				numerator *= -1;
				denominator *= -1;
			}
			
			this.numerator = numumerator;
			this.denominator = denominator;
			normalize();
		}

		Fraction(int num) {
			this.numerator = num;
			this.denominator = 1;
		}

		Fraction(String str) {
			String[] nums = str.split("/");
			if (nums.length == 1){
				this.numerator = Integer.parseInt(nums[0].trim());
				this.denominator = 1;
			}
			else {
				this.numerator = Integer.parseInt(nums[0].trim());
				this.denominator = Integer.parseInt(nums[1].trim());
				if (this.denominator == 0) {
					throw new ArithmeticException("Denominator cannot be zero!");
				}
				if (this.denominator < 0) {
					this.numerator *= -1;
					this.denominator *= -1;
				}
				normalize();
			}	
		}

		public Fraction add(Fraction f) {
			return new Fraction((numerator * f.denominator + f.numerator * denominator), denominator * f.denominator);
		}

		public Fraction subtract(Fraction f) {
			return new Fraction((numerator * f.denominator) - (f.numerator * denominator), denominator * f.denominator);
		}

		public Fraction multiply(Fraction f) {
			return new Fraction(numerator * f.numerator, denominator * f.denominator);
		}

		public Fraction divide(Fraction f) {
			return new Fraction(numerator * f.denominator, denominator * f.numerator);
		}

		private void normalize() {
			int defaultNum = numerator;
			int defaultDenom = denominator;
			int temp;
			
			while (denominator != 0) {
				temp = denominator;
				denominator = numerator % denominator;
				numerator = temp;
			}
			int common = numerator;
			numerator = defaultNum / Math.abs(common);
			denominator = defaultDenom / Math.abs(common);
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Fraction)) {
				return false;
			}
			Fraction f = (Fraction) o;
			return ((numerator == f.numerator) && (denominator == f.denominator));
		}

		@Override
		public int hashCode() {
			return numerator * denominator;
		}

		public Fraction negate() {
			return new Fraction(-numerator, denominator);
		}

		public Fraction abs() {
			if (numerator >= 0) {
				return this;
			}
			return negate();
		}

		public Fraction inverse() {
			if (numerator == 0) {
				throw new ArithmeticException("Can't Invert 0.");
			}
			else if (numerator < 0) {
				return new Fraction(-denominator, -numerator);
			}
			else {
				return new Fraction(denominator, numerator);
			}
		}

		public int compareTo(Fraction f) {
			if (numerator / denominator == f.numerator / f.denominator) {
				return 0;
			}
			else if (numerator / denominator < f.numerator / f.denominator) {
				return -1;
			}
			else {
				return 1;
			}
		}

		@Override
		public String toString() {
			if (denominator == 1) {
				return Integer.toString(numerator);
			}
			else {
				return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
			}
		}
	}
		
	public static void main(String[] args) {
		FractionCalculator fc = new FractionCalculator();
		fc.setSize(500, 300);
		fc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fc.setVisible(true);
		fc.setResizable(false);
	}

}
