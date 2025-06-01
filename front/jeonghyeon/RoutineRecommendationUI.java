import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoutineRecommendationUI extends JFrame {
	public RoutineRecommendationUI() {
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
		Font smallFont	= new Font("Malgun Gothic", Font.PLAIN, 11);
		Font subFont	= new Font("Malgun Gothic", Font.BOLD, 12);
		Font buttonFont	= new Font("Malgun Gothic", Font.PLAIN, 13);
		Font basicFont	= new Font("Malgun Gothic", Font.BOLD, 15);
		Font labelFont	= new Font("Malgun Gothic", Font.BOLD, 18);
		Font titleFont	= new Font("Malgun Gothic", Font.BOLD, 22);
		
		// 상단 오른쪽 버튼 패널 (재추천/설정/홈)
		JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		topButtonPanel.setBackground(mainPanel.getBackground());
		topButtonPanel.setPreferredSize(new Dimension(350, 40));
		
		JButton refreshButton = new JButton("루틴 재추천");
		JButton settingButton = new JButton("설정");
		JButton homeButton = new JButton("홈");
		refreshButton.setFont(buttonFont);
		settingButton.setFont(buttonFont);
		homeButton.setFont(buttonFont);
		topButtonPanel.add(refreshButton);
		topButtonPanel.add(settingButton);
		topButtonPanel.add(homeButton);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		mainPanel.add(topButtonPanel, gbc);
		
		// 0. 제목
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel titleLabel = new JLabel("오늘의 루틴을 추천해 드릴게요!");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(new Color(0x4E4E4E));
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		mainPanel.add(titleLabel, gbc);
		
		// 서브 타이틀
		gbc.gridy++;
		JLabel subtitleLabel = new JLabel("오늘 기분: 피곤함 / 퇴근 시간: 20:45");
		subtitleLabel.setFont(subFont);
		subtitleLabel.setForeground(new Color(0x8B2C46));
		subtitleLabel.setHorizontalAlignment(JLabel. RIGHT);
		mainPanel.add(subtitleLabel, gbc);
		
		// 가로선
		gbc.gridy++;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 0;
		
		JPanel linePanel = new JPanel();
		linePanel.setBackground(new Color(0x4E4E4E));
		linePanel.setPreferredSize(new Dimension(600, 2));
		linePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
		linePanel.setMinimumSize(new Dimension(10, 2));
		mainPanel.add(linePanel, gbc);
		gbc.gridwidth = 1;
		
		// 루틴 패널
		gbc.gridy++;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		JPanel routinePanel = new JPanel(new GridLayout(1, 3, 10, 0));
		routinePanel.setBackground(mainPanel.getBackground());
		
		ButtonGroup routineGroup = new ButtonGroup();
		for (int i = 1; i <= 3; i++) {
			JPanel singleRoutine = createRoutinePanel("루틴 " + i, labelFont, basicFont, smallFont, routineGroup);
			routinePanel.add(singleRoutine);
		}
		
		mainPanel.add(routinePanel, gbc);
		
		// 하단 여백
		gbc.gridy++;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		mainPanel.add(Box.createVerticalGlue(), gbc);
		
		// 선택 완료 버튼 (하단 오른쪽)
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		
		JButton submitButton = new JButton("선택 완료");
		submitButton.setFont(buttonFont);
		submitButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "루틴이 선택되었습니다."));
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		buttonPanel.setBackground(mainPanel.getBackground());
		buttonPanel.setPreferredSize(new Dimension(350, 40));
		buttonPanel.add(submitButton);
		mainPanel.add(buttonPanel, gbc);
		
		add(mainPanel);
		setVisible(true);	
	}
	
	// 메소드를 생성자 밖으로
	private JPanel createRoutinePanel(String title, Font labelFont, Font basicFont, Font smallFont, ButtonGroup group) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(250, 240, 230));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JRadioButton radioButton = new JRadioButton();
		radioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		radioButton.setBackground(panel.getBackground());
		group.add(radioButton);
		panel.add(radioButton);
		
		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(labelFont);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(titleLabel);
		
		JLabel subtitle = new JLabel("나 혼자만의 여유로운 시간을 즐기는 날");
		subtitle.setFont(smallFont);
		subtitle.setForeground(new Color(0x8B2C46));
		subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(subtitle);
		
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeSeparator());
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeTimeBlock("21:25", "Dinner", "따뜻한 저녁 식사로 몸과 마음을 달래기", basicFont, smallFont));
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeSeparator());
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeTimeBlock("22:25", "Content Time", "가볍고 편안한 콘텐츠로 휴식 시간 즐기기", basicFont, smallFont));
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeSeparator());
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeTimeBlock("23:45", "Wind Down", "샤워 후 스트레칭으로 하루 마무리 준비", basicFont, smallFont));
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeSeparator());
		panel.add(Box.createVerticalStrut(8));
		panel.add(makeTimeBlock("00:30", "Wrap Up", "휴식 마무리, 마음 정리 후 취침", basicFont, smallFont));
		
		return panel;
	}
	
	private JPanel makeTimeBlock(String time, String category, String desc, Font catFont, Font descFont) {
		JPanel block = new JPanel(new BorderLayout());
		block.setBackground(new Color(250, 240, 230));
		block.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JLabel timeLabel = new JLabel(time);
		timeLabel.setFont(catFont);
		timeLabel.setPreferredSize(new Dimension(60, 30));
		block.add(timeLabel, BorderLayout.WEST);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBackground(block.getBackground());
		
		JLabel catLabel = new JLabel(category);
		catLabel.setFont(catFont);
		catLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel descLabel = new JLabel("<html><div style='width:130px; word-break:normal;'>" + desc + "</div></html>");
		descLabel.setFont(descFont);
		descLabel.setForeground(Color.DARK_GRAY);
		descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		rightPanel.add(catLabel);
		rightPanel.add(Box.createVerticalStrut(5));
		rightPanel.add(descLabel);
		
		block.add(rightPanel, BorderLayout.CENTER);
		return block;
	}
	
	private JSeparator makeSeparator() {
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		separator.setForeground(Color.GRAY);
		return separator;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new RoutineRecommendationUI());
	}
}
