package Program.GraphicInterface;


import java.awt.EventQueue;
import Program.*;
import Program.Exceptions.ValueIncorrectException;
import Program.MoneyTypes.Coin;
import Program.MoneyTypes.Note;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.TextField;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ChooseMachine extends JFrame {
	private static final long serialVersionUID = 3142390317093997510L;
	
	public static ChooseMachine frame;
	
	private static JPanel ChooseMachinePane;
	private static JPanel PrintProductInformation;
	private static JPanel IntroduceAmountPane;
	private static JPanel buyOrLogInPanel;
	private static JPanel rechargeMoneyPanel;
	private static JPanel rechargeProductsPanel;
	private static JPanel ChooseRefillPanel;
	private static JPanel LogInPanel;
	
	private JPanel contentPane;
	private static VendingMachine currentVendingMachine;
	private static Product productToBuy;
	private static VendingMachine[] OperativeMachines;
	private JTextField TotalAmountText;
	private JTextField productsInformationText;
	
	private static JLabel lblQ005;
	private static JLabel lblQ02;
	private static JLabel lblQ05;
	private static JLabel lblQ1;
	private static JLabel lblQ2;
	private static JLabel lblQ5;
	private static JLabel lblQ10;
	private static JLabel lblQ20;
	private static JLabel lblQTotal;
	private static JComboBox cbCurrency;
	private static JComboBox cbProducts;
	private static String cbCurrencySelected;
	private static String cbProductsSelected;
	private static JLabel lblTotal;
	private static JLabel lblTquantity;
	private static JLabel lblP1quantity;
	private static JLabel lblP2quantity;
	private static JLabel lblP3quantity;
	private static JLabel lblP4quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		OperativeMachines = MainProgram.getEnabledMachines();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChooseMachine();
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
	public ChooseMachine() {
		
		
		//Creation of the panels and the general settings
		
		InitializationOfPanels();
		
		SetChooseMachineWindow();
		
		SetPrintProductInformation();
		
		SetIntroduceAmountPane();
		
		SetbuyOrLogInPanel();
		
		SetRechargeMoneyPanel();
		
		SetRechargeProductsPanel();		
		
		SetChooseRefillPanel();
		
		SetLogInPanel();
		
	}
	
	public void reloadPanels(int input) {
		
		InitializationOfPanels();
		SetChooseMachineWindow();
		SetPrintProductInformation();
		SetIntroduceAmountPane();
		SetbuyOrLogInPanel();
		SetRechargeMoneyPanel();
		SetRechargeProductsPanel();		
		SetChooseRefillPanel();
		SetLogInPanel();
		
		buyOrLogInPanel.setVisible(false);
		
		if(input == 1) {
			ChooseMachinePane.setVisible(true);

		}else if(input == 2) {
			PrintProductInformation.setVisible(true);

		}else if(input == 3) {
			IntroduceAmountPane.setVisible(true);

		}else if(input == 4) {
			rechargeMoneyPanel.setVisible(true);

		}else if(input == 5) {
			rechargeProductsPanel.setVisible(true);

		}else if(input == 6) {
			ChooseRefillPanel.setVisible(true);

		}else if(input == 7) {
			LogInPanel.setVisible(true);
		}else {
			buyOrLogInPanel.setVisible(true);
		}	
	}
	

	
	private static JTextPane textPane;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	//Method to initialice the content of choose machine window
	
	private void SetPrintProductInformation() {
				PrintProductInformation.setLayout(null);
		
				JLabel lblNewLabel_1 = new JLabel("Products information");
				lblNewLabel_1.setBounds(0, 0, 800, 35);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
				PrintProductInformation.add(lblNewLabel_1);
				
				JPanel MachineInformation = new JPanel();
				MachineInformation.setBounds(0, 35, 800, 426);
				PrintProductInformation.add(MachineInformation);
				MachineInformation.setLayout(null);
				
				textPane = new JTextPane();
				textPane.setBounds(101, 5, 629, 410);
				MachineInformation.add(textPane);
				
				
				JPanel ButtomsToMove = new JPanel();
				ButtomsToMove.setBounds(0, 461, 800, 33);
				PrintProductInformation.add(ButtomsToMove);
				
				JButton btnComeBackProductInfo = new JButton("Come back");
				btnComeBackProductInfo.setBounds(236, 5, 85, 23);
				btnComeBackProductInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ChooseMachinePane.setVisible(true);
						PrintProductInformation.setVisible(false);
						IntroduceAmountPane.setVisible(false);
						buyOrLogInPanel.setVisible(false);
						rechargeMoneyPanel.setVisible(false);
						rechargeProductsPanel.setVisible(false);
						ChooseRefillPanel.setVisible(false);
						LogInPanel.setVisible(false);
					}
				});
				ButtomsToMove.setLayout(null);
				ButtomsToMove.add(btnComeBackProductInfo);
				
				JLabel lblNewLabel_3 = new JLabel("Product number");
				lblNewLabel_3.setBounds(326, 9, 76, 14);
				ButtomsToMove.add(lblNewLabel_3);
				
				productsInformationText = new JTextField();
				productsInformationText.setBounds(407, 6, 86, 20);
				ButtomsToMove.add(productsInformationText);
				productsInformationText.setColumns(10);
				
				JButton btnNewButton_11 = new JButton("Accept");
				btnNewButton_11.setBounds(498, 5, 65, 23);
				btnNewButton_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//Si el producto existe en la maquina , se pasa a la siguiente ventana
						
						int productId= Integer.parseInt(productsInformationText.getText());
						productToBuy = currentVendingMachine.getSpecificProduct(productId);
						if(productToBuy != null) {
							ChooseMachinePane.setVisible(false);
							PrintProductInformation.setVisible(false);
							IntroduceAmountPane.setVisible(true);
							buyOrLogInPanel.setVisible(false);
							rechargeMoneyPanel.setVisible(false);
							rechargeProductsPanel.setVisible(false);
							ChooseRefillPanel.setVisible(false);
							LogInPanel.setVisible(false);
						}
					}
				});
				ButtomsToMove.add(btnNewButton_11);
		
	}
	
	//Method to initialice the content of choose machine window
	
	private void SetChooseMachineWindow() {
		ChooseMachinePane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Choose machine");
		lblNewLabel.setBounds(65, 5, 690, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		ChooseMachinePane.add(lblNewLabel);
		
		JPanel MachineOptions = new JPanel();
		MachineOptions.setBounds(233, 64, 342, 35);
		ChooseMachinePane.add(MachineOptions);
		
		
		
		
		JButton Machine1Button = new JButton("Machine 1");
		Machine1Button.setBounds(5, 5, 101, 23);
		Machine1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean logedIn = VendingMachineManager.checkIfSomeoneLogedIn();
				if(logedIn) {
					ChooseMachinePane.setVisible(false);
					PrintProductInformation.setVisible(false);
					IntroduceAmountPane.setVisible(false);
					buyOrLogInPanel.setVisible(false);
					rechargeMoneyPanel.setVisible(false);
					rechargeProductsPanel.setVisible(false);
					ChooseRefillPanel.setVisible(true);
					LogInPanel.setVisible(false);
					currentVendingMachine = OperativeMachines[0];
					System.out.println(currentVendingMachine);
					setLabelsForRefillMoney();
				}else {
					ChooseMachinePane.setVisible(false);
					PrintProductInformation.setVisible(true);
					IntroduceAmountPane.setVisible(false);
					buyOrLogInPanel.setVisible(false);
					rechargeMoneyPanel.setVisible(false);
					rechargeProductsPanel.setVisible(false);
					ChooseRefillPanel.setVisible(false);
					LogInPanel.setVisible(false);
					currentVendingMachine = OperativeMachines[0];
					textPane.setText(currentVendingMachine.toStringOnlyProducts());
					System.out.println(currentVendingMachine);
				}
			}
		});
		MachineOptions.setLayout(null);
		MachineOptions.add(Machine1Button);
		
		JButton Machine2Button = new JButton("Machine 2");
		Machine2Button.setBounds(116, 5, 103, 23);
		Machine2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean logedIn = VendingMachineManager.checkIfSomeoneLogedIn();
				if(logedIn) {
					ChooseMachinePane.setVisible(false);
					PrintProductInformation.setVisible(false);
					IntroduceAmountPane.setVisible(false);
					buyOrLogInPanel.setVisible(false);
					rechargeMoneyPanel.setVisible(false);
					rechargeProductsPanel.setVisible(false);
					ChooseRefillPanel.setVisible(true);
					LogInPanel.setVisible(false);
					currentVendingMachine = OperativeMachines[1];
					System.out.println(currentVendingMachine);
					setLabelsForRefillMoney();
					
				}else {
					ChooseMachinePane.setVisible(false);
					PrintProductInformation.setVisible(true);
					IntroduceAmountPane.setVisible(false);
					buyOrLogInPanel.setVisible(false);
					rechargeMoneyPanel.setVisible(false);
					rechargeProductsPanel.setVisible(false);
					ChooseRefillPanel.setVisible(false);
					LogInPanel.setVisible(false);
					currentVendingMachine = OperativeMachines[1];
					textPane.setText(currentVendingMachine.toStringOnlyProducts());
					System.out.println(currentVendingMachine);
				}
			}
		});
		MachineOptions.add(Machine2Button);
		
		JButton Machine3Button = new JButton("Machine 3");
		Machine3Button.setBounds(229, 5, 103, 23);
		Machine3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean logedIn = VendingMachineManager.checkIfSomeoneLogedIn();
				if(logedIn) {
					ChooseMachinePane.setVisible(false);
					PrintProductInformation.setVisible(false);
					IntroduceAmountPane.setVisible(false);
					buyOrLogInPanel.setVisible(false);
					rechargeMoneyPanel.setVisible(false);
					rechargeProductsPanel.setVisible(false);
					ChooseRefillPanel.setVisible(true);
					LogInPanel.setVisible(false);
					currentVendingMachine = OperativeMachines[2];
					System.out.println(currentVendingMachine);
					setLabelsForRefillMoney();
				}else {
					ChooseMachinePane.setVisible(false);
					PrintProductInformation.setVisible(true);
					IntroduceAmountPane.setVisible(false);
					buyOrLogInPanel.setVisible(false);
					rechargeMoneyPanel.setVisible(false);
					rechargeProductsPanel.setVisible(false);
					ChooseRefillPanel.setVisible(false);
					LogInPanel.setVisible(false);
					currentVendingMachine = OperativeMachines[2];
					textPane.setText(currentVendingMachine.toStringOnlyProducts());
					System.out.println(currentVendingMachine);
				}
			}
		});
		MachineOptions.add(Machine3Button);
		
		JButton btnComeBackRefill = new JButton("Come back");
		btnComeBackRefill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(true);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
			}
		});
		btnComeBackRefill.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnComeBackRefill.setBorder(null);
		btnComeBackRefill.setBackground(new Color(255, 51, 51));
		btnComeBackRefill.setBounds(21, 426, 87, 35);
		ChooseMachinePane.add(btnComeBackRefill);
	}
	
	//Method to initialice the content of introduce amount window
	
	private void SetIntroduceAmountPane() {
		IntroduceAmountPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Introduce amount");
		lblNewLabel_1_1.setBounds(0, 0, 790, 35);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		IntroduceAmountPane.add(lblNewLabel_1_1);
		
		JPanel Buttoms = new JPanel();
		Buttoms.setBounds(0, 35, 790, 416);
		IntroduceAmountPane.add(Buttoms);
		
		
		//Almacen de dinero para meter a las maquinas
		List<Money> moneyToIntroduce = new ArrayList<Money>();
		
		//----------------------------Botones de añadir dinero-----------------------------
		
		JButton btnNewButton = new JButton("0.05 Coin");
		btnNewButton.setBounds(67, 49, 79, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					SendMoneyToVendingMachine(new Coin(0.05f, 10) , moneyToIntroduce);
				} catch (ValueIncorrectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		});
		Buttoms.setLayout(null);
		Buttoms.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("0.2 Coin");
		btnNewButton_1.setBounds(67, 83, 73, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(0.2f, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("0.5 Coin");
		btnNewButton_2.setBounds(67, 117, 73, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(0.5f, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("1 Coin");
		btnNewButton_3.setBounds(67, 151, 63, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(1, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("2 Coin");
		btnNewButton_4.setBounds(67, 193, 63, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(2, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5 Note");
		btnNewButton_5.setBounds(67, 233, 65, 23);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Note(5, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("10 Note");
		btnNewButton_6.setBounds(67, 267, 71, 23);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Note(10, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("20 Note");
		btnNewButton_7.setBounds(67, 306, 71, 23);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Note(20, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_7);
		
		//--------------------------------------------------------
		
		JPanel Total = new JPanel();
		Total.setBounds(0, 451, 790, 33);
		IntroduceAmountPane.add(Total);
		Total.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnComeBackIntroduceAmount = new JButton("Come back");
		btnComeBackIntroduceAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(true);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
			}
		});
		Total.add(btnComeBackIntroduceAmount);
		
		JLabel lblNewLabel_2 = new JLabel("Total : ");
		Total.add(lblNewLabel_2);
		
		TotalAmountText = new JTextField();
		Total.add(TotalAmountText);
		TotalAmountText.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Accept");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double totalAmountIntroduced = Float.parseFloat(TotalAmountText.getText());
				
				if(totalAmountIntroduced >= productToBuy.getPrice()) {
					currentVendingMachine.addMoney(moneyToIntroduce);
					currentVendingMachine.removeProduct(productToBuy.getId());
				}
				
				
				
			}
		});
		Total.add(btnNewButton_9);
	}
	
	private void SendMoneyToVendingMachine(Money money, List<Money> moneyToIntroduce) throws ValueIncorrectException {
		
		moneyToIntroduce.add(money);
		TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
		
	}
	
	//Sets the initial information for the buyOrLogIn Panel
	private void SetbuyOrLogInPanel() {
		
		
		//Panle settings
		buyOrLogInPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		buyOrLogInPanel.setOpaque(true);
		buyOrLogInPanel.setLocation(new Point(1, 5));
		buyOrLogInPanel.setBackground(new Color(255, 255, 255));
		
		//Additional panel
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 141);
		titlePanel.setBackground(new Color(30, 144, 255));
		titlePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("VENIDING MACHINE\r\n");
		lblTitle.setBounds(151, 34, 485, 62);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 52));
		titlePanel.add(lblTitle);
		
		//Additional panel
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(200, 185, 337, 149);
		buyPanel.setBackground(new Color(255, 255, 255));
		buyPanel.setBorder(null);
		buyPanel.setForeground(new Color(255, 255, 255));
		
		JButton btnBuyMenu = new JButton("BUY NOW!");
		btnBuyMenu.setBounds(25, 5, 287, 75);
		btnBuyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(true);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
			}
		});
		buyPanel.setLayout(null);
		btnBuyMenu.setBorderPainted(false);
		btnBuyMenu.setBackground(new Color(153, 204, 102));
		btnBuyMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnBuyMenu.setAlignmentY(Component.TOP_ALIGNMENT);
		btnBuyMenu.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnBuyMenu.setFont(new Font("Roboto", Font.PLAIN, 61));
		buyPanel.add(btnBuyMenu);

		
		JLabel lblAdministrator = new JLabel("Log-In as an Administrator:\r\n");
		lblAdministrator.setBounds(35, 86, 144, 14);
		lblAdministrator.setFont(new Font("Roboto", Font.PLAIN, 11));
		buyPanel.add(lblAdministrator);
		
		
		JButton btnAdminMenu = new JButton("I'm an Administrator");
		btnAdminMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(true);
			}
		});
		btnAdminMenu.setBounds(184, 85, 128, 17);

		btnAdminMenu.setBackground(new Color(204, 255, 204));
		btnAdminMenu.setBorderPainted(false);
		btnAdminMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAdminMenu.setFont(new Font("Roboto", Font.PLAIN, 11));
		buyPanel.add(btnAdminMenu);

		buyOrLogInPanel.setLayout(null);
		buyOrLogInPanel.add(titlePanel);
		buyOrLogInPanel.add(buyPanel);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(10, 466, 128, 17);
		buyOrLogInPanel.add(btnLogOut);
		btnLogOut.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnLogOut.setBackground(new Color(255, 102, 102));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendingMachineManager.logOutAdminLogedIn();
				reloadPanels(0);
			}
		});

		
		JButton btnRefillMenu = new JButton("Refill");
		btnRefillMenu.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnRefillMenu.setBorderPainted(false);
		btnRefillMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRefillMenu.setBackground(new Color(153, 204, 102));
		btnRefillMenu.setAlignmentY(0.0f);
		btnRefillMenu.setAlignmentX(1.0f);
		btnRefillMenu.setBounds(668, 466, 122, 17);
		buyOrLogInPanel.add(btnRefillMenu);
		btnRefillMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(true);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
			}
		});
		
		JLabel lblWelcomeUser = new JLabel("");
		lblWelcomeUser.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblWelcomeUser.setBounds(200, 363, 337, 34);
		buyOrLogInPanel.add(lblWelcomeUser);
		
		//User LogedIn or not
		if(VendingMachineManager.checkIfSomeoneLogedIn()){
			lblWelcomeUser.setVisible(true);
			Administrator logedIn = VendingMachineManager.getAdministratorLogedIn(); 
			lblWelcomeUser.setText("Bienvenido " + logedIn.getName() + " "  + logedIn.getSurname() + "!");
			buyPanel.setVisible(false);
			btnLogOut.setVisible(true);
			btnRefillMenu.setVisible(true);
			btnBuyMenu.setVisible(false);
			lblAdministrator.setVisible(false);
			btnAdminMenu.setVisible(false);
		}else {
			lblWelcomeUser.setVisible(false);
			lblWelcomeUser.setText("");
			buyPanel.setVisible(true);
			btnLogOut.setVisible(false);
			btnRefillMenu.setVisible(false);
			btnBuyMenu.setVisible(true);
			lblAdministrator.setVisible(true);
			btnAdminMenu.setVisible(true);
		}
	}
	
	
	//Sets the initial information for the rechargeMoney Panel
	private void SetRechargeMoneyPanel() {
		
		//Estandar initial value
		cbCurrencySelected = "0,05€";
		
		rechargeMoneyPanel.setBackground(new Color(153, 204, 255));
		rechargeMoneyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		rechargeMoneyPanel.setLayout(null);
		
		JPanel contentRechargeMoneyPanel = new JPanel();
		contentRechargeMoneyPanel.setBackground(new Color(255, 255, 255));
		contentRechargeMoneyPanel.setBounds(0, 134, 783, 345);
		rechargeMoneyPanel.add(contentRechargeMoneyPanel);
		contentRechargeMoneyPanel.setLayout(null);
		
		JLabel lbl1 = new JLabel("1\u20AC");
		lbl1.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl1.setBounds(21, 147, 48, 14);
		contentRechargeMoneyPanel.add(lbl1);
		
		JLabel lbl2 = new JLabel("2\u20AC");
		lbl2.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl2.setBounds(21, 183, 84, 14);
		contentRechargeMoneyPanel.add(lbl2);
		
		JLabel lbl05 = new JLabel("0,5\u20AC");
		lbl05.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl05.setBounds(21, 112,113, 14);
		contentRechargeMoneyPanel.add(lbl05);
		
		JLabel lbl02 = new JLabel("0,2\u20AC");
		lbl02.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl02.setBounds(21, 78, 80, 14);
		contentRechargeMoneyPanel.add(lbl02);
		
		JLabel lbl005 = new JLabel("0,05\u20AC");
		lbl005.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl005.setBounds(21, 42, 34, 14);
		contentRechargeMoneyPanel.add(lbl005);
		
		JLabel lbl5 = new JLabel("5\u20AC");
		lbl5.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl5.setBounds(21, 220,221, 14);
		contentRechargeMoneyPanel.add(lbl5);
		
		JLabel lbl10 = new JLabel("10\u20AC");
		lbl10.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl10.setBounds(21, 263,48, 14);
		contentRechargeMoneyPanel.add(lbl10);
		
		JLabel lbl20 = new JLabel("20\u20AC");
		lbl20.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl20.setBounds(21, 304,48, 14);
		contentRechargeMoneyPanel.add(lbl20);
		
		JTextField tfMoney = new JTextField();
		tfMoney.setBounds(563, 112, 74, 18);
		contentRechargeMoneyPanel.add(tfMoney);
		tfMoney.setColumns(10);
		
		JButton btnAdditionMoney = new JButton("+");
		btnAdditionMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String text = tfMoney.getText();
				if(text != null) {
					try {
						final int textInt = Integer.parseInt(text);
						tfMoney.setText(String.valueOf(textInt + 1));
					}catch(NumberFormatException nfe) {
						System.out.println("Introduce un numero pls");
					}
				}
			}
		});
		btnAdditionMoney.setBorder(null);
		btnAdditionMoney.setBackground(new Color(255, 51, 51));
		btnAdditionMoney.setForeground(new Color(0, 0, 0));
		btnAdditionMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAdditionMoney.setBounds(659, 112, 39, 19);
		contentRechargeMoneyPanel.add(btnAdditionMoney);
		
		JButton btnReduceMoney = new JButton("-");
		btnReduceMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String text = tfMoney.getText();
				if(text != null) {
					try {
						final int textInt = Integer.parseInt(text);
						tfMoney.setText(String.valueOf(textInt - 1));
					}catch(NumberFormatException nfe) {
						System.out.println("Introduce un numero pls");
					}
				}
			}
		});
		btnReduceMoney.setForeground(Color.BLACK);
		btnReduceMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnReduceMoney.setBorder(null);
		btnReduceMoney.setBackground(new Color(0, 204, 255));
		btnReduceMoney.setBounds(514, 112, 39, 19);
		contentRechargeMoneyPanel.add(btnReduceMoney);
		
		JLabel lblSelectCurrency = new JLabel("Select the currency:");
		lblSelectCurrency.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblSelectCurrency.setBounds(248, 112, 112, 14);
		contentRechargeMoneyPanel.add(lblSelectCurrency);
		
		lblQ005 = new JLabel("0");
		lblQ005.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ005.setBounds(89, 43, 34, 14);
		contentRechargeMoneyPanel.add(lblQ005);
		
		lblQ02 = new JLabel("0");
		lblQ02.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ02.setBounds(89, 79, 80, 14);
		contentRechargeMoneyPanel.add(lblQ02);
		
		lblQ05 = new JLabel("0");
		lblQ05.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ05.setBounds(89, 113, 34, 14);
		contentRechargeMoneyPanel.add(lblQ05);
		
		lblQ1 = new JLabel("0");
		lblQ1.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ1.setBounds(89, 148, 34, 14);
		contentRechargeMoneyPanel.add(lblQ1);
		
		lblQ2 = new JLabel("0");
		lblQ2.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ2.setBounds(89, 184, 34, 14);
		contentRechargeMoneyPanel.add(lblQ2);
		
		lblQ5 = new JLabel("0");
		lblQ5.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ5.setBounds(89, 221, 34, 14);
		contentRechargeMoneyPanel.add(lblQ5);
		
		lblQ10 = new JLabel("0");
		lblQ10.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ10.setBounds(89, 263, 52, 14);
		contentRechargeMoneyPanel.add(lblQ10);
		
		lblQ20 = new JLabel("0");
		lblQ20.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ20.setBounds(89, 304,285, 14);
		contentRechargeMoneyPanel.add(lblQ20);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblCurrency.setBounds(10, 11, 51, 14);
		contentRechargeMoneyPanel.add(lblCurrency);
		
		JLabel lblMoneyQuantity = new JLabel("Quantity");
		lblMoneyQuantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblMoneyQuantity.setBounds(82, 12, 51, 14);
		contentRechargeMoneyPanel.add(lblMoneyQuantity);
		
		if(currentVendingMachine != null) {																						//Mirar
			JLabel lblMachineMoney = new JLabel("Machine ");
			lblMachineMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
			lblMachineMoney.setBounds(706, 11, 67, 14);
			contentRechargeMoneyPanel.add(lblMachineMoney);
			lblMachineMoney.setText("Machine " + currentVendingMachine.getMachineNumber());
		}
		
		cbCurrency = new JComboBox();
		cbCurrency.addItemListener(event -> {
            // The item affected by the event.
            String item = (String) event.getItem();
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	cbCurrencySelected = item;
            }
        });
		cbCurrency.setFont(new Font("Roboto", Font.PLAIN, 11));
		cbCurrency.addItemListener(event -> {
            String item = (String) event.getItem();
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	cbCurrencySelected = item;
            }
        });
		cbCurrency.setModel(new DefaultComboBoxModel(new String[] {"0,05\u20AC", "0,2\u20AC", "0,5\u20AC", "1\u20AC", "2\u20AC", "5\u20AC", "10\u20AC", "20\u20AC"}));
		cbCurrency.setBounds(370, 112, 134, 19);
		contentRechargeMoneyPanel.add(cbCurrency);
		
		JButton btnAddMoney = new JButton("Add\r\n");
		btnAddMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final String text = tfMoney.getText();
				if(text != null) {
					try {
						final int textInt = Integer.parseInt(text);
						int selectedItem = cbCurrency.getSelectedIndex();
						if(textInt > 0) {
							currentVendingMachine.IntroduceMoney(getFloatFromComboxMoney(cbCurrencySelected), textInt, currentVendingMachine.getMoney());
							setLabelsForRefillMoney();
						}else {
							currentVendingMachine.RemoveMoney(getFloatFromComboxMoney(cbCurrencySelected), textInt, currentVendingMachine.getMoney());
							setLabelsForRefillMoney();
						}
						
					}catch(NumberFormatException nfe) {
						System.out.println("Introduce un numero pls");
					}
				}
				
			}
		});
		btnAddMoney.setBorder(null);
		btnAddMoney.setBackground(new Color(153, 255, 153));
		btnAddMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAddMoney.setBounds(708, 109, 65, 23);
		contentRechargeMoneyPanel.add(btnAddMoney);
		
		JLabel lbl = new JLabel("\u20AC");
		lbl.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl.setBounds(639, 113, 17, 14);
		contentRechargeMoneyPanel.add(lbl);
		
		JButton btnComeBackMoney = new JButton("Come back");
		btnComeBackMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(true);
				LogInPanel.setVisible(false);
			}
		});
		btnComeBackMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnComeBackMoney.setBorder(null);
		btnComeBackMoney.setBackground(new Color(255, 51, 51));
		btnComeBackMoney.setBounds(577, 299, 87, 35);
		contentRechargeMoneyPanel.add(btnComeBackMoney);
		
		JButton btnFinishMoney = new JButton("Finish\r\n");
		btnFinishMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(true);
				LogInPanel.setVisible(false);
			}
		});
		btnFinishMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnFinishMoney.setBorder(null);
		btnFinishMoney.setBackground(new Color(51, 204, 0));
		btnFinishMoney.setBounds(686, 299, 87, 35);
		contentRechargeMoneyPanel.add(btnFinishMoney);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblTotal.setBounds(21, 331, 48, 14);
		contentRechargeMoneyPanel.add(lblTotal);
		
		lblQTotal = new JLabel("0");
		lblQTotal.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQTotal.setBounds(89, 331, 52, 14);
		contentRechargeMoneyPanel.add(lblQTotal);
		
		JPanel titleRechargeMoneyPanel = new JPanel();
		titleRechargeMoneyPanel.setLayout(null);
		titleRechargeMoneyPanel.setBackground(new Color(153, 204, 255));
		titleRechargeMoneyPanel.setBounds(0, 0, 783, 134);
		rechargeMoneyPanel.add(titleRechargeMoneyPanel);
		
		JLabel lblNewLabel_1 = new JLabel("RECHARGE MONEY");
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(114, -11, 539, 157);
		titleRechargeMoneyPanel.add(lblNewLabel_1);
	}
	
	//Sets the initial information for the rechargeProducts Panel
	private void SetRechargeProductsPanel() {
		
		cbProductsSelected = "Cookies";
		
		rechargeProductsPanel.setLayout(null);
		rechargeProductsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		rechargeProductsPanel.setBackground(new Color(153, 204, 255));
		
		
		JPanel contentRechargeMoneyPanel_1 = new JPanel();
		contentRechargeMoneyPanel_1.setLayout(null);
		contentRechargeMoneyPanel_1.setBackground(Color.WHITE);
		contentRechargeMoneyPanel_1.setBounds(0, 134, 783, 345);
		rechargeProductsPanel.add(contentRechargeMoneyPanel_1);
		
		JLabel lblP4 = new JLabel("Snack");
		lblP4.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP4.setBounds(10, 148, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP4);
		
		JLabel lblP3 = new JLabel("Drink");
		lblP3.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP3.setBounds(10, 113, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP3);
		
		JLabel lblP2 = new JLabel("Chocolate");
		lblP2.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP2.setBounds(10, 79, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP2);
		
		JLabel lblP1 = new JLabel("Cookies");
		lblP1.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP1.setBounds(10, 43, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP1);
		
		JTextField tfProdcuts = new JTextField();
		tfProdcuts.setColumns(10);
		tfProdcuts.setBounds(563, 112, 74, 18);
		contentRechargeMoneyPanel_1.add(tfProdcuts);
		
		JButton btnAdditionP = new JButton("+");
		btnAdditionP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String text = tfProdcuts.getText();
				if(text != null) {
					try {
						final int textInt = Integer.parseInt(text);
						tfProdcuts.setText(String.valueOf(textInt + 1));
					}catch(NumberFormatException nfe) {
						System.out.println("Introduce un numero pls");
					}
				}
			}
		});
		btnAdditionP.setForeground(Color.BLACK);
		btnAdditionP.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAdditionP.setBorder(null);
		btnAdditionP.setBackground(new Color(255, 51, 51));
		btnAdditionP.setBounds(647, 111, 39, 19);
		contentRechargeMoneyPanel_1.add(btnAdditionP);
		
		JButton btnReduceP = new JButton("-");
		btnReduceP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String text = tfProdcuts.getText();
				if(text != null) {
					try {
						final int textInt = Integer.parseInt(text);
						tfProdcuts.setText(String.valueOf(textInt - 1));
					}catch(NumberFormatException nfe) {
						System.out.println("Introduce un numero pls");
					}
				}
			}
		});
		btnReduceP.setForeground(Color.BLACK);
		btnReduceP.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnReduceP.setBorder(null);
		btnReduceP.setBackground(new Color(0, 204, 255));
		btnReduceP.setBounds(514, 112, 39, 19);
		contentRechargeMoneyPanel_1.add(btnReduceP);
		
		JLabel lblSelectProduct = new JLabel("Select the prodcut:");
		lblSelectProduct.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblSelectProduct.setBounds(248, 112, 112, 14);
		contentRechargeMoneyPanel_1.add(lblSelectProduct);
		
		lblP1quantity = new JLabel("0");
		lblP1quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP1quantity.setBounds(89, 43, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP1quantity);
		
		lblP2quantity = new JLabel("0");
		lblP2quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP2quantity.setBounds(89, 79, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP2quantity);
		
		lblP3quantity = new JLabel("0");
		lblP3quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP3quantity.setBounds(89, 113, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP3quantity);
		
		lblP4quantity = new JLabel("0");
		lblP4quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP4quantity.setBounds(89, 148, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP4quantity);
		
		JLabel lblTypesProdcuts = new JLabel("Product");
		lblTypesProdcuts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblTypesProdcuts.setBounds(10, 11, 51, 14);
		contentRechargeMoneyPanel_1.add(lblTypesProdcuts);
		
		JLabel lblQuantityProdcuts = new JLabel("Quantity");
		lblQuantityProdcuts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQuantityProdcuts.setBounds(82, 12, 51, 14);
		contentRechargeMoneyPanel_1.add(lblQuantityProdcuts);
		
		if(currentVendingMachine != null) {
			JLabel lblMachineP = new JLabel("Machine ");
			lblMachineP.setFont(new Font("Roboto Black", Font.PLAIN, 12));
			lblMachineP.setBounds(706, 11, 67, 14);
			contentRechargeMoneyPanel_1.add(lblMachineP);
			lblMachineP.setText("Machine " + currentVendingMachine.getMachineNumber());
		}
		
		cbProducts = new JComboBox();
		cbProducts.setModel(new DefaultComboBoxModel(new String[] {"Cookies", "Chocolate", "Drink", "Snack"}));
		cbProducts.setBounds(370, 112, 134, 19);
		cbCurrency.addItemListener(event -> {
            // The item affected by the event.
            String item = (String) event.getItem();
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	cbProductsSelected = item;
            }
        });
		contentRechargeMoneyPanel_1.add(cbProducts);
		
		JButton btnAddProduts = new JButton("Add\r\n");
		btnAddProduts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final String text = tfProdcuts.getText();
				if(text != null) {
					try {
						final int textInt = Integer.parseInt(text);
						if(textInt > 0) {
							currentVendingMachine.addProduct(getIndexFromComboxProdcuts(cbProductsSelected), textInt);
							setLabelsForRefillProducts();
						}else {
							currentVendingMachine.removeProduct(getIndexFromComboxProdcuts(cbProductsSelected), textInt);
							setLabelsForRefillProducts();
						}
						
					}catch(NumberFormatException nfe) {
						System.out.println("Introduce un numero pls");
					}
				}
				
			}
		});
		btnAddProduts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAddProduts.setBorder(null);
		btnAddProduts.setBackground(new Color(153, 255, 153));
		btnAddProduts.setBounds(708, 109, 65, 23);
		contentRechargeMoneyPanel_1.add(btnAddProduts);
		
		JButton btnFinishProducts = new JButton("Finish\r\n");
		btnFinishProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(true);
				LogInPanel.setVisible(false);
			}
		});
		btnFinishProducts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnFinishProducts.setBorder(null);
		btnFinishProducts.setBackground(new Color(51, 204, 0));
		btnFinishProducts.setBounds(686, 299, 87, 35);
		contentRechargeMoneyPanel_1.add(btnFinishProducts);
		
		JButton btnComeBackProducts = new JButton("Come back");
		btnComeBackProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(true);
				LogInPanel.setVisible(false);
			}
		});
		btnComeBackProducts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnComeBackProducts.setBorder(null);
		btnComeBackProducts.setBackground(new Color(255, 51, 51));
		btnComeBackProducts.setBounds(576, 299, 87, 35);
		contentRechargeMoneyPanel_1.add(btnComeBackProducts);
		
		lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblTotal.setBounds(10, 186, 58, 14);
		contentRechargeMoneyPanel_1.add(lblTotal);
		
		lblTquantity = new JLabel("0");
		lblTquantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblTquantity.setBounds(89, 187, 34, 14);
		contentRechargeMoneyPanel_1.add(lblTquantity);
		
		JPanel titleRechargeMoneyPanel_1 = new JPanel();
		titleRechargeMoneyPanel_1.setLayout(null);
		titleRechargeMoneyPanel_1.setBackground(new Color(153, 204, 255));
		titleRechargeMoneyPanel_1.setBounds(0, 0, 783, 134);
		rechargeProductsPanel.add(titleRechargeMoneyPanel_1);
		
		JLabel lblTitleRechargeProdcuts = new JLabel("RECHARGE PRODUCTS");
		lblTitleRechargeProdcuts.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblTitleRechargeProdcuts.setBounds(57, -11, 658, 157);
		titleRechargeMoneyPanel_1.add(lblTitleRechargeProdcuts);
	}
	
	
	private void SetChooseRefillPanel() {
		ChooseRefillPanel.setLayout(null);
		
		JLabel lblRefill = new JLabel("Choose what you would like to refill");
		lblRefill.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefill.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblRefill.setBounds(10, 5, 780, 35);
		ChooseRefillPanel.add(lblRefill);
		
		JPanel RefillOptions = new JPanel();
		RefillOptions.setLayout(null);
		RefillOptions.setBounds(271, 64, 263, 35);
		ChooseRefillPanel.add(RefillOptions);
		
		JButton btnMoney = new JButton("Money\r\n");
		btnMoney.setBounds(5, 5, 81, 23);
		RefillOptions.add(btnMoney);
		
		btnMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(true);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
				SetRechargeMoneyPanel();
			}
		});
		
		JButton btnProducts = new JButton("Products\r\n");
		btnProducts.setBounds(172, 5, 81, 23);
		RefillOptions.add(btnProducts);
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(true);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
				SetRechargeProductsPanel();
			}
		});
		
		JButton btnComeBackRefill = new JButton("Come back");
		btnComeBackRefill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(true);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
			}
		});
		btnComeBackRefill.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnComeBackRefill.setBorder(null);
		btnComeBackRefill.setBackground(new Color(255, 51, 51));
		btnComeBackRefill.setBounds(10, 448, 87, 35);
		ChooseRefillPanel.add(btnComeBackRefill);
	}
	
	private void SetLogInPanel() {
		
		LogInPanel.setLayout(null);
		LogInPanel.setBackground(Color.WHITE);
		
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(0, 153, 255));
		titlePanel.setBounds(0, 0, 800, 95);
		LogInPanel.add(titlePanel);
		
		JLabel lblTitle = new JLabel("ADMIN LOG-IN\r\n");
		lblTitle.setFont(new Font("Roboto Black", Font.BOLD, 40));
		lblTitle.setBounds(249, 24, 287, 48);
		titlePanel.add(lblTitle);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBorder(null);
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBounds(0, 76, 800, 407);
		LogInPanel.add(loginPanel);
		
			
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(157, 145, 267, 23);
		loginPanel.add(tfUsername);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblUsername.setBounds(61, 148, 60, 15);
		loginPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblPassword.setBounds(61, 198, 58, 15);
		loginPanel.add(lblPassword);
		
		JLabel lblErrorLogIn = new JLabel("");
		lblErrorLogIn.setForeground(new Color(204, 0, 0));
		lblErrorLogIn.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		lblErrorLogIn.setBounds(61, 246, 595, 33);
		loginPanel.add(lblErrorLogIn);
		
		JButton btnLogIn = new JButton("Log-In\r\n");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorLogIn.setText(VendingMachineManager.LogIn(tfUsername.getText(), tfPassword.getPassword()));
				if(VendingMachineManager.checkIfSomeoneLogedIn()) {
					reloadPanels(0);
				}else {

				}
			}
		});
		btnLogIn.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnLogIn.setBorder(null);
		btnLogIn.setBackground(new Color(153, 255, 153));
		btnLogIn.setBounds(569, 139, 86, 33);
		loginPanel.add(btnLogIn);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(157, 195, 267, 23);
		loginPanel.add(tfPassword);
		
		JButton btnComeBackLogIn = new JButton("Come back");
		btnComeBackLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(false);
				IntroduceAmountPane.setVisible(false);
				buyOrLogInPanel.setVisible(true);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				ChooseRefillPanel.setVisible(false);
				LogInPanel.setVisible(false);
			}
		});
		btnComeBackLogIn.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnComeBackLogIn.setBorder(null);
		btnComeBackLogIn.setBackground(new Color(255, 51, 51));
		btnComeBackLogIn.setBounds(569, 183, 87, 35);
		loginPanel.add(btnComeBackLogIn);
	}
	
	//Method to initialice all the panels and set their settings
	
	
	private void setLabelsForRefillMoney() {
		lblQ005.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 0.05f)));
		lblQ02.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 0.2f)));
		lblQ05.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 0.5f)));
		lblQ1.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 1)));
		lblQ2.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 2)));
		lblQ5.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 5)));
		lblQ10.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 10)));
		lblQ20.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificCuerrencyType(currentVendingMachine.getMoney(), 20)));
		lblQTotal.setText(String.valueOf(currentVendingMachine.getTotalMoneyInMachine(currentVendingMachine.getMoney())) + " €");
	}
	
	private void setLabelsForRefillProducts() {

		lblP1quantity.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificProduct(1)));
		lblP2quantity.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificProduct(2)));
		lblP3quantity.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificProduct(3)));
		lblP4quantity.setText(String.valueOf(currentVendingMachine.getQuantityOfSpecificProduct(4)));
		lblTquantity.setText(String.valueOf(currentVendingMachine.getTotalAmountProducts()));
	}
	
	private float getFloatFromComboxMoney(String text) {
		
		if(text.equals("0,05€")) {
			return 0.05f;
		}else if(text.equals("0,2€")) {
			return 0.2f;
		}else if(text.equals("0,5€")) {
			return 0.5f;
		}else if(text.equals("1€")) {
			return 1;
		}else if(text.equals("2€")) {
			return 2;
		}else if(text.equals("5€")) {
			return 5;
		}else if(text.equals("10€")) {
			return 10;
		}else if(text.equals("20€")) {
			return 20;
		}else {
			return -999999;
		}
	}
	
	private int getIndexFromComboxProdcuts(String text) {
		
		if(text.equals("Cookies")) {
			return 1;
		}else if(text.equals("Chocolate")) {
			return 2;
		}else if(text.equals("Drink")) {
			return 3;
		}else if(text.equals("Snack")) {
			return 4;
		}else {
			return -999999;
		}
	}
	
	private void InitializationOfPanels() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 533);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//PANEL CREATION
		
		//ChooseMachinePanel
		
		ChooseMachinePane = new JPanel();
		contentPane.add(ChooseMachinePane, "name_2929736530442100");
		
		//PrintProductsPanel
		
		PrintProductInformation = new JPanel();
		contentPane.add(PrintProductInformation, "name_2929736579834000");
		
		//IntroduceAmountPane
		
		IntroduceAmountPane = new JPanel();
		contentPane.add(IntroduceAmountPane, "name_2929736620635600");
		
		//buyOrLoginPanel
		buyOrLogInPanel = new JPanel();
		contentPane.add(buyOrLogInPanel, "name_9769166799700");
		
		//rechargeMoneyPanel
		rechargeMoneyPanel = new JPanel();
		contentPane.add(rechargeMoneyPanel, "name_9907318158100");
		
		//rechargeProductsPanel
		rechargeProductsPanel = new JPanel();
		contentPane.add(rechargeProductsPanel, "name_54518782135900");
		
		//ChooseRefillPanel
		ChooseRefillPanel = new JPanel();
		contentPane.add(ChooseRefillPanel, "name_103733792689700");	
		
		//LogInPanel
		LogInPanel = new JPanel();
		contentPane.add(LogInPanel, "name_110877025816500");
		
		//Visibility of the Panels
		ChooseMachinePane.setVisible(false);
		PrintProductInformation.setVisible(false);
		IntroduceAmountPane.setVisible(false);
		buyOrLogInPanel.setVisible(true);
		rechargeMoneyPanel.setVisible(false);
		rechargeProductsPanel.setVisible(false);
		ChooseRefillPanel.setVisible(false);
		LogInPanel.setVisible(false);
	}
}