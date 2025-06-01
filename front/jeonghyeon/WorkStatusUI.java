import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkStatusUI extends JFrame {
	public WorkStatusUI() {
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
		JLabel titleLabel = new JLabel("��� �ð��� ������ �����?");
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
		
		// 1. ���� ���� ���� (�ؽ�Ʈ)
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel taskLabel = new JLabel("���� �ִ� ������ �� ���ΰ���?");
		taskLabel.setFont(labelFont);
		mainPanel.add(taskLabel, gbc);
		
		gbc.gridy++;
		JPanel taskPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		taskPanel.setBackground(mainPanel.getBackground());
		JTextField taskField = new JTextField();
		taskField.setPreferredSize(new Dimension(150, 30));
		taskField.setHorizontalAlignment(JTextField.CENTER);
		JLabel unitLabel = new JLabel("��");
		unitLabel.setFont(buttonFont);
		taskPanel.add(taskField);
		taskPanel.add(unitLabel);
		mainPanel.add(taskPanel, gbc);
		
		// 2. ���� ������ ���� (�����̴�)
		gbc.gridy++;
		JLabel intensityLabel = new JLabel("���� �ִ� ������ ������ ��� �����ΰ���?");
		intensityLabel.setFont(labelFont);
		mainPanel.add(intensityLabel, gbc);
		
		gbc.gridy++;
		JSlider intensitySlider = new JSlider(0, 2, 1);
		intensitySlider.setMajorTickSpacing(1);
		intensitySlider.setPaintTicks(true);
		intensitySlider.setPaintLabels(true);
		intensitySlider.setOpaque(false);
		Hashtable<Integer, JLabel> sliderLabels = new Hashtable<>();
		sliderLabels.put(0, new JLabel("���ƿ�"));
		sliderLabels.put(1, new JLabel("�����̿���"));
		sliderLabels.put(2, new JLabel("���ƿ�"));
		sliderLabels.forEach((k, v) -> v.setFont(buttonFont));
		intensitySlider.setLabelTable(sliderLabels);
		mainPanel.add(intensitySlider, gbc);
		
		// 3. ���� ȸ�� ���� + ���� (���� ��ư + ��Ӵٿ� �޺��ڽ�)
		gbc.gridy++;
		JLabel meetingLabel = new JLabel("���� �ִ� ȸ�ǰ� �ֳ���?");
		meetingLabel.setFont(labelFont);
		mainPanel.add(meetingLabel, gbc);
		
		gbc.gridy++;
		JPanel meetingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		meetingPanel.setBackground(mainPanel.getBackground());
		JRadioButton meetingYes = new JRadioButton("�־��");
		JRadioButton meetingNo = new JRadioButton("�����");
		meetingYes.setFont(buttonFont);
		meetingNo.setFont(buttonFont);
		meetingYes.setBackground(mainPanel.getBackground());
		meetingNo.setBackground(mainPanel.getBackground());
		ButtonGroup meetingGroup = new ButtonGroup();
		meetingGroup.add(meetingYes);
		meetingGroup.add(meetingNo);
		meetingPanel.add(meetingYes);
		meetingPanel.add(meetingNo);
		mainPanel.add(meetingPanel, gbc);
		
		gbc.gridy++;
		JComboBox<String> meetingCountCombo = new JComboBox<>(new String[]{"1��", "2��", "3��", "4��", "5��"});
		meetingCountCombo.setEnabled(false);
		meetingCountCombo.setFont(buttonFont);
		meetingCountCombo.setPreferredSize(new Dimension(100, 25));
		mainPanel.add(meetingCountCombo, gbc);
		
		meetingYes.addActionListener(e -> meetingCountCombo.setEnabled(true));
		meetingNo.addActionListener(e -> meetingCountCombo.setEnabled(false));
		
		// 4. ���� ����� ��� (���� ��ư)
		gbc.gridy++;
		JLabel bossMoodLabel = new JLabel("���� ����� ����� �����?");
		bossMoodLabel.setFont(labelFont);
		mainPanel.add(bossMoodLabel, gbc);
		
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
		SwingUtilities.invokeLater(() -> new WorkStatusUI());
	}	
}
