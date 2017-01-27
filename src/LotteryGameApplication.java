import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Color;

public class LotteryGameApplication {

	private JFrame frame;
	private JButton startButton;
	private static JTextField txtFieldUserInput;
	private JLabel label_6;
	private JLabel label_1;
	private JLabel lblWinningNums_1;
	private JLabel lblIii_1;
	private JLabel lblEquals_3;
	private JLabel lblNewLabel_2;
	static int[] arrRand_1;
	static int[] arrRand_2;
	static int[] arrRand_3;
	static int arrayLenght = 6;
	private JLabel lblEquals_2;
	private JLabel lblEquals_1;
	private JLabel lblWinningNums_2;
	private JLabel lblWinningNums_3;
	private JLabel label_4;
	private JLabel lblPrize_1;
	private JLabel lblPrize_2;
	private JLabel lblPrize_3;
	private JLabel label;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LotteryGameApplication window = new LotteryGameApplication();
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

	public LotteryGameApplication() {
		initialize();
		run();
	}

	private void run() {
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generateArrsWithRandNums();

				// preparing the user input.
				String userTextInput = txtFieldUserInput.getText();
				String[] userSplittedTextToString = userTextInput.split(" ");
				int[] userNumbers = new int[userSplittedTextToString.length];
				userNumbers = testingAreThereNumbersOnly(userSplittedTextToString, userNumbers);
				int[] userSortedArray = bubbleSorting(userNumbers);
				testingAreThereEqualNums(userSortedArray);
				testingAreNumsFrom1To49(userSortedArray);

				// finding how many guessed numbers user has in each round.
				int guessedNumsRoundOne = compareArrays(userSortedArray, arrRand_1);
				int guessedNumsRoundTwo = compareArrays(userSortedArray, arrRand_2);
				int guessedNumsRoundThree = compareArrays(userSortedArray, arrRand_3);

				// printing the winning combinations for each round in labels.
				lblWinningNums_1.setText(intArrToString(arrRand_1));
				lblWinningNums_2.setText(intArrToString(arrRand_2));
				lblWinningNums_3.setText(intArrToString(arrRand_3));

				// printing how many guessed numbers user has in each round.
				lblEquals_1.setText(String.valueOf(guessedNumsRoundOne));
				lblEquals_2.setText(String.valueOf(guessedNumsRoundTwo));
				lblEquals_3.setText(String.valueOf(guessedNumsRoundThree));

				// printing the prize for each round.
				lblPrize_1.setText(String.valueOf(getPrize(guessedNumsRoundOne)) + "лв");
				lblPrize_2.setText(String.valueOf(getPrize(guessedNumsRoundTwo)) + "лв");
				lblPrize_3.setText(String.valueOf(getPrize(guessedNumsRoundThree)) + "лв");
			}

		});	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\shit\\Shamrock-PNG-Image.png"));
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel title = new JLabel("\u0422\u043E\u0442\u043E 6/49");
		title.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		title.setBounds(137, 11, 160, 47);
		frame.getContentPane().add(title);

		JLabel lblI = new JLabel("I \u0442\u0435\u0433\u043B\u0435\u043D\u0435 :");
		lblI.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		lblI.setVerticalAlignment(SwingConstants.TOP);
		lblI.setBounds(65, 250, 100, 20);
		frame.getContentPane().add(lblI);

		JLabel lblIi = new JLabel("II \u0442\u0435\u0433\u043B\u0435\u043D\u0435 :");
		lblIi.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblIi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIi.setBounds(65, 290, 100, 20);
		frame.getContentPane().add(lblIi);

		JLabel lblIii = new JLabel("III \u0442\u0435\u0433\u043B\u0435\u043D\u0435 :");
		lblIii.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblIii.setHorizontalAlignment(SwingConstants.CENTER);
		lblIii.setBounds(65, 330, 100, 20);
		frame.getContentPane().add(lblIii);

		startButton = new JButton("\u0421\u0422\u0410\u0420\u0422");
		startButton.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 18));
		startButton.setBackground(Color.WHITE);
		startButton.setForeground(new Color(0, 153, 0));
		
		startButton.setBounds(241, 171, 124, 30);
		frame.getContentPane().add(startButton);

		txtFieldUserInput = new JTextField("");

		txtFieldUserInput.setBounds(65, 123, 300, 23);

		frame.getContentPane().add(txtFieldUserInput);
		txtFieldUserInput.setColumns(10);

		label_6 = new JLabel(
				"\u041C\u043E\u043B\u044F, \u0432\u044A\u0432\u0435\u0434\u0435\u0442\u0435 \u0432\u0430\u0448\u0438\u0442\u0435 6 \u043F\u0435\u0447\u0435\u043B\u0438\u0432\u0448\u0438 \u0447\u0438\u0441\u043B\u0430,\r\n");
		label_6.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 69, 440, 20);
		frame.getContentPane().add(label_6);

		label_1 = new JLabel("\u041F\u0435\u0447\u0435\u043B\u0438\u0432\u0448\u0438 \u0447\u0438\u0441\u043B\u0430 :");
		label_1.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(92, 225, 250, 14);
		frame.getContentPane().add(label_1);

		lblIii_1 = new JLabel("III \u0442\u0435\u0433\u043B\u0435\u043D\u0435");
		lblIii_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblIii_1.setBounds(45, 500, 100, 14);
		frame.getContentPane().add(lblIii_1);

		lblNewLabel_2 = new JLabel("\u041F\u0435\u0447\u0430\u043B\u0431\u0430 :");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(245, 387, 150, 20);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblIi_1 = new JLabel("II \u0442\u0435\u0433\u043B\u0435\u043D\u0435");
		lblIi_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblIi_1.setBounds(45, 460, 100, 14);
		frame.getContentPane().add(lblIi_1);

		JLabel lblI_1 = new JLabel("I \u0442\u0435\u0433\u043B\u0435\u043D\u0435");
		lblI_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblI_1.setBounds(45, 420, 100, 14);
		frame.getContentPane().add(lblI_1);

		lblEquals_1 = new JLabel("-");
		lblEquals_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblEquals_1.setBounds(165, 420, 20, 20);
		frame.getContentPane().add(lblEquals_1);

		lblEquals_2 = new JLabel("-");
		lblEquals_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblEquals_2.setBounds(165, 465, 20, 14);
		frame.getContentPane().add(lblEquals_2);

		lblEquals_3 = new JLabel("-");
		lblEquals_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblEquals_3.setBounds(165, 502, 20, 14);
		frame.getContentPane().add(lblEquals_3);

		lblWinningNums_1 = new JLabel("-");
		lblWinningNums_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblWinningNums_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWinningNums_1.setBounds(165, 249, 200, 20);
		frame.getContentPane().add(lblWinningNums_1);

		lblWinningNums_2 = new JLabel("-");
		lblWinningNums_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblWinningNums_2.setBounds(165, 290, 200, 20);
		frame.getContentPane().add(lblWinningNums_2);

		lblWinningNums_3 = new JLabel("-");
		lblWinningNums_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblWinningNums_3.setBounds(165, 330, 200, 20);
		frame.getContentPane().add(lblWinningNums_3);

		label_4 = new JLabel(
				"\u0411\u0440\u043E\u0439 \u0441\u044A\u0432\u043F\u0430\u0434\u0435\u043D\u0438\u044F \u0437\u0430 :");
		label_4.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		label_4.setBounds(35, 387, 200, 20);
		frame.getContentPane().add(label_4);

		lblPrize_1 = new JLabel("-");
		lblPrize_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPrize_1.setBounds(245, 420, 150, 20);
		frame.getContentPane().add(lblPrize_1);

		lblPrize_2 = new JLabel("-");
		lblPrize_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPrize_2.setBounds(245, 460, 150, 20);
		frame.getContentPane().add(lblPrize_2);

		lblPrize_3 = new JLabel("-");
		lblPrize_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPrize_3.setBounds(245, 500, 150, 14);
		frame.getContentPane().add(lblPrize_3);

		JLabel lblNewLabel = new JLabel(
				"\u043E\u0442 1 \u0434\u043E 49, \u043E\u0442\u0434\u0435\u043B\u0435\u043D\u0438 \u0441 \u0438\u043D\u0442\u0435\u0440\u0432\u0430\u043B.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		lblNewLabel.setBounds(67, 90, 300, 20);
		frame.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(7, 212, 420, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 374, 420, 2);
		frame.getContentPane().add(separator_1);

		label = new JLabel("\u0421\u043F\u0435\u0447\u0435\u043B\u0438 1 000 000\u043B\u0432 !");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(31, 171, 200, 30);
		frame.getContentPane().add(label);

	}

	//*METHODS*
	
	private static void generateArrsWithRandNums() {
		// three random combinations for three rounds
		arrRand_1 = new int[arrayLenght];
		getArrayWithRandomNums(arrRand_1);

		arrRand_2 = new int[arrayLenght];
		getArrayWithRandomNums(arrRand_2);

		arrRand_3 = new int[arrayLenght];
		getArrayWithRandomNums(arrRand_3);
	}

	private String intArrToString(int[] randArray) {
		// to print the random combinations on labels
		StringBuilder randArrayToString = new StringBuilder();
		for (int randArrIndex = 0; randArrIndex < arrayLenght; randArrIndex++) {
			randArrayToString.append(String.valueOf(randArray[randArrIndex]) + " ");
		}
		return randArrayToString.toString();
	}

	private int[] testingAreThereNumbersOnly(String[] userSplittedTextToString, int[] userNumbers) {
		try {
			userNumbers = stringToInt(userSplittedTextToString);
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Въведете само числа.", "Грешно въведени данни",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return userNumbers;
	}

	private static void getArrayWithRandomNums(int[] arrayWithRandomNums) {
		Random rand = new Random();
		int maxTotoNumber = 49;
		for (int randNumCount = 0; randNumCount < arrayLenght; randNumCount++) {
			int randNum = rand.nextInt(maxTotoNumber) + 1;
			arrayWithRandomNums[randNumCount] = randNum;
			for (int arrayIndex = 0; arrayIndex < randNumCount; arrayIndex++) {
				if (arrayWithRandomNums[randNumCount] == arrayWithRandomNums[arrayIndex]) {
					randNumCount--; // one step back
					break; // repeat the generation
				}
			}
		}
	}

	private static int[] stringToInt(String[] userArrayString) {
		int[] userArrayWithInts = new int[arrayLenght];
		for (int i = 0; i < arrayLenght; i++) {
			try {
				userArrayWithInts[i] = Integer.parseInt(userArrayString[i]);
			} catch (ArrayIndexOutOfBoundsException exception) {
				JOptionPane.showMessageDialog(null, "Въведете точно 6 числа, отделени с интервал.",
						"Грешно въведени данни", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			;
		}
		return userArrayWithInts;
	}

	private void testingAreNumsFrom1To49(int[] userSortedArray) {
		for (int i = 0; i < arrayLenght; i++) {
			if (userSortedArray[i] < 1 || userSortedArray[i] > 50) {
				JOptionPane.showMessageDialog(null, "Въведете само числа от 1 до 49.", "Грешно въведени данни",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	private static int compareArrays(int[] userArray, int[] randArray) {
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
			JOptionPane.showMessageDialog(null, "ВИЕ СПЕЧЕЛИХТЕ ДЖАКПОТ ОТ 1 000 000ЛВ", "Поздравления",
					JOptionPane.PLAIN_MESSAGE);
			break;
		default:
			prize = 0.00;
		}
		return prize;

	}

	private void testingAreThereEqualNums(int[] userSortedArray) {
		for (int i = 1; i < userSortedArray.length - 1; i++) {
			if (userSortedArray[i - 1] == userSortedArray[i]) {
				JOptionPane.showMessageDialog(null, "Въведете числа, които не се повтарят.", "Грешно въведени данни",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}

	private static int[] bubbleSorting(int[] userInputArray) {
		int temp = 0;
		for (int i = 0; i < arrayLenght; i++) {
			for (int j = 1; j < (arrayLenght - i); j++) {
				if (userInputArray[j - 1] > userInputArray[j]) {
					// swap the elements
					temp = userInputArray[j - 1];
					userInputArray[j - 1] = userInputArray[j];
					userInputArray[j] = temp;
				}
			}
		}
		return userInputArray;
	}
}
