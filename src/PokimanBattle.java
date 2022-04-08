import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PokimanBattle extends JFrame {

	private JPanel contentPane;
	private int chosenPokemon = 0;
	private Pokemon myPokemon;
	private Pokemon enemyPokemon;
	private Random randy = new Random();
	private JLabel myHpLabel;
	private JLabel enemyHpLabel;
	private JProgressBar myHpBar, enemyHpBar;
	private JTextArea battleLogLabel;
	private boolean gameOver = false;
	private JButton moveOne, moveTwo, moveThree, moveFour;
	private JButton mypoke_button, enemypoke_button;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PokimanBattle frame = new
	 * PokimanBattle(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public PokimanBattle(Pokemon myPoke, Pokemon enemyPoke) throws InterruptedException {
		this.myPokemon = myPoke;
		this.enemyPokemon = enemyPoke;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("GO BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokimans pkmnInit = new Pokimans();
				pkmnInit.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(481, 316, 108, 40);
		contentPane.add(btnNewButton_1);

		  mypoke_button = new JButton("New button");
		try {

			Image img = ImageIO.read(getClass().getResource("resources/squirt120.png"));
			mypoke_button.setIcon(new ImageIcon(this.myPokemon.getImg()));
		} catch (Exception ex) {
			System.out.println("error---" + ex);
		}
		mypoke_button.setBounds(10, 72, 118, 124);
		contentPane.add(mypoke_button);

		  enemypoke_button = new JButton("New button");
		try {

			enemypoke_button.setIcon(new ImageIcon(this.enemyPokemon.getImg()));
		} catch (Exception ex) {
			System.out.println("error---" + ex);
		}
		enemypoke_button.setBounds(471, 72, 118, 124);
		contentPane.add(enemypoke_button);

		  moveOne = new JButton("New button");
		moveOne.setText(this.myPokemon.getMoveSet().getMoveMap().get(0).getName());
		moveOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					battleLogLabel.setText("");
					attackUsing(0, myPokemon, enemyPokemon); 
					if(!gameOver)
						attackUsing(randy.nextInt(0,4), enemyPokemon, myPokemon);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		moveOne.setBounds(10, 232, 118, 53);
		contentPane.add(moveOne);

		  moveTwo = new JButton("New button");
		moveTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					battleLogLabel.setText("");
					attackUsing(1, myPokemon, enemyPokemon); 
					if(!gameOver)
						attackUsing(randy.nextInt(0,4), enemyPokemon, myPokemon);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		moveTwo.setText(this.myPokemon.getMoveSet().getMoveMap().get(1).getName());
		moveTwo.setBounds(152, 232, 118, 53);
		contentPane.add(moveTwo);

		  moveThree = new JButton("New button");
		moveThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					battleLogLabel.setText("");
					attackUsing(2, myPokemon, enemyPokemon); 
					if(!gameOver)
						attackUsing(randy.nextInt(0,4), enemyPokemon, myPokemon);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		moveThree.setText(this.myPokemon.getMoveSet().getMoveMap().get(2).getName());
		moveThree.setBounds(10, 303, 118, 53);
		contentPane.add(moveThree);

		  moveFour = new JButton("New button");
		moveFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					battleLogLabel.setText("");
					attackUsing(3, myPokemon, enemyPokemon); 
					if(!gameOver)
						attackUsing(randy.nextInt(0,4), enemyPokemon, myPokemon);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		moveFour.setText(this.myPokemon.getMoveSet().getMoveMap().get(3).getName());
		moveFour.setBounds(152, 303, 118, 53);
		contentPane.add(moveFour);

		myHpBar = new JProgressBar();
		myHpBar.setMaximum(this.myPokemon.getMaxHp());
		myHpBar.setValue(this.myPokemon.getCurrentHp());
		myHpBar.setBounds(10, 45, 153, 17);
		contentPane.add(myHpBar);

		enemyHpBar = new JProgressBar();
		enemyHpBar.setMaximum(this.enemyPokemon.getMaxHp());
		enemyHpBar.setValue(this.enemyPokemon.getCurrentHp());
		enemyHpBar.setBounds(436, 45, 153, 17);
		contentPane.add(enemyHpBar);

		myHpLabel = new JLabel("HP:");
		myHpLabel.setText("HP: " + this.myPokemon.getCurrentHp());
		myHpLabel.setBounds(10, 24, 153, 17);
		contentPane.add(myHpLabel);

		enemyHpLabel = new JLabel("HP:");
		enemyHpLabel.setText("HP: " + this.enemyPokemon.getCurrentHp());
		enemyHpLabel.setBounds(436, 26, 153, 17);
		contentPane.add(enemyHpLabel);

		JLabel lblNewLabel_1 = new JLabel("Battle Log");
		lblNewLabel_1.setBounds(205, 10, 183, 13);
		contentPane.add(lblNewLabel_1);
		
		 battleLogLabel = new JTextArea();
		battleLogLabel.setEditable(false);
		battleLogLabel.setColumns(20);
		battleLogLabel.setBounds(205, 52, 183, 144);
		contentPane.add(battleLogLabel);
		//System.out.println(this.myPokemon.toString() + "\n\n");
		//System.out.println(this.enemyPokemon.toString());
	}

	public void attackUsing(int moveId, Pokemon attacker, Pokemon defender) throws InterruptedException {
		battleLogLabel.setText(battleLogLabel.getText() + "\n" + attacker.getName() + " uses " + attacker.getMoveSet().getMoveMap().get(moveId).getName() + ".");
		int attackValue;
		if(attacker.getMoveSet().getMoveMap().get(moveId).getDamage() == 0)
			attackValue = 0;
		else
			attackValue = randy.nextInt(1,attacker.getAttack());
		battleLogLabel.setText( 
				battleLogLabel.getText() + "\n" + defender.getName() + " loses " + attackValue + " hitpoints.");
		defender.setCurrentHp(defender.getCurrentHp() - attackValue);
		updateValues(); 
	}

	public void updateValues() {
		myHpLabel.setText("HP: " + this.myPokemon.getCurrentHp());
		myHpBar.setValue(this.myPokemon.getCurrentHp());
		enemyHpLabel.setText("HP: " + this.enemyPokemon.getCurrentHp());
		enemyHpBar.setValue(this.enemyPokemon.getCurrentHp());
		checkWin();
	}
	
	public void checkWin()
	{
		if(myPokemon.getCurrentHp() <= 0) { 
			myHpLabel.setText("HP: " + 0);
			myHpBar.setValue(0);  
			mypoke_button.setIcon(new ImageIcon(myPokemon.getDeadImg()));
	        battleLogLabel.setText(battleLogLabel.getText() + "\n" + enemyPokemon.getName() + " WINS!");
	        gameOver = true;
	        disableButtons();
		}
		if(enemyPokemon.getCurrentHp() <= 0) {  
			enemyHpLabel.setText("HP: " + 0);
			enemyHpBar.setValue(0);  
			enemypoke_button.setIcon(new ImageIcon(enemyPokemon.getDeadImg()));
	        battleLogLabel.setText(battleLogLabel.getText() + "\n" + myPokemon.getName() + " WINS!"); 
	        gameOver = true; 
	        disableButtons();
		}
	}
	public void disableButtons()
	{
		moveOne.setEnabled(false);
		moveTwo.setEnabled(false);
		moveThree.setEnabled(false);
		moveFour.setEnabled(false);
	}
	public void setChosen(int choice) {
		this.chosenPokemon = choice;
		// System.out.print(chosenPokemon);
	}
}
