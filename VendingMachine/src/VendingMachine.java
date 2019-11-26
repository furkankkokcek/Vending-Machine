import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VendingMachine {

	private JFrame frame;
	private JTextField InsertTF;// Money or coin can be inserted(writed) to this text field.

	private JTextField textField;// These two text field represent container of beverage.
	private JTextField textField_1;

	private double balance = 0;// Current balance of user which will be used in buying processes.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendingMachine window = new VendingMachine();
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
	public VendingMachine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		// General frame of vending machine and some features.
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 450, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Initialization of global variable InsertTF.
		InsertTF = new JTextField();
		InsertTF.setBounds(53, 174, 116, 27);
		frame.getContentPane().add(InsertTF);
		InsertTF.setColumns(10);

		// User dialog window of vending machine.
		JLabel MessageLbl = new JLabel("");
		MessageLbl.setFont(new Font("Unispace", Font.PLAIN, 12));
		MessageLbl.setForeground(new Color(102, 255, 204));
		MessageLbl.setBounds(63, 245, 231, 16);
		frame.getContentPane().add(MessageLbl);

		// User balance window of vending machine.
		JLabel BalanceLbl = new JLabel("Balance: 0.0 TL");
		BalanceLbl.setFont(new Font("Unispace", Font.PLAIN, 12));
		BalanceLbl.setBackground(SystemColor.activeCaptionBorder);
		BalanceLbl.setForeground(new Color(102, 255, 204));
		BalanceLbl.setBounds(63, 214, 136, 16);
		frame.getContentPane().add(BalanceLbl);

		// A simple label showing only where the money will be inserted.
		JLabel lblInsertCoinHere = new JLabel("Insert Coin Here:");
		lblInsertCoinHere.setFont(new Font("Unispace", Font.PLAIN, 12));
		lblInsertCoinHere.setForeground(new Color(204, 255, 102));
		lblInsertCoinHere.setBackground(new Color(255, 255, 255));
		lblInsertCoinHere.setBounds(53, 158, 146, 16);
		frame.getContentPane().add(lblInsertCoinHere);

		JButton btnInsert = new JButton("+");// Insert button adds money to current balance.
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!InsertTF.getText().isEmpty()) {

					double insertedCoin = 0.0;
					insertedCoin = Double.parseDouble(InsertTF.getText());
					// Designated coins only for insertion.
					if (insertedCoin == 0.5 || insertedCoin == 1.0 || insertedCoin == 5.0 || insertedCoin == 10.0) {
						balance += insertedCoin;
						BalanceLbl.setText("Balance: " + balance + " TL");
						MessageLbl.setText("You inserted " + insertedCoin + " TL");
						// Show messages about action and current balance.

					}
					InsertTF.setText("");
				}

			}
		});
		btnInsert.setBackground(Color.LIGHT_GRAY);
		btnInsert.setForeground(new Color(102, 153, 0));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsert.setBounds(181, 173, 45, 27);
		frame.getContentPane().add(btnInsert);

		// Coke represented with a simple JButton :)
		JButton CokeBtn = new JButton(new ImageIcon(VendingMachine.class.getResource("/Icons/coke.png")));
		CokeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// After buying a coke, the price is deducted from the balance.
				if (balance >= 15) {
					balance -= 15;
					BalanceLbl.setText("Balance: " + balance + " TL");
					MessageLbl.setText("Your coke is ready!");
					// Show messages about action and current balance.
					if (balance == 0) {
						// If user balance is zero after the buying, vending machine will terminated.
						System.exit(1);
					}

				}

				else {
					MessageLbl.setText("Insufficient balance for coke!");

				}
			}
		});

		CokeBtn.setBounds(306, 158, 45, 72);
		frame.getContentPane().add(CokeBtn);

		// Fanta represented with a simple JButton :)
		JButton FantaBtn = new JButton(new ImageIcon(VendingMachine.class.getResource("/Icons/fanta.png")));
		FantaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// After buying a fanta, the price is deducted from the balance.
				if (balance >= 20) {
					balance -= 20;
					BalanceLbl.setText("Balance: " + balance + " TL");
					MessageLbl.setText("Your fanta is ready!");
					// Show messages about action and current balance.
					if (balance == 0) {
						// If user balance is zero after the buying, vending machine will terminated.
						System.exit(1);
					}

				} else {
					MessageLbl.setText("Insufficient balance for fanta!");

				}
			}
		});
		FantaBtn.setBounds(306, 252, 45, 72);
		frame.getContentPane().add(FantaBtn);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(70, 465, 309, 64);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		// Sprite represented with a simple JButton :)
		JButton SodaBtn = new JButton(new ImageIcon(VendingMachine.class.getResource("/Icons/sprite.png")));
		SodaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// After buying a sprite, the price is deducted from the balance.
				if (balance >= 25) {
					balance -= 25;
					BalanceLbl.setText("Balance: " + balance + " TL");
					MessageLbl.setText("Your sprite is ready!");
					// Show messages about action and current balance.
					if (balance == 0) {
						System.exit(1);
						// If user balance is zero after the buying, vending machine will terminated.
					}

				} else {
					MessageLbl.setText("Insufficient balance for sprite!");

				}
			}
		});
		SodaBtn.setBounds(306, 350, 45, 72);
		frame.getContentPane().add(SodaBtn);

		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(12, 440, 420, 113);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblVendingMachine = new JLabel("Beverage");
		lblVendingMachine.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendingMachine.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 37));
		lblVendingMachine.setForeground(new Color(255, 255, 153));
		lblVendingMachine.setBounds(12, 13, 408, 64);
		frame.getContentPane().add(lblVendingMachine);

		// List of valid coins for this vending machine.
		JLabel lblOnlyCents = new JLabel(
				"<html>Only 0.5 TL, 1 TL, 5 TL, 10 TL<br/> will  be accepted as money.</html>");
		lblOnlyCents.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlyCents.setVerticalAlignment(SwingConstants.TOP);
		lblOnlyCents.setForeground(new Color(255, 99, 71));
		lblOnlyCents.setFont(new Font("Unispace", Font.PLAIN, 9));
		lblOnlyCents.setBounds(193, 90, 239, 27);
		frame.getContentPane().add(lblOnlyCents);

		// The user may suddenly request a refund of the balance.
		JButton btnRefund = new JButton("Refund");
		btnRefund.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnRefund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// AFter refund, user balance is reset.
				balance = 0.0;
				BalanceLbl.setText("Balance: " + balance + " TL");
				MessageLbl.setText("Your money is being returned!");
				// Show messages about action and current balance.

			}
		});
		btnRefund.setBounds(73, 274, 80, 25);
		frame.getContentPane().add(btnRefund);

		// These three labels only shows the current price of beverages.
		JLabel lblTl = new JLabel("15 TL");
		lblTl.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblTl.setForeground(new Color(255, 255, 51));
		lblTl.setBounds(363, 179, 56, 16);
		frame.getContentPane().add(lblTl);

		JLabel lblTl_1 = new JLabel("20 TL");
		lblTl_1.setForeground(new Color(255, 255, 51));
		lblTl_1.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblTl_1.setBounds(363, 277, 56, 16);
		frame.getContentPane().add(lblTl_1);

		JLabel lblTl_2 = new JLabel("25 TL");
		lblTl_2.setForeground(new Color(255, 255, 51));
		lblTl_2.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblTl_2.setBounds(363, 378, 56, 16);
		frame.getContentPane().add(lblTl_2);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 12));
		lblNewLabel.setBounds(53, 129, 173, 16);
		lblNewLabel.setForeground(new Color(204, 255, 102));
		frame.getContentPane().add(lblNewLabel);
	}
}