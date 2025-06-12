import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RoutineResultUI extends JFrame {
	
	// 클래스 레벨 변수 선언
	private JPanel topPanel; // 상단 패널
	private JPanel contentPanel; // 본문 패널
	private JPanel leftPanel; // 좌측 루틴 리스트
	private JPanel topButtonPanel; // 상단 버튼 패널
	
	public RoutineResultUI() {
		setTitle("GOODBYE-OFFICE");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 모니터 화면 중앙
		
		// 전체 레이아웃
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(3, 46, 104));
		
		// 폰트 설정
		Font subFont	= new Font("Malgun Gothic", Font.BOLD, 12);
		Font buttonFont	= new Font("Malgun Gothic", Font.PLAIN, 13);
		Font titleFont	= new Font("Malgun Gothic", Font.BOLD, 22);
		
		// ==== 상단 패널 ====
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(3, 46, 104));
		topPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
		
		// 상단 오른쪽 버튼 패널 (저장/홈)
		topButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		topButtonPanel.setBackground(topPanel.getBackground());
		
		JButton saveButton = new JButton("💾 저장");
		JButton homeButton = new JButton("🏠 홈");
		saveButton.setFont(buttonFont);
		homeButton.setFont(buttonFont);
		// saveButton.setBackground(Color.WHITE);
		// homeButton.setBackground(Color.WHITE);
		topButtonPanel.add(saveButton);
		topButtonPanel.add(homeButton);
		topPanel.add(topButtonPanel, BorderLayout.NORTH);
		
		// 제목
		JLabel titleLabel = new JLabel("최종으로 결정된 루틴 보여드릴게요!");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.WHITE);
		topPanel.add(titleLabel, BorderLayout.CENTER);
		
		// 정보 라벨
		String mood = "피곤함";
		String leaveTime = "20:45";
		JLabel infoLabel = new JLabel("오늘 기분: " + mood + " / 퇴근 시간: " + leaveTime);
		infoLabel.setFont(subFont);
		infoLabel.setForeground(new Color(255, 170, 170));
		infoLabel.setHorizontalAlignment(JLabel. RIGHT);
		topPanel.add(infoLabel, BorderLayout.SOUTH);
		
		add(topPanel, BorderLayout.NORTH);
		
		// ==== 본문 패널 ====
		contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
		contentPanel.setBackground(new Color(3, 46, 104));
		contentPanel.setBorder(new EmptyBorder(20, 40, 40, 40));
		
		// 왼쪽: 루틴 리스트 패널
		leftPanel = createLeftPanel();
		
		// 오른쪽: 반원형 시간표 패널
		JPanel rightPanel = new SemiCircleSchedulePanel();
		rightPanel.setBackground(new Color(3, 46, 104));
		
		contentPanel.add(leftPanel);
		contentPanel.add(rightPanel);
		
		add(contentPanel, BorderLayout.CENTER);

		setVisible(true);
	}
	
	// 루틴 리스트 패널
	private JPanel createLeftPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(3, 46, 104));
		
		// 날짜
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		JLabel dateLabel = new JLabel(today);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(dateLabel);
		
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		// 루틴 제목
		JLabel mainTitle = new JLabel("오늘의 최종 루틴");
		mainTitle.setForeground(Color.WHITE);
		mainTitle.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		mainTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(mainTitle);
		
		// 서브 타이틀
		JLabel subtitle = new JLabel("나 혼자만의 여유로운 시간을 즐기는 날");
		subtitle.setForeground(new Color(255, 170, 170));
		subtitle.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(subtitle);
		
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		// 루틴 아이템
		panel.add(createRoutineItemWithImage("21:25", "DINNER", 
			"따뜻한 저녁 식사로 몸과 마음을 달래기", "버섯 전골"));
		panel.add(createRoutineItemWithImage("22:25", "CONTENT TIME", 
			"가볍고 편안한 콘텐츠로 휴식 시간 즐기기", "넷플릭스<오늘도 무사히>"));
		panel.add(createRoutineItemWithImage("23:45", "WIND DOWN", 
			"샤워 후 스트레칭으로 하루 마무리 준비", "유튜브<10분 전신 풀기 루틴>"));
		panel.add(createRoutineItemWithImage("00:25", "WRAP UP", 
			"휴식 마무리, 마음 정리 후 취침", "디카페인 차 한 잔"));
		
		return panel;
	}
	
	// 세부 루틴 연결
	private JPanel createRoutineItemWithImage(String time, String title, String desc, String caption) {
		JPanel panel = new JPanel(new BorderLayout(15, 0));
		panel.setBackground(new Color(3, 46, 104));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
		
		// 왼쪽 텍스트 부분
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.setBackground(new Color(3, 46, 104));
		
		JLabel timeLabel = new JLabel(time + "   " + title);
		timeLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel descLabel = new JLabel("<html>" + desc + "</html>");
		descLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		descLabel.setForeground(Color.WHITE);
		descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel captionLabel = new JLabel(caption);
		captionLabel.setFont(new Font("Malgun Gothic", Font.ITALIC, 12));
		captionLabel.setForeground(new Color(200, 220, 240));
		captionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		textPanel.add(timeLabel);
		textPanel.add(Box.createRigidArea(new Dimension(0, 3)));
		textPanel.add(descLabel);
		textPanel.add(Box.createRigidArea(new Dimension(0, 3)));
		textPanel.add(captionLabel);
		
		// 오른쪽 이미지 부분
		JLabel imageLabel = new JLabel();
		imageLabel.setPreferredSize(new Dimension(80, 80));
		imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		imageLabel.setBackground(new Color(200, 150, 100));
		imageLabel.setOpaque(true);
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setText("🍲"); // 임시 이모지
		imageLabel.setFont(new Font("", Font.PLAIN, 30));
		
		panel.add(textPanel, BorderLayout.CENTER);
		panel.add(imageLabel, BorderLayout.EAST);
		panel.setBorder(new EmptyBorder(10, 0, 15, 0));
		
		return panel;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(RoutineResultUI::new);
	}
}

