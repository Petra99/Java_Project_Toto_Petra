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
	private static JTextField txtFieldUserInput;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_1;
	private JLabel lblWinningNums_1;
	private JLabel lblIii_1;
	private JLabel label_equals_3;
	private JLabel lblNewLabel_2;
	static int[] arrRand_1;
	static int[] arrRand_2;
	static int[] arrRand_3;
	static int arrayLenght = 6;
	private JLabel label_equals_2;
	private JLabel label_equals_1;
	private JLabel lblWinningNums_2;
	private JLabel lblWinningNums_3;
	private JLabel label_4;
	private JLabel lblPrize_1;
	private JLabel lblPrize_2;
	private JLabel lblPrize_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

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

	private static void generateRandomNumsArrs() {
		arrRand_1 = new int[arrayLenght];
		getArrayWithRandomNums(arrRand_1);

		arrRand_2 = new int[arrayLenght];
		getArrayWithRandomNums(arrRand_2);

		arrRand_3 = new int[arrayLenght];
		getArrayWithRandomNums(arrRand_3);
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
		lblI.setBounds(65, 202, 70, 14);
		frame.getContentPane().add(lblI);

		JLabel lblIi = new JLabel("II \u043A\u0440\u044A\u0433 :");
		lblIi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIi.setBounds(65, 258, 70, 14);
		frame.getContentPane().add(lblIi);

		JLabel lblIii = new JLabel("III \u043A\u0440\u044A\u0433 :");
		lblIii.setHorizontalAlignment(SwingConstants.CENTER);
		lblIii.setBounds(65, 314, 70, 14);
		frame.getContentPane().add(lblIii);

		btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateRandomNumsArrs();

				String array1 = txtFieldUserInput.getText();
				String[] splittedStr1 = array1.split(" ");
				int[] userArrWithInts_1 = stringToInt(splittedStr1);

				int br1 = compare(userArrWithInts_1, arrRand_1);
				int br2 = compare(userArrWithInts_1, arrRand_2);
				int br3 = compare(userArrWithInts_1, arrRand_3);

				lblWinningNums_1.setText(intArrToString(arrRand_1));
				lblWinningNums_2.setText(intArrToString(arrRand_2));
				lblWinningNums_3.setText(intArrToString(arrRand_3));

				label_equals_1.setText(String.valueOf(br1));
				label_equals_2.setText(String.valueOf(br2));
				label_equals_3.setText(String.valueOf(br3));

				lblPrize_1.setText(String.valueOf(getPrize(br1)) + "ыт");
				lblPrize_2.setText(String.valueOf(getPrize(br2)) + "ыт");
				lblPrize_3.setText(String.valueOf(getPrize(br3)) + "ыт");
			}
		});
		
		btnStart.setBounds(172, 400, 89, 23);
		frame.getContentPane().add(btnStart);

		txtFieldUserInput = new JTextField();

		txtFieldUserInput.setBounds(65, 130, 300, 20);

		frame.getContentPane().add(txtFieldUserInput);
		txtFieldUserInput.setColumns(10);

		label_6 = new JLabel(
				"\u041C\u043E\u043B\u044F, \u0432\u044A\u0432\u0435\u0434\u0435\u0442\u0435 \u0432\u0430\u0448\u0438\u0442\u0435 6 \u043F\u0435\u0447\u0435\u043B\u0438\u0432\u0448\u0438 \u0447\u0438\u0441\u043B\u0430");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(24, 78, 400, 14);
		frame.getContentPane().add(label_6);

		label_1 = new JLabel("\u041F\u0435\u0447\u0435\u043B\u0438\u0432\u0448\u0438 \u0447\u0438\u0441\u043B\u0430 :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(117, 176, 150, 14);
		frame.getContentPane().add(label_1);

		lblIii_1 = new JLabel("III \u0442\u0435\u0433\u043B\u0435\u043D\u0435");
		lblIii_1.setBounds(10, 536, 100, 14);
		frame.getContentPane().add(lblIii_1);

		lblNewLabel_2 = new JLabel("\u041F\u0435\u0447\u0430\u043B\u0431\u0430:");
		lblNewLabel_2.setBounds(191, 455, 50, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblIi_1 = new JLabel("II \u0442\u0435\u0433\u043B\u0435\u043D\u0435");
		lblIi_1.setBounds(10, 511, 100, 14);
		frame.getContentPane().add(lblIi_1);

		JLabel lblI_1 = new JLabel("I \u0442\u0435\u0433\u043B\u0435\u043D\u0435");
		lblI_1.setBounds(10, 486, 100, 14);
		frame.getContentPane().add(lblI_1);

		label_equals_1 = new JLabel("-");
		label_equals_1.setBounds(117, 485, 20, 14);
		frame.getContentPane().add(label_equals_1);

		label_equals_2 = new JLabel("-");
		label_equals_2.setBounds(117, 511, 20, 14);
		frame.getContentPane().add(label_equals_2);

		label_equals_3 = new JLabel("-");
		label_equals_3.setBounds(117, 536, 20, 14);
		frame.getContentPane().add(label_equals_3);

		lblWinningNums_1 = new JLabel("-");
		lblWinningNums_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWinningNums_1.setBounds(165, 202, 200, 14);
		frame.getContentPane().add(lblWinningNums_1);

		lblWinningNums_2 = new JLabel("-");
		lblWinningNums_2.setBounds(165, 258, 200, 14);
		frame.getContentPane().add(lblWinningNums_2);

		lblWinningNums_3 = new JLabel("-");
		lblWinningNums_3.setBounds(165, 314, 200, 14);
		frame.getContentPane().add(lblWinningNums_3);

		label_4 = new JLabel("\u0411\u0440\u043E\u0439 \u0441\u044A\u0432\u043F\u0430\u0434\u0435\u043D\u0438\u044F");
		label_4.setBounds(10, 455, 100, 14);
		frame.getContentPane().add(label_4);

		lblPrize_1 = new JLabel("-");
		lblPrize_1.setBounds(191, 486, 150, 14);
		frame.getContentPane().add(lblPrize_1);

		lblPrize_2 = new JLabel("-");
		lblPrize_2.setBounds(191, 511, 150, 14);
		frame.getContentPane().add(lblPrize_2);

		lblPrize_3 = new JLabel("-");
		lblPrize_3.setBounds(191, 536, 150, 14);
		frame.getContentPane().add(lblPrize_3);

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

	private static int[] stringToInt(String[] userString) {
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

	private static double getPrize(int guessedNums) {
		double prize = 0;
		switch (guessedNums) {
		case 3:
			prize = 3.30;
			break;
		case 4:
			prize = 50.10;
			break;
		case 5:
			prize = 1500.00;
			break;
		case 6:
			prize = 1000000.00;
			break;
		default:
			prize = 0.00;
		}
		return prize;

	}
}
