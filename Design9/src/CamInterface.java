import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

public class CamInterface {
	
	static JTextField durationText;
	static JTextField valveLiftText;
	static JTextField baseCircleText;
	static JTextField vMaxText;
	static JTextField vMinText;
	static JTextField aMaxText;
	static JTextField aMinText;
	static JTextField jMaxText;
	static JTextField jMinText;
	static JButton plotButton;
	static JButton saveButton;
	static JButton camProfileButton;
	static JButton displacementButton;
	static JButton velocityButton;
	static JButton accelerationButton;
	static JButton jerkButton;
	static JRadioButton halfCamRadio;
	static JRadioButton fullCamRadio;
	static JRadioButton allCamsRadio;
	static JRadioButton fullAllCamsRadio;
	static JComboBox<String> camTypeBox; 
	static JPanel displacementPanel;
	static JPanel velocityPanel;
	static JPanel accelerationPanel;
	static JPanel jerkPanel;
	static JPanel leftPanel;
	static JPanel rightPanel;
	static JFrame frame;
	
	
	CamInterface(){
		
		String camTypes[] = {" ", "Primative Cam", "Normal Cam", "Accurate Cam", "More Accurate Cam"};
		
		frame = new JFrame();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		displacementPanel = new JPanel();
		velocityPanel = new JPanel();
		accelerationPanel = new JPanel();
		jerkPanel = new JPanel();
		JLabel camTypeLable = new JLabel();
		JLabel durationLable = new JLabel();
		JLabel valveLiftLable = new JLabel();
		JLabel baseCircleLable = new JLabel();
		JLabel vMaxLable = new JLabel();
		JLabel vMinLable = new JLabel();
		JLabel aMaxLable = new JLabel();
		JLabel aMinLable = new JLabel();
		JLabel jMaxLable = new JLabel();
		JLabel jMinLable = new JLabel();
		//JTextField camTypeText = new JTextField();
		durationText = new JTextField();
		valveLiftText = new JTextField();
		baseCircleText = new JTextField();
		vMaxText = new JTextField();;
		vMinText = new JTextField();;
		aMaxText = new JTextField();;
		aMinText = new JTextField();;
		jMaxText = new JTextField();;
		jMinText = new JTextField();;
		plotButton = new JButton();
		saveButton = new JButton();
		camProfileButton = new JButton();
		displacementButton = new JButton();
		velocityButton = new JButton();
		accelerationButton = new JButton();
		jerkButton = new JButton();
		camTypeBox = new JComboBox<String>(camTypes);
		//BoxLayout boxLayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
		halfCamRadio = new JRadioButton("Half Cam");
		fullCamRadio = new JRadioButton("Full Cam");
		allCamsRadio = new JRadioButton("All Cams At Same Cam Lift and Half Duration");
		fullAllCamsRadio = new JRadioButton("All Cams At Same Cam Lift and Full Duration");
		ButtonGroup radioGroup = new ButtonGroup();
		
		
		
		// ###leftPanel
		leftPanel.setBounds(0, 0, 300, 720);
		leftPanel.setBackground(Color.gray);
		
		
		// ###rightPanel
		rightPanel.setBounds(300, 0, 980, 720);
		//rightPanel.setLayout(boxLayout);
		//rightPanel.setBackground(Color.lightGray);
		/*
		displacementPanel.setPreferredSize(new Dimension(980,170));
		velocityPanel.setPreferredSize(new Dimension(980,170));
		accelerationPanel.setPreferredSize(new Dimension(980,170));
		jerkPanel.setPreferredSize(new Dimension(980,170));
		
		
		rightPanel.add(displacementPanel);
		rightPanel.add(velocityPanel);
		rightPanel.add(accelerationPanel);
		rightPanel.add(jerkPanel);
		*/
		
		// ###
		
		// ###label
		camTypeLable.setText("Cam Type :");
		camTypeLable.setBounds(20, 20, 65, 15);
		durationLable.setText("Duration :");
		durationLable.setBounds(20, 80, 65, 15);
		valveLiftLable.setText("Cam Lift :");
		valveLiftLable.setBounds(20, 140, 65, 15);
		baseCircleLable.setText("Base Circle :");
		baseCircleLable.setBounds(20, 200, 75, 15);
		
		vMaxLable.setText("Max Velocity :");
		vMaxLable.setBounds(20, 340, 85, 15);
		vMinLable.setText("Min Velocity :");
		vMinLable.setBounds(150, 340, 85, 15);
		
		aMaxLable.setText("Max acceleration :");
		aMaxLable.setBounds(20, 390, 110, 15);
		aMinLable.setText("Max acceleration :");
		aMinLable.setBounds(150, 390, 110, 15);
		
		jMaxLable.setText("Max Jerk :");
		jMaxLable.setBounds(20, 440, 85, 15);
		jMinLable.setText("Min Jerk :");
		jMinLable.setBounds(150, 440, 85, 15);
		// ###
		
		// ###TextField
		//camTypeText.setBounds(20, 40, 150, 20);
		durationText.setBounds(20, 100, 150, 20);
		durationText.setText("0");
		valveLiftText.setBounds(20, 160, 150, 20);
		valveLiftText.setText("0");
		baseCircleText.setBounds(20, 220, 150, 20);
		baseCircleText.setText("0");
		
		vMaxText.setBounds(20, 360, 70, 20);
		vMinText.setBounds(150, 360, 70, 20);
		
		aMaxText.setBounds(20, 410, 70, 20);
		aMinText.setBounds(150, 410, 70, 20);
		
		jMaxText.setBounds(20, 460, 70, 20);
		jMinText.setBounds(150, 460, 70, 20);
		// ###
		
		// ###ComboBox
		camTypeBox.setBounds(20, 40, 150, 20);
		//
		
		// ##Button
		plotButton.setText("PLOT");
		plotButton.setBounds(220, 630, 70, 30);
		saveButton.setText("SAVE");
		saveButton.setBounds(30, 630, 70, 30);
		camProfileButton.setText("Cam Profile");
		camProfileButton.setBounds(110, 630, 100, 30);
		displacementButton.setText("Displacement");
		displacementButton.setBounds(10, 520, 120, 30);
		velocityButton.setText("Velocity");
		velocityButton.setBounds(150, 520, 120, 30);
		accelerationButton.setText("Acceleration");
		accelerationButton.setBounds(10, 560, 120, 30);
		jerkButton.setText("Jerk");
		jerkButton.setBounds(150, 560, 120, 30);
		// ###
		
		// ### RadioButton & Group
		halfCamRadio.setBounds(20,260, 100, 10);
		fullCamRadio.setBounds(140,260, 100, 10);
		allCamsRadio.setBounds(20, 280, 280, 10);
		fullAllCamsRadio.setBounds(20, 300, 280, 10);
		
		halfCamRadio.setBackground(Color.gray);
		fullCamRadio.setBackground(Color.gray);
		allCamsRadio.setBackground(Color.gray);
		fullAllCamsRadio.setBackground(Color.gray);
		
		halfCamRadio.setFocusable(false);
		fullCamRadio.setFocusable(false);
		allCamsRadio.setFocusable(false);
		fullAllCamsRadio.setFocusable(false);
		
		radioGroup.add(halfCamRadio);
		radioGroup.add(fullCamRadio);
		radioGroup.add(allCamsRadio);
		radioGroup.add(fullAllCamsRadio);
		
		// ###
		
		
		leftPanel.add(camTypeLable);
		leftPanel.add(durationLable);
		leftPanel.add(valveLiftLable);
		leftPanel.add(baseCircleLable);
		leftPanel.add(vMaxLable);
		leftPanel.add(vMinLable);
		leftPanel.add(aMaxLable);
		leftPanel.add(aMinLable);
		leftPanel.add(jMaxLable);
		leftPanel.add(jMinLable);
		leftPanel.add(camTypeBox);
		leftPanel.add(durationText);
		leftPanel.add(valveLiftText);
		leftPanel.add(baseCircleText);
		leftPanel.add(vMaxText);
		leftPanel.add(vMinText);
		leftPanel.add(aMaxText);
		leftPanel.add(aMinText);
		leftPanel.add(jMaxText);
		leftPanel.add(jMinText);
		leftPanel.add(plotButton);
		leftPanel.add(saveButton);
		leftPanel.add(camProfileButton);
		leftPanel.setLayout(null);
		leftPanel.add(displacementButton);
		leftPanel.add(velocityButton);
		leftPanel.add(accelerationButton);
		leftPanel.add(jerkButton);
		leftPanel.add(halfCamRadio);
		leftPanel.add(fullCamRadio);
		leftPanel.add(allCamsRadio);
		leftPanel.add(fullAllCamsRadio);
		rightPanel.setLayout(null);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cam");
		frame.setLayout(null);
		frame.setSize(1280, 720);
		frame.setVisible(true);
		
		frame.add(leftPanel);
		frame.add(rightPanel);
		frame.setLocationRelativeTo(null);
		//frame.pack();
		
		CamListener camListener = new CamListener();
		
		durationText.addActionListener(camListener);
		valveLiftText.addActionListener(camListener);
		baseCircleText.addActionListener(camListener);
		
		vMaxText.addActionListener(camListener);
		vMinText.addActionListener(camListener);
		aMaxText.addActionListener(camListener);
		aMinText.addActionListener(camListener);
		jMaxText.addActionListener(camListener);
		jMinText.addActionListener(camListener);
		
		saveButton.addActionListener(camListener);
		plotButton.addActionListener(camListener);
		camProfileButton.addActionListener(camListener);
		
		displacementButton.addActionListener(camListener);
		velocityButton.addActionListener(camListener);
		accelerationButton.addActionListener(camListener);
		jerkButton.addActionListener(camListener);
		
		camTypeBox.addActionListener(camListener);
		
		halfCamRadio.addActionListener(camListener);
		fullCamRadio.addActionListener(camListener);
		allCamsRadio.addActionListener(camListener);
		fullAllCamsRadio.addActionListener(camListener);
		
		
		
		}
	

}
