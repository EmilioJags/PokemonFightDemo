import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Pokimans {

	private JFrame frame;
	public PokimanBattle fr;
	private Random randy = new Random();
	private String[] availPokemons = { "Bulbasaur", "Charmander", "Squirtle" };
	private int idEnemy;
	boolean noSamePokemon = false;
	int idMyPkmn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokimans window = new Pokimans();
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
	public Pokimans() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 383, 232);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Select your pokiman");
		lblNewLabel.setBounds(10, 10, 177, 43);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Bulbasaur");
		try {
			Image img = ImageIO.read(getClass().getResource("resources/bulba120.png"));
			btnNewButton.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("click");
				idMyPkmn = 0;
				if(!noSamePokemon)
					while (true) {
						idEnemy = randy.nextInt(0, 3);
						if (idEnemy != idMyPkmn)
							break;
					}
				else 
					idEnemy = randy.nextInt(0, 3);
				try {
					fr = new PokimanBattle(new Pokemon(0, btnNewButton.getText()),
							new Pokemon(idEnemy, availPokemons[idEnemy]));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fr.setVisible(true);
				fr.setChosen(0);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 62, 111, 124);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Charmander");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idMyPkmn = 1;
				if(!noSamePokemon)
					while (true) {
						idEnemy = randy.nextInt(0, 3);
						if (idEnemy != idMyPkmn)
							break;
					}
				else 
					idEnemy = randy.nextInt(0, 3);
				try {
					fr = new PokimanBattle(new Pokemon(1, btnNewButton_1.getText()),
							new Pokemon(idEnemy, availPokemons[idEnemy]));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fr.setVisible(true);
				fr.setChosen(1);
				frame.setVisible(false);
			}
		});
		try {
			Image img = ImageIO.read(getClass().getResource("resources/char120.png"));
			btnNewButton_1.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnNewButton_1.setBounds(131, 62, 110, 124);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Squirtle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idMyPkmn = 2;
				if(!noSamePokemon)
					while (true) {
						idEnemy = randy.nextInt(0, 3);
						if (idEnemy != idMyPkmn)
							break;
					}
				else  
					idEnemy = randy.nextInt(0, 3);
				try {
					fr = new PokimanBattle(new Pokemon(2, btnNewButton_2.getText()),
							new Pokemon(idEnemy, availPokemons[idEnemy]));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fr.setVisible(true);
				fr.setChosen(2);
				frame.setVisible(false);
			}
		});
		try {

			Image img = ImageIO.read(getClass().getResource("resources/squirt120.png"));
			btnNewButton_2.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println("error---" + ex);
		}
		btnNewButton_2.setBounds(251, 62, 111, 124);
		frame.getContentPane().add(btnNewButton_2);

		JCheckBox samePkmnBox = new JCheckBox("Allow Same Pokemon");
		samePkmnBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				noSamePokemon = samePkmnBox.isSelected();
			}
		});
		samePkmnBox.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		samePkmnBox.setBounds(193, 21, 169, 21);
		frame.getContentPane().add(samePkmnBox);
	}

	 
}
