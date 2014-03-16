/**
 * @(#)Board.java
 *
 *
 * @Kelompok 3
 * @version 1.00 2014/3/9
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JApplet {
	private final JButton[] no = new JButton[100];
	private JLabel nick = new JLabel("P1");
	private JLabel nick2 = new JLabel("P2");
	private JButton t1 = new JButton("Roll Dice");
	private JButton t2 = new JButton("Roll Dice");
	private JTextField diceR = new JTextField("DICE ROLL RESULT : ");

	public Board() {
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		nick.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		nick.setForeground(Color.RED);
		p1.add(nick, BorderLayout.NORTH);
		p1.add(t1, BorderLayout.CENTER);
		t1.setEnabled(false);

		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		nick2.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		nick2.setForeground(Color.BLUE);
		p2.add(nick2, BorderLayout.NORTH);
		p2.add(t2, BorderLayout.CENTER);
		t2.setEnabled(false);

		diceR.setEditable(false);
		diceR.setHorizontalAlignment((int)CENTER_ALIGNMENT);

		add(p1, BorderLayout.WEST);
		add(new btns(), BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(diceR, BorderLayout.SOUTH);
	}

	class btns extends JPanel {
		public btns() {
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;

			int id = 99;
			for(int i=0; i<10; ++i){
				for(int j=0; j<10; ++j){
					no[id] = new JButton("" + (id + 1));
					no[id].addActionListener(new Listener());
					no[id].setEnabled(false);

					if(i%2==0) c.gridx = j;
					else c.gridx = 9-j;
					c.gridy = i;
					c.ipadx = 30;
					c.ipady = 30;

					add(no[id], c);
					--id;
				}
			}
		}
	}
	
	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<100; ++i)
				if(e.getSource()==no[i]){
					System.out.println("button : " + no[i].getText() + " clicked.");
					break;
				}
		}
	}

	public static void main (String[] args) {
		Board sl = new Board();
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(3);
		frame.setTitle("Snake Ladder");
		frame.getContentPane().add(sl, BorderLayout.CENTER);
		frame.setSize(1025, 640);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		//frame.pack();
		frame.setVisible(true);
		sl.init();
		sl.start();
	}
}
