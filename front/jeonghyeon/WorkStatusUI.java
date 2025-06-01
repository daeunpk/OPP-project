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
		setLocationRelativeTo(null); // 모니터 화면 중앙
		
		// 메인 패널 설정
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(250, 240, 230));
		mainPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 0);
		
		// 폰트 설정
		Font buttonFont = new Font("Malgun Gothic", Font.PLAIN, 13);
		Font labelFont = new Font("Malgun Gothic", Font.PLAIN, 16);
		Font titleFont = new Font("Malgun Gothic", Font.BOLD, 22);
		
		// 상단 오른쪽 버튼 패널 (설정/홈)
		JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		topButtonPanel.setBackground(mainPanel.getBackground());
		JButton settingButton = new JButton("설정");
		JButton homeButton = new JButton("홈");
		settingButton.setFont(buttonFont);
		homeButton.setFont(buttonFont);
		topButtonPanel.add(settingButton);
		topButtonPanel.add(homeButton);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		mainPanel.add(topButtonPanel, gbc);
		
		// 0. 제목
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel titleLabel = new JLabel("퇴근 시간을 예측해 볼까요?");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(new Color(0x4E4E4E));
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		mainPanel.add(titleLabel, gbc);
		
		// 가로선
		gbc.gridy++;
		JPanel linePanel = new JPanel();
		linePanel.setBackground(new Color(0x4E4E4E));
		linePanel.setPreferredSize(new Dimension(600, 2));
		mainPanel.add(linePanel, gbc);
		gbc.gridwidth = 1;
		
		// 1. 남은 업무 개수 (텍스트)
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel taskLabel = new JLabel("남아 있는 업무는 몇 개인가요?");
		taskLabel.setFont(labelFont);
		mainPanel.add(taskLabel, gbc);
		
		gbc.gridy++;
		JPanel taskPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		taskPanel.setBackground(mainPanel.getBackground());
		JTextField taskField = new JTextField();
		taskField.setPreferredSize(new Dimension(150, 30));
		taskField.setHorizontalAlignment(JTextField.CENTER);
		JLabel unitLabel = new JLabel("개");
		unitLabel.setFont(buttonFont);
		taskPanel.add(taskField);
		taskPanel.add(unitLabel);
		mainPanel.add(taskPanel, gbc);
		
		// 2. 남은 업무의 강도 (슬라이더)
		gbc.gridy++;
		JLabel intensityLabel = new JLabel("남아 있는 업무의 강도는 어느 정도인가요?");
		intensityLabel.setFont(labelFont);
		mainPanel.add(intensityLabel, gbc);
		
		gbc.gridy++;
		JSlider intensitySlider = new JSlider(0, 2, 1);
		intensitySlider.setMajorTickSpacing(1);
		intensitySlider.setPaintTicks(true);
		intensitySlider.setPaintLabels(true);
		intensitySlider.setOpaque(false);
		Hashtable<Integer, JLabel> sliderLabels = new Hashtable<>();
		sliderLabels.put(0, new JLabel("낮아요"));
		sliderLabels.put(1, new JLabel("보통이에요"));
		sliderLabels.put(2, new JLabel("높아요"));
		sliderLabels.forEach((k, v) -> v.setFont(buttonFont));
		intensitySlider.setLabelTable(sliderLabels);
		mainPanel.add(intensitySlider, gbc);
		
		// 3. 남은 회의 유무 + 개수 (라디오 버튼 + 드롭다운 콤보박스)
		gbc.gridy++;
		JLabel meetingLabel = new JLabel("남아 있는 회의가 있나요?");
		meetingLabel.setFont(labelFont);
		mainPanel.add(meetingLabel, gbc);
		
		gbc.gridy++;
		JPanel meetingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		meetingPanel.setBackground(mainPanel.getBackground());
		JRadioButton meetingYes = new JRadioButton("있어요");
		JRadioButton meetingNo = new JRadioButton("없어요");
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
		JComboBox<String> meetingCountCombo = new JComboBox<>(new String[]{"1개", "2개", "3개", "4개", "5개"});
		meetingCountCombo.setEnabled(false);
		meetingCountCombo.setFont(buttonFont);
		meetingCountCombo.setPreferredSize(new Dimension(100, 25));
		mainPanel.add(meetingCountCombo, gbc);
		
		meetingYes.addActionListener(e -> meetingCountCombo.setEnabled(true));
		meetingNo.addActionListener(e -> meetingCountCombo.setEnabled(false));
		
		// 4. 오늘 상사의 기분 (라디오 버튼)
		gbc.gridy++;
		JLabel bossMoodLabel = new JLabel("오늘 상사의 기분은 어떤가요?");
		bossMoodLabel.setFont(labelFont);
		mainPanel.add(bossMoodLabel, gbc);
		
		gbc.gridy++;
		JPanel moodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		moodPanel.setBackground(mainPanel.getBackground());
		JRadioButton verygood = new JRadioButton("매우 좋음");
		JRadioButton good = new JRadioButton("좋음");
		JRadioButton average = new JRadioButton("보통");
		JRadioButton bad = new JRadioButton("나쁨");
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
		
		// 하단 여백
		gbc.gridy++;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		mainPanel.add(Box.createVerticalGlue(), gbc);
		
		// 선택 완료 버튼 (하단 오른쪽)
		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		JButton submitButton = new JButton("선택 완료");
		submitButton.setFont(buttonFont);
		submitButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "입력이 완료되었습니다."));
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