// 반원형 시간표 패널
class SemiCircleSchedulePanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int width = getWidth();
		int height = getHeight();
		int radius = Math.min(width, height * 2) - 40;
		
		int centerX = width / 2;
		int centerY = height - 20;
		
		// 시간 구간별 색상과 라벨
		String[] labels = {"DINNER", "CONTENT TIME", "WIND DOWN", "WRAP UP"};
		Color[] colors = {
			new Color(255, 170, 170),  // 분홍
			new Color(255, 200, 150),  // 주황
			new Color(180, 230, 180),  // 연두
			new Color(200, 200, 240)   // 연보라
		};
		int[] angles = {30, 60, 30, 60}; // 각 구간의 각도
		
		int currentAngle = 0;
		for (int i = 0; i < labels.length; i++) {
			g2.setColor(colors[i]);
			g2.fillArc(centerX - radius/2, centerY - radius/2, radius, radius, currentAngle, angles[i]);
			currentAngle += angles[i];
		}
		
		// 시간 라벨 그리기
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		
		String[] timeLabels = {"18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00",
				       "01:00", "02:00", "03:00", "04:00", "05:00", "06:00"};
		
		for (int i = 0; i < timeLabels.length; i++) {
			double angle = Math.toRadians(i * 180.0 / (timeLabels.length - 1));
			int x = (int) (centerX + (radius/2 + 20) * Math.cos(Math.PI - angle));
			int y = (int) (centerY - (radius/2 + 20) * Math.sin(Math.PI - angle));
			
		g2.drawString(timeLabels[i], x - 15, y + 5);
	}
	
	// 구간 라벨
	currentAngle = 15;
		for (int i = 0; i < labels.length; i++) {
			double angle = Math.toRadians(currentAngle + angles[i]/2);
			int x = (int) (centerX + (radius/3) * Math.cos(Math.PI - angle));
			int y = (int) (centerY - (radius/3) * Math.sin(Math.PI - angle));
			
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
			g2.drawString(labels[i], x - 30, y);
			
			currentAngle += angles[i];
		}
	}
}
