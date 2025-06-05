import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

public class DetailedRoutineUI extends JFrame {
	public DetailedRoutineUI() {
		setTitle("GOODBYE-OFFICE");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
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
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		mainPanel.add(topButtonPanel, gbc);
		
		// 상단 제목
        gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel titleLabel = new JLabel("오늘의 루틴을 추천해 드릴게요! 세부 항목을 선택해 주세요.");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(new Color(0x4E4E4E));
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		mainPanel.add(titleLabel, gbc);
		
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
		
		// 카테고리별 항목 패널
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		categoryPanel.setOpaque(false);
		
		addCategory(categoryPanel, "식사",
			new String[]{"유부우동", "버섯전골", "계란말이", "연어덮밥", "샤브샤브"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/유부우동.png",
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/버섯전골.png",
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/계란말이.png",
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/연어덮밥.png",
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/샤브샤브.png"
			});
		
		addCategory(categoryPanel, "OTT",
			new String[]{"넷플릭스 \n <오늘도 무사히>", "왓챠 <휴가에 뭐 하지?>"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/유부우동.png",
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/버섯전골.png"
			});
		
		addCategory(categoryPanel, "스트레칭",
			new String[]{"유튜브 <10분 전신 풀기 루틴 - 뻐근함 해소>"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/유부우동.png"
			});
		
		addCategory(categoryPanel, "자기계발",
			new String[]{"하루 1단어 영어 암기 앱 사용", "책 <아주 작은 습관의 힘> 10분 읽기"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/유부우동.png",
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/버섯전골.png"
			});
		addCategory(categoryPanel, "마무리",
			new String[]{"디카페인 차 한잔", "하루 감정 일기 쓰기 앱(Mooda, DailyBean) 사용"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/유부우동.png",
				"C:/Users/jjoo4/OneDrive/바탕 화면/food/버섯전골.png"
			});
		
		JScrollPane scrollPane = new JScrollPane(categoryPanel);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		mainPanel.add(scrollPane, gbc);
		
		// 선택 완료 버튼 (하단 오른쪽)
		gbc.gridy++;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setBackground(mainPanel.getBackground());
		JButton submitButton = new JButton("선택 완료");
		submitButton.setFont(buttonFont);
		submitButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "입력이 완료되었습니다."));
		buttonPanel.add(submitButton);
		gbc.gridx = 1;
		mainPanel.add(buttonPanel, gbc);
		
		add(mainPanel);
		setVisible(true);
	}
	
	private void addCategory(JPanel parent, String title, String[] options, String[] imagePaths) {
		JPanel categoryBox = new JPanel();
		categoryBox.setLayout(new BorderLayout());
		categoryBox.setOpaque(false);
		categoryBox.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
		
		JLabel categoryTitle = new JLabel(title);
		categoryTitle.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		categoryBox.add(categoryTitle, BorderLayout.NORTH);
		
		JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		optionPanel.setOpaque(false);
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 0; i < options.length; i++) {
			final int index = i;
			
			JToggleButton button = new JToggleButton(){
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					
					if (isSelected()) {	// 어두운 오버레이
						g.setColor(new Color(0, 0, 0, 100)); // 반투명 검정
						g.fillRect(0, 0, getWidth(), getHeight());

						// 가운데 체크 아이콘
						g.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
						g.setColor(Color.WHITE);
						FontMetrics fm = g.getFontMetrics();
						String check = "V";
						int x = (getWidth() - fm.stringWidth(check)) / 2;
						int y = (getHeight() + fm.getAscent()) / 2 - 8;
						g.drawString(check, x, y);
					}
				}
			};
			
			button.setLayout(new BorderLayout());
			button.setPreferredSize(new Dimension(150, 180));
			button.setText("<html><center>" + options[i] + "</center></html>");
			button.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setIcon(new ImageIcon(imagePaths[i]));
			
			button.setContentAreaFilled(false);
			button.setOpaque(false);
			button.setFocusPainted(false);
			button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			
			button.setVerticalAlignment(SwingConstants.TOP);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			
			group.add(button);
			optionPanel.add(button);
		}
		
		categoryBox.add(optionPanel, BorderLayout.CENTER);
		parent.add(categoryBox);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new DetailedRoutineUI());
	}
}
