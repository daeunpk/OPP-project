import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserStatusUI extends JFrame {
	public UserStatusUI() {
		setTitle("GOODBYE-OFFICE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 700);
		setLocationRelativeTo(null); // ����� ȭ�� �߾�
		
		// ���� �г� ����
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(250, 240, 230));
		mainPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 0);
		
		// ��Ʈ ����
		Font buttonFont = new Font("Malgun Gothic", Font.PLAIN, 13);
		Font labelFont = new Font("Malgun Gothic", Font.PLAIN, 16);
		Font titleFont = new Font("Malgun Gothic", Font.BOLD, 22);
		
		// ��� ������ ��ư �г� (����/Ȩ)
		JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		topButtonPanel.setBackground(mainPanel.getBackground());
		JButton settingButton = new JButton("����");
		JButton homeButton = new JButton("Ȩ");
		settingButton.setFont(buttonFont);
		homeButton.setFont(buttonFont);
		topButtonPanel.add(settingButton);
		topButtonPanel.add(homeButton);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		mainPanel.add(topButtonPanel, gbc);
		
		// 0. ����
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel titleLabel = new JLabel("���� �Ϸ�� �����?");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(new Color(0x4E4E4E));
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		mainPanel.add(titleLabel, gbc);
		
		// ���μ�
		gbc.gridy++;
		JPanel linePanel = new JPanel();
		linePanel.setBackground(new Color(0x4E4E4E));
		linePanel.setPreferredSize(new Dimension(600, 2));
		mainPanel.add(linePanel, gbc);
		gbc.gridwidth = 1;
		
		// 1. ���� ��� (���� ��ư)
		gbc.gridy++;
		JLabel moodLabel = new JLabel("������ ����� ��Ű���?");
		moodLabel.setFont(labelFont);
		mainPanel.add(moodLabel, gbc);
		
		gbc.gridy++;
		JPanel moodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		moodPanel.setBackground(mainPanel.getBackground());
		JRadioButton verygood = new JRadioButton("�ſ� ����");
		JRadioButton good = new JRadioButton("����");
		JRadioButton average = new JRadioButton("����");
		JRadioButton bad = new JRadioButton("����");
		verygood.setFont(buttonFont);	good.setFont(buttonFont);
		average.setFont(buttonFont);	bad.setFont(buttonFont);
		verygood.setBackground(mainPanel.getBackground());
		good.setBackground(mainPanel.getBackground());
		average.setBackground(mainPanel.getBackground());
		bad.setBackground(mainPanel.getBackground());
		ButtonGroup moodGroup = new ButtonGroup();
		moodGroup.add(verygood);	moodGroup.add(good);
		moodGroup.add(average);		moodGroup.add(bad);
		moodPanel.add(verygood);	moodPanel.add(good);
		moodPanel.add(average);		moodPanel.add(bad);
		mainPanel.add(moodPanel, gbc);
		
		// 2. ���� Ȱ�� (�����̴�)
		gbc.gridy++;
		JLabel energyLabel = new JLabel("���� ���� Ȱ���� ��� �����ΰ���?");
		energyLabel.setFont(labelFont);
		mainPanel.add(energyLabel, gbc);
		
		gbc.gridy++;
		JSlider energySlider = new JSlider(0, 2, 1);
		energySlider.setMajorTickSpacing(1);
		energySlider.setPaintTicks(true);
		energySlider.setPaintLabels(true);
		energySlider.setOpaque(false);
		Hashtable<Integer, JLabel> sliderLabels = new Hashtable<>();
		sliderLabels.put(0, new JLabel("�����"));
		sliderLabels.put(1, new JLabel("�����̿���"));
		sliderLabels.put(2, new JLabel("���ƿ�"));
		sliderLabels.forEach((k, v) -> v.setFont(buttonFont));
		energySlider.setLabelTable(sliderLabels);
		mainPanel.add(energySlider, gbc);
		
		// 3. ��� ������ ���� (���� ��ư)
		gbc.gridy++;
		JLabel socialLabel = new JLabel("��� �� ����� �Բ��ϰ� �����Ű���?");
		socialLabel.setFont(labelFont);
		mainPanel.add(socialLabel, gbc);
		
		gbc.gridy++;
		JPanel socialPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		socialPanel.setBackground(mainPanel.getBackground());
		JRadioButton alone = new JRadioButton("ȥ�� �ְ� �;��");
		JRadioButton withPeople = new JRadioButton("����� ������ �;��");
		alone.setFont(buttonFont);
		withPeople.setFont(buttonFont);
		alone.setBackground(mainPanel.getBackground());
		withPeople.setBackground(mainPanel.getBackground());
		ButtonGroup socialGroup = new ButtonGroup();
		socialGroup.add(alone);
		socialGroup.add(withPeople);
		socialPanel.add(alone);
		socialPanel.add(withPeople);
		mainPanel.add(socialPanel, gbc);
		
		// 4. ��� �ð� (���� ��ư + ��Ӵٿ�)
		gbc.gridy++;
		JLabel endTimeLabel = new JLabel("������ �ϰ��� �� �ÿ� ��������?");
		endTimeLabel.setFont(labelFont);
		mainPanel.add(endTimeLabel, gbc);
		
		gbc.gridy++;
		JPanel endTimeRadioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		endTimeRadioPanel.setBackground(mainPanel.getBackground());
		JRadioButton endTimeAuto = new JRadioButton("�ڵ� �����ҰԿ�");
		JRadioButton endTimeManual = new JRadioButton("���� �Է��ҰԿ�");
		endTimeAuto.setFont(buttonFont);
		endTimeManual.setFont(buttonFont);
		endTimeAuto.setBackground(mainPanel.getBackground());
		endTimeManual.setBackground(mainPanel.getBackground());
		ButtonGroup endTimeGroup = new ButtonGroup();
		endTimeGroup.add(endTimeAuto);
		endTimeGroup.add(endTimeManual);
		endTimeRadioPanel.add(endTimeAuto);
		endTimeRadioPanel.add(endTimeManual);
		mainPanel.add(endTimeRadioPanel, gbc);
		
		// 
		gbc.gridy++;
		JPanel timeInputPanel = new JPanel(new FlowLayout());
		timeInputPanel.setBackground(mainPanel.getBackground());
		
		String[] hours = new String[24];
		for (int i = 0; i < 24; i++) hours[i] = String.format("%02d��", i);
		JComboBox<String> hourBox = new JComboBox<>(hours);
		hourBox.setPreferredSize(new Dimension(80, 25));
		hourBox.setEnabled(false);
		
		String[] minutes = new String[12];
		for (int i = 0; i < 12; i++) minutes[i] = String.format("%02d��", i * 5);
		JComboBox<String> minuteBox = new JComboBox<>(minutes);
		minuteBox.setPreferredSize(new Dimension(80, 25));
		minuteBox.setEnabled(false);
		
		timeInputPanel.add(hourBox);
		timeInputPanel.add(minuteBox);
		mainPanel.add(timeInputPanel, gbc);

		// ���� ��ư�� ���� �޺��ڽ� Ȱ��ȭ
		endTimeAuto.addActionListener(e -> {
			hourBox.setEnabled(false);	minuteBox.setEnabled(false);
		});
		endTimeManual.addActionListener(e -> {
			hourBox.setEnabled(true);	minuteBox.setEnabled(true);
		});
		
		// �ϴ� ����
		gbc.gridy++;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		mainPanel.add(Box.createVerticalGlue(), gbc);
		
		// ���� �Ϸ� ��ư (�ϴ� ������)
		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		JButton submitButton = new JButton("���� �Ϸ�");
		submitButton.setFont(buttonFont);
		submitButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "�Է��� �Ϸ�Ǿ����ϴ�."));
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setBackground(mainPanel.getBackground());
		buttonPanel.add(submitButton);
		gbc.gridx = 1;
		mainPanel.add(buttonPanel, gbc);
		
		add(mainPanel);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UserStatusUI());
	}
}
