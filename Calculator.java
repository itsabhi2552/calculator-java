import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener
{
	double firstnum;
	double secondnum;
	double result;
	String operators;

	JLabel label;
	JButton button[];
	JTextField txtfld;
	JRadioButton converter;
	JRadioButton calculator;
	JRadioButton scientific;

	public Calculator()
	{
		ButtonGroup mode = new ButtonGroup();
		Cursor crsr = new Cursor(Cursor.HAND_CURSOR);//creating object of Cursor(hand cursor)
		Font font = new Font("SansSerif",Font.PLAIN,20);//creating object of Font(for textfield)
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel();

		txtfld = new JTextField();
		txtfld.setFont(font);//font setting for textfield
		txtfld.setBounds(14, 25, 208, 35);//positioning of textfield
		txtfld.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char character = e.getKeyChar();
				if (!Character.isDigit(character))
					e.consume();
			}
		});

		converter = new JRadioButton("Converter Mode", false);
		calculator = new JRadioButton("Calculator Mode", true);
		scientific = new JRadioButton("Scientific Mode", false);
		converter.setBounds(10, 85, 120, 15);
		calculator.setBounds(10, 105, 120, 15);
		scientific.setBounds(10, 65, 120, 15);
		mode.add(converter);
		mode.add(calculator);
		mode.add(scientific);
		converter.setCursor(crsr);
		calculator.setCursor(crsr);
		scientific.setCursor(crsr);
		calculator.setEnabled(false);

		button=new JButton[38];
		for(int i = 0; i <= 9; i++)
			button[i] = new JButton(String.valueOf(i));
		button[10] = new JButton("\u00B1");//plus minus button
		button[11] = new JButton(".");//point button
		button[12] = new JButton("+");//addition button
		button[13] = new JButton("-");//subtraction button
		button[14] = new JButton("*");//multiplication button
		button[15] = new JButton("/");//division button
		button[16] = new JButton("=");//equal button
		button[17] = new JButton("\u2190");//backspace button
		button[18] = new JButton("Clear");//clear button
		button[19] = new JButton("Factorial");//factorial button
		button[20] = new JButton("Binary");//binary button
		button[21] = new JButton("Octal");//octal button
		button[22] = new JButton("Hexadecimal");//hexadecimal button
		button[23] = new JButton("log");//log button
		button[24] = new JButton("exp");//exponential button
		button[25] = new JButton("sqrt");//square root button
		button[26] = new JButton("x^2");//square button
		button[27] = new JButton("x^3");//cube button
		button[28] = new JButton("x^x");//power button
		button[29] = new JButton("sin");//sin button
		button[30] = new JButton("cos");//cos button
		button[31] = new JButton("tan");//tan button
		button[32] = new JButton("sin-1");//sin inverse button
		button[33] = new JButton("cos-1");//cos inverse button
		button[34] = new JButton("tan-1");//tan inverse button
		button[35] = new JButton("sinh");//sin hyperbolic button
		button[36] = new JButton("cosh");//cos hyperbolic button
		button[37] = new JButton("tanh");//tan hyperbolic button
		button[18].setBounds(150, 77, 71, 30);//positioning of clear button
		
		calculator_mode_buttons_positioning();//calling calculator_mode_buttons_positioning
		
		for(int i = 0; i <= 37; i++)
		{
			button[i].setCursor(crsr);
			button[i].addActionListener(this);
			panel.add(button[i]);
		}
		converter.addActionListener(this);
		calculator.addActionListener(this);
		scientific.addActionListener(this);

		panel.add(label);
		panel.add(txtfld);
		panel.add(converter);
		panel.add(calculator);
		panel.add(scientific);
		
		this.add(panel);
	}
	
	public void calculator_mode_buttons_positioning()
	{
		Font font = new Font("SansSerif", Font.BOLD, 12);//creating object of Font(for label)
		label.setText("");
		txtfld.setText("");
		label.setFont(font);//font setting for label
		label.setBounds(14, 5, 208, 15);//repositioning of label
		label.setHorizontalAlignment(JTextField.RIGHT);//Alignment setting to the right for label
		txtfld.setHorizontalAlignment(JTextField.RIGHT);//Alignment setting to the right for textfield
		
		for(int i = 0; i <= 17; i++)//enabling buttons(0 to backspace)
			button[i].setEnabled(true);
		button[0].setBounds(67, 290, 48, 30);
		for(int i = 1, j = 14, k = 250; i <= 9; i++)//positioning of buttons(1 to 9)
		{
			if(j == 173)
			{
				j = 14;
				k -= 40;
			}
			button[i].setBounds(j, k, 48, 30);
			j += 53;
		}
		button[10].setBounds(14, 290, 48, 30);//plus minus button
		button[11].setBounds(120, 290, 48, 30);//point
		button[12].setBounds(173, 170, 47, 70);//addition
		button[13].setBounds(120, 130, 48, 30);//subtraction
		button[14].setBounds(67, 130, 48, 30);//multiplication
		button[15].setBounds(14, 130, 48, 30);//division
		button[16].setBounds(173, 250, 47, 70);//equal
		button[17].setBounds(173, 130, 47, 30);//backspace
		for(int i = 19; i <= 37; i++)//disabling buttons(factorial to hexadecimal)
		{
			button[i].setEnabled(false);
			button[i].setBounds(0, 0, 0, 0);
		}
	}
	
	public void converter_mode_buttons_positioning()
	{
		Font font = new Font("SansSerif", Font.BOLD, 20);//creating object of Font(for label)
		label.setText("");
		txtfld.setText("");
		label.setFont(font);//font setting for label
		label.setBounds(14, 290, 208, 35);//repositioning of label
		label.setHorizontalAlignment(JTextField.CENTER);//Alignment setting to the right for label
		txtfld.setHorizontalAlignment(JTextField.CENTER);//Alignment setting to the right for textfield
		
		for(int i = 0; i <= 17; i++)//disabling buttons(0 to equal)
		{
			button[i].setEnabled(false);
			button[i].setBounds(0, 0, 0, 0);
		}
		for(int i = 23; i <= 37; i++)//disabling buttons(log to sin hyperbolic)
		{
			button[i].setEnabled(false);
			button[i].setBounds(0, 0, 0, 0);
		}
		for(int i = 19; i <= 22; i++)//enabling buttons(factorial to hexadecimal)
			button[i].setEnabled(true);
		button[19].setBounds(60, 130, 120, 30);//factorial button
		button[20].setBounds(60, 170, 120, 30);//binary button
		button[21].setBounds(60, 210, 120, 30);//octal button
		button[22].setBounds(60, 250, 120, 30);//hexadecimal button
	}
	
	public void scientific_mode_buttons_positioning()
	{
		Font font = new Font("SansSerif", Font.BOLD, 12);//creating object of Font(for label)
		label.setText("");
		txtfld.setText("");
		label.setFont(font);//font setting for label
		label.setBounds(14, 5, 208, 15);//repositioning of label
		label.setHorizontalAlignment(JTextField.RIGHT);//Alignment setting to the right for label
		txtfld.setHorizontalAlignment(JTextField.RIGHT);//Alignment setting to the right for textfield
		
		for(int i = 0; i <= 17; i++)//disabling buttons(0 to equal)
		{
			button[i].setEnabled(false);
			button[i].setBounds(0, 0, 0, 0);
		}
		for(int i = 19; i <= 22; i++)//disabling buttons(factorial to hexadecimal)
		{
			button[i].setEnabled(false);
			button[i].setBounds(0, 0, 0, 0);
		}
		for(int i = 23; i <= 37; i++)//enabling buttons(log to tanh)
			button[i].setEnabled(true);
		for(int i = 23, j = 14, k = 130; i <= 37; i++)//positioning of buttons(1 to 9)
		{
			if(j == 224)
			{
				j = 14;
				k += 40;
			}
			button[i].setBounds(j, k, 66, 30);
			j += 70;
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == calculator)//RadioButton calculator ActionListener
		{
			converter.setEnabled(true);
			scientific.setEnabled(true);
			calculator.setEnabled(false);
			calculator_mode_buttons_positioning();//calculator_mode_buttons_positioning
		}
		else if(e.getSource() == converter)//RadioButton converter ActionListener
		{
			converter.setEnabled(false);
			scientific.setEnabled(true);
			calculator.setEnabled(true);
			converter_mode_buttons_positioning();//calling converter_mode_buttons_positioning	
		}
		else if(e.getSource() == scientific)//RadioButton scientific ActionListener
		{
			converter.setEnabled(true);
			scientific.setEnabled(false);
			calculator.setEnabled(true);
			scientific_mode_buttons_positioning();//calling scientific_mode_buttons_positioning	
		}

		for(int i = 0; i <= 9; i++)//buttons(0 to 9) ActionListener
		{
			if(e.getSource()==button[i])
			{
				String iNum = txtfld.getText() + button[i].getText();
				txtfld.setText(iNum);
			}
		}
		if(e.getSource() == button[10])//plus minus ActionListener
		{
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			input *= (-1);
			txtfld.setText(String.valueOf(input));
		}
		else if(e.getSource() == button[11])//point ActionListener
		{
			if(!txtfld.getText().contains("."))
				txtfld.setText(txtfld.getText() + button[11].getText());
		}
		else if(e.getSource() == button[12])//addition ActionListener
		{
			firstnum = Double.parseDouble(txtfld.getText());
			label.setText(firstnum + "+");
			txtfld.setText(null);
			operators = ("+");
		}
		else if(e.getSource() == button[13])//subtraction ActionListener
		{
			firstnum = Double.parseDouble(txtfld.getText());
			label.setText(firstnum + "-");
			txtfld.setText(null);
			operators = ("-");
		}
		else if(e.getSource() == button[14])//multiplication ActionListener
		{
			firstnum = Double.parseDouble(txtfld.getText());
			label.setText(firstnum + "*");
			txtfld.setText(null);
			operators = ("*");
		}
		else if(e.getSource() == button[15])//division ActionListener
		{
			firstnum = Double.parseDouble(txtfld.getText());
			label.setText(firstnum + "/");
			txtfld.setText(null);
			operators = ("/");
		}
		else if(e.getSource() == button[16])//equal ActionListener
		{
			String answer;
			secondnum = Double.parseDouble(txtfld.getText());
			if(operators == "+")
			{
				result = firstnum + secondnum;
				answer = String.format("%.2f", result);
				label.setText("");
				txtfld.setText(answer);
			}
			else if(operators == "-")
			{
				result = firstnum - secondnum;
				answer = String.format("%.2f", result);
				label.setText("");
				txtfld.setText(answer);
			}
			else if(operators == "*")
			{
				result = firstnum * secondnum;
				answer = String.format("%.2f", result);
				label.setText("");
				txtfld.setText(answer);
			}
			else if(operators=="/")
			{
				result = firstnum / secondnum;
				answer = String.format("%.2f", result);
				label.setText("");
				txtfld.setText(answer);
			}
		}
		else if(e.getSource() == button[17])//backspace ActionListener
		{
			String bsp = null;
			if(txtfld.getText().length()>0)
			{
				StringBuilder strB = new StringBuilder(txtfld.getText());
				strB.deleteCharAt(txtfld.getText().length() -1);
				bsp = strB.toString();
				txtfld.setText(bsp);
			}
		}
		else if(e.getSource() == button[18])//clear ActionListener
		{
			label.setText("");
			txtfld.setText("");
		}
		else if(e.getSource() == button[19])//factorial ActionListener
		{
			int input = Integer.parseInt(txtfld.getText());
			int factorial=1;
			for(int i = 1; i <= input; i++)
				factorial *= i;
			label.setText(Integer.toString(factorial));
		}
		else if(e.getSource() == button[20])//binary ActionListener
		{
			int input = Integer.parseInt(txtfld.getText());
			label.setText(Integer.toBinaryString(input));
		}
		else if(e.getSource() == button[21])//octal ActionListener
		{
			int input = Integer.parseInt(txtfld.getText());
			label.setText(Integer.toOctalString(input));
		}
		else if(e.getSource() == button[22])//hexadecimal ActionListener
		{
			int input = Integer.parseInt(txtfld.getText());
			label.setText(Integer.toHexString(input));
		}
		else if(e.getSource() == button[23])//log ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("log (" +input+ ") =");
			input = Math.log(input);
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[24])//exponential ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("exp (" +input+ ") =");
			input = Math.exp(input);
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[25])//square root ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("sqrt (" +input+ ") =");
			input = Math.sqrt(input);
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[26])//square ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("square (" +input+ ") =");
			input *= input;
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[27])//cube ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("cube (" +input+ ") =");
			input *= input * input;
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[28])//power ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText(+input+ " th power of (" +input+ ") =");
			input = Math.pow(input, input);
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[29])//sin ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("sin (" +input+ ") =");
			input = Math.sin(Math.toRadians(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[30])//cos ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("cos (" +input+ ") =");
			input = Math.cos(Math.toRadians(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);;
		}
		else if(e.getSource() == button[31])//tan ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("tan (" +input+ ") =");
			input = Math.tan(Math.toRadians(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[32])//sin inverse ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("sin inverse (" +input+ ") =");
			input = Math.toDegrees(Math.asin(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[33])//cos inverse ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("cos inverse (" +input+ ") =");
			input = Math.toDegrees(Math.acos(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[34])//tan inverse ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("tan inverse (" +input+ ") =");
			input = Math.toDegrees(Math.atan(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[35])//sin hyperbolic ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("sinh (" +input+ ") =");
			input = Math.sinh(Math.toRadians(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[36])//cos hyperbolic ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("cosh (" +input+ ") =");
			input = Math.cosh(Math.toRadians(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
		else if(e.getSource() == button[37])//tan hyperbolic ActionListener
		{
			String answer;
			double input = Double.parseDouble(String.valueOf(txtfld.getText()));
			label.setText("tanh (" +input+ ") =");
			input = Math.tanh(Math.toRadians(input));
			answer = String.format("%.2f", input);
			txtfld.setText(answer);
		}
	}
	
	public static void main(String args[])
	{
 		Calculator cal = new Calculator();
		cal.setTitle("Calculator ST_G5");
		cal.setBounds(1070, 300, 250, 370);
		cal.setVisible(true);
		cal.setResizable(false);
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}