import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TotoInterface2 {

	private JFrame frame;
	private JButton btnStart;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_1;
	private JLabel lblWinningNums;
	private JLabel label_2;
	private JLabel label_equals_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	static int[] arrRand;
	static int arrayLenght = 6;
	private JLabel label_equals_2;
	private JLabel label_equals_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		arrRand = new int[arrayLenght];
		getArrayWithRandomNums(arrRand);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotoInterface2 window = new TotoInterface2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TotoInterface2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u0422\u043E\u0442\u043E 6/49");
		label.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		label.setBounds(137, 0, 160, 47);
		frame.getContentPane().add(label);

		JLabel lblI = new JLabel("I \u043A\u0440\u044A\u0433 :");
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		lblI.setVerticalAlignment(SwingConstants.TOP);
		lblI.setBounds(182, 100, 70, 14);
		frame.getContentPane().add(lblI);

		JLabel lblIi = new JLabel("II \u043A\u0440\u044A\u0433 :");
		lblIi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIi.setBounds(182, 200, 70, 14);
		frame.getContentPane().add(lblIi);

		JLabel lblIii = new JLabel("III \u043A\u0440\u044A\u0433 :");
		lblIii.setHorizontalAlignment(SwingConstants.CENTER);
		lblIii.setBounds(182, 300, 70, 14);
		frame.getContentPane().add(lblIii);

		btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String array1 = textField_1.getText();
			String[] splittedStr1 = array1.split(" ");
			int[] userArrWithInts_1 = stringToInt(splittedStr1);
			int br1 = compare(userArrWithInts_1,arrRand);
			
			String array2 = textField_2.getText();
			String[] splittedStr2 = array2.split(" ");
			int[] userArrWithInts_2 = stringToInt(splittedStr2);
			int br2 = compare(userArrWithInts_2,arrRand);
			
			String array3 = textField_3.getText();
			String[] splittedStr3 = array3.split(" ");
			int[] userArrWithInts_3 = stringToInt(splittedStr3);
			int br3 = compare(userArrWithInts_3,arrRand);
			
			lblWinningNums.setText(intArrToString(arrRand));
			
			label_equals_1.setText(String.valueOf(br1));
			
			label_equals_2.setText(String.valueOf(br2));
			
			label_equals_3.setText(String.valueOf(br3));
			
			//printPrize();
			}

		});
		btnStart.setBounds(172, 400, 89, 23);
		frame.getContentPane().add(btnStart);

		textField_1 = new JTextField("12 22 31 23 34 26");

		textField_1.setBounds(65, 130, 300, 20);

		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField("12 22 31 23 34 26");
		textField_2.setColumns(10);
		textField_2.setBounds(65, 230, 300, 20);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField("12 22 31 23 34 26");
		textField_3.setColumns(10);
		textField_3.setBounds(65, 330, 300, 20);
		frame.getContentPane().add(textField_3);
		
		label_4 = new JLabel();
		label_4.setBounds(304, 90, 46, 14);
		frame.getContentPane().add(label_4);
		
		label_6 = new JLabel("\u041C\u043E\u043B\u044F, \u0432\u044A\u0432\u0435\u0434\u0435\u0442\u0435 \u0432\u0430\u0448\u0438\u0442\u0435 6 \u043F\u0435\u0447\u0435\u043B\u0438\u0432\u0448\u0438 \u0447\u0438\u0441\u043B\u0430 \u0437\u0430 \u0432\u0441\u0435\u043A\u0438 \u043E\u0442 \u0442\u0440\u0438\u0442\u0435 \u043A\u0440\u044A\u0433\u0430");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(24, 78, 400, 14);
		frame.getContentPane().add(label_6);
		
		label_1 = new JLabel("\u041F\u0435\u0447\u0435\u043B\u0438\u0432\u0448\u0438 \u0447\u0438\u0441\u043B\u0430 :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(142, 430, 150, 14);
		frame.getContentPane().add(label_1);
		
		lblWinningNums = new JLabel();
		lblWinningNums.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinningNums.setBounds(117, 460, 200, 14);
		frame.getContentPane().add(lblWinningNums);
		
		label_2 = new JLabel("\u0411\u0440\u043E\u0439 \u0441\u044A\u0432\u043F\u0430\u0434\u0435\u043D\u0438\u044F");
		label_2.setBounds(10, 536, 100, 14);
		frame.getContentPane().add(label_2);
		
		lblNewLabel_2 = new JLabel("\u041F\u0435\u0447\u0430\u043B\u0431\u0430:");
		lblNewLabel_2.setBounds(215, 536, 50, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("1 000 000");
		lblNewLabel_3.setBounds(275, 536, 60, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\u043B\u0432");
		lblNewLabel_4.setBounds(345, 536, 20, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel("\u0411\u0440\u043E\u0439 \u0441\u044A\u0432\u043F\u0430\u0434\u0435\u043D\u0438\u044F");
		label_3.setBounds(10, 511, 100, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_7 = new JLabel("\u0411\u0440\u043E\u0439 \u0441\u044A\u0432\u043F\u0430\u0434\u0435\u043D\u0438\u044F");
		label_7.setBounds(10, 486, 100, 14);
		frame.getContentPane().add(label_7);
		
		label_equals_1 = new JLabel("-");
		label_equals_1.setBounds(117, 485, 20, 14);
		frame.getContentPane().add(label_equals_1);
		
		label_equals_2 = new JLabel("-");
		label_equals_2.setBounds(117, 511, 20, 14);
		frame.getContentPane().add(label_equals_2);
		
		label_equals_3 = new JLabel("-");
		label_equals_3.setBounds(117, 536, 20, 14);
		frame.getContentPane().add(label_equals_3);
		
		
		
	
	}

	private String intArrToString(int[] arrRand2) {
		int arrayL = 6;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arrayL; i++) {
		        sb.append(String.valueOf(arrRand2[i]) + " ");

		}
		return sb.toString();
	}

	private static void getArrayWithRandomNums(int[] arrNoDuplicates) {
		Random rand = new Random();
		int maxTotoNumber = 49;
		for (int randNumCount = 0; randNumCount < arrNoDuplicates.length; randNumCount++) {
			int randNum = rand.nextInt(maxTotoNumber) + 1;
			arrNoDuplicates[randNumCount] = randNum;
			for (int arrayIndex = 0; arrayIndex < randNumCount; arrayIndex++) {
				if (arrNoDuplicates[randNumCount] == arrNoDuplicates[arrayIndex]) {
					randNumCount--; // one step back
					break; // repeat the generation
				}
			}
		}
	}
	 
	private static int[] stringToInt(String[] userString ){
		int[] userArrayWithInts = new int[arrayLenght];

		for (int i = 0; i < arrayLenght; i++) {
		   // try {
		        userArrayWithInts[i] = Integer.parseInt(userString[i]);
		   // } catch (NumberFormatException nfe) {
		        
		   // };
		}
		return userArrayWithInts;

}
	private static int compare(int[] userArray, int[] randArray) {
		int coincidence = 0;
		for (int userNumsIndex = 0; userNumsIndex < userArray.length; userNumsIndex++) {
			for (int randNumsIndex = 0; randNumsIndex < userArray.length; randNumsIndex++) {
				if (userArray[userNumsIndex] == randArray[randNumsIndex])
					coincidence++;
			}
		}
		return coincidence;
		
		
	}
	

	private static double printPrize(int guessedNums) {
		double prize = 0;
		switch(guessedNums){
		case 3: prize = 100;break;
		case 4: prize = 700;break;
		case 5: prize = 1500;break;
		case 6: prize = 1000000;break;
		default: prize =0.00;
		}
		return prize;
		
		
	}
}
