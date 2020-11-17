package numberpuzzle.boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import numberpuzzle.controller.MoveTileController;
import numberpuzzle.controller.ResetController;
import numberpuzzle.controller.SelectPieceController;
import numberpuzzle.model.Model;
import numberpuzzle.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class NumberPuzzleApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	
	Model model;
	
	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;
	JButton resetButton;
	JLabel actualNumberOfMoves;
	private JTextPane txtpnWelcomeToThe;
	
	public PuzzlePanel getPuzzlePanel() {
		return panel;
	}
	
	public JButton getUpButton() {
		return btnUp;
	}
	
	public JButton getDownButton() {
		return btnDown;
	}
	
	public JButton getLeftButton() {
		return btnLeft;
	}
	
	public JButton getRightButton() {
		return btnRight;
	}
	
	public JButton getResetButton() {
		return resetButton;
	}
	
	public JLabel getActualMovesLabel() {
		return actualNumberOfMoves;
	}


	/**
	 * Create the frame.
	 */
	public NumberPuzzleApp(Model m) {
		super();
		this.model = m;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(m);
		
		panel.addMouseListener( new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectPieceController(model, NumberPuzzleApp.this).processOne(me.getPoint());
			}
		});
		
		JLabel instructions = new JLabel("Instructions");
		instructions.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		
		actualNumberOfMoves = new JLabel("" + model.getNumMoves());
		actualNumberOfMoves.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel numberOfMovesLabel = new JLabel("Number Of Moves:");
		numberOfMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfMovesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, NumberPuzzleApp.this).reset();
			}
			
		});
		
		btnUp = new JButton("^");
		btnUp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).moveTile(MoveType.Up, model.getPuzzle());
			}
			
		});
		
		btnDown = new JButton("v");
		btnDown.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).moveTile(MoveType.Down, model.getPuzzle());
			}
			
		});
		
		btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).moveTile(MoveType.Left, model.getPuzzle());
			}
			
		});
		
		btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).moveTile(MoveType.Right, model.getPuzzle());
			}
			
		});
		
		txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setText("Welcome to the number puzzle game! \nUse the controls below to move selected tiles. Move right to add. Move left to subtract. Move up to multiply. Move down to divide. The aim is to only have the center tile remaining. Good Luck!");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(numberOfMovesLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(actualNumberOfMoves)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(txtpnWelcomeToThe, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(instructions)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(instructions, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtpnWelcomeToThe, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(actualNumberOfMoves)
										.addComponent(numberOfMovesLabel)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(resetButton)
										.addComponent(btnLeft)
										.addComponent(btnRight))))
							.addGap(4)
							.addComponent(btnDown))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnUp)
							.addGap(70))))
		);
		contentPane.setLayout(gl_contentPane);
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());
	}
}
