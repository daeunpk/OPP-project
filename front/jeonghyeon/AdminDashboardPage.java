import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdminDashboardPage extends JFrame {

    public AdminDashboardPage() {
        setTitle("GOODBYE-OFFICE");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // 전체 화면
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(13, 39, 84)); // NAVY

        // ===== 상단 바 =====
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(13, 39, 84));
        topBar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        // 좌측 타이틀
        JLabel dashboardTitle = new JLabel("관리자 대시보드");
        dashboardTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
        dashboardTitle.setForeground(Color.WHITE);
        dashboardTitle.setBorder(new EmptyBorder(20, 30, 20, 0));
        topBar.add(dashboardTitle, BorderLayout.WEST);

        // 우측 날짜, 아이콘
        JPanel rightBar = new JPanel();
        rightBar.setOpaque(false);
        rightBar.setLayout(new BoxLayout(rightBar, BoxLayout.X_AXIS));
		
		// 버튼 패널
		JPanel iconPanel = new JPanel();
		iconPanel.setOpaque(false);
		iconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		
		JLabel saveIcon = new JLabel("\uD83D\uDCBE"); // 저장 아이콘
		JLabel homeIcon = new JLabel("\u2302");       // 홈 아이콘
		iconPanel.add(saveIcon);
		iconPanel.add(homeIcon);
		
        // 날짜 라벨
		JLabel dateLabel = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일")));
		dateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setBorder(new EmptyBorder(5, 0, 0, 30));
		
		rightBar.add(iconPanel);
		rightBar.add(dateLabel);
		
        // ===== 메인 2단 영역 =====
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setOpaque(false);

        // ----- 좌측: 전체 통계 요약 + 그래프 -----
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(60, 60, 60, 30));

        JLabel summaryTitle = new JLabel("전체 통계 요약");
        summaryTitle.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        summaryTitle.setForeground(Color.WHITE);
        summaryTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel todayUsers = new JLabel("<html><span style='color:#FF8B8B;'>오늘 이용자 수</span><br><span style='font-size:28px;font-weight:bold;color:white;'>25,394 명</span></html>");
        todayUsers.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
        todayUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
        todayUsers.setBorder(new EmptyBorder(20, 0, 20, 0));

        leftPanel.add(summaryTitle);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(todayUsers);

        // 그래프 패널
        JPanel graphPanel = new BarGraphPanel();
        graphPanel.setPreferredSize(new Dimension(400, 260));
        graphPanel.setMaximumSize(new Dimension(600, 300));
        graphPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(graphPanel);
		
		// 버튼 패널 생성 (유저 관리/루틴 관리)
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		// 유저 관리 버튼 (메모리 항목 [6][7] 참조)
		JButton userManageButton = new JButton("유저 관리");
		userManageButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		userManageButton.setPreferredSize(new Dimension(140, 40));
		userManageButton.setBackground(new Color(255, 107, 107));  // 메모리 [5] 색상 강조
		userManageButton.addActionListener(e -> {
			new UserManagementPage();  // 실제 클래스 연결
		});
		
		// 루틴 관리 버튼
		JButton routineManageButton = new JButton("루틴 관리");
		routineManageButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		routineManageButton.setPreferredSize(new Dimension(140, 40));
		routineManageButton.setBackground(new Color(102, 204, 255));
		routineManageButton.addActionListener(e -> {
			new RoutineManagementPage();  // 실제 클래스 연결
		});
		
		buttonPanel.add(userManageButton);
		buttonPanel.add(routineManageButton);
		leftPanel.add(buttonPanel);
		
        mainPanel.add(leftPanel);
		
        // ----- 우측: 인기 루틴 TOP 3 -----
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new EmptyBorder(60, 30, 60, 60));

        JLabel topTitle = new JLabel("인기 루틴 TOP 3", SwingConstants.CENTER);
		topTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        topTitle.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        topTitle.setForeground(Color.WHITE);
        topTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        topTitle.setBorder(new EmptyBorder(0, 0, 30, 0));
        rightPanel.add(topTitle);

        // 루틴 리스트
        rightPanel.add(makeRoutinePanel("1st", true));
        rightPanel.add(makeRoutinePanel("2nd", false));
        rightPanel.add(makeRoutinePanel("3rd", false));

        mainPanel.add(rightPanel);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // 막대 그래프 커스텀 패널
    static class BarGraphPanel extends JPanel {
        int[] values = {12000, 17000, 14000, 25394};
        String[] labels = {"5월 16일", "5월 17일", "5월 18일", "5월 19일"};
        Color[] barColors = {
            new Color(255, 107, 107),
            new Color(102, 204, 255),
            new Color(255, 221, 102),
            new Color(102, 255, 204)
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            int maxVal = 26000;

            // 배경
            g2.setColor(new Color(13, 39, 84));
            g2.fillRect(0, 0, width, height);

            // 가로선
            g2.setColor(Color.BLACK);
            for (int i = 0; i < 6; i++) {
                int y = 30 + i * (height - 60) / 5;
                g2.drawLine(40, y, width - 40, y);
            }

            // 막대
            int barWidth = (width - 120) / values.length;
            for (int i = 0; i < values.length; i++) {
                int barHeight = (int) ((double) values[i] / maxVal * (height - 80));
                int x = 60 + i * barWidth + 10;
                int y = height - 40 - barHeight;
                g2.setColor(barColors[i]);
                g2.fillRoundRect(x, y, barWidth - 20, barHeight, 12, 12);
            }

            // 레이블
            g2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            g2.setColor(Color.WHITE);
            for (int i = 0; i < labels.length; i++) {
                int x = 60 + i * barWidth + (barWidth - 20) / 2 - 30;
                g2.drawString(labels[i], x, height - 15);
            }
        }
    }

    // 루틴 패널 생성
    private JPanel makeRoutinePanel(String rank, boolean withTopGap) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        if (withTopGap) panel.setBorder(new EmptyBorder(0, 0, 20, 0));
        else panel.setBorder(new EmptyBorder(10, 0, 20, 0));

        // 순위
        JLabel rankLabel = new JLabel(rank);
        rankLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        rankLabel.setForeground(new Color(160, 200, 255));
        rankLabel.setPreferredSize(new Dimension(50, 60));

        // 루틴명 및 설명
        JPanel routineInfo = new JPanel();
        routineInfo.setOpaque(false);
        routineInfo.setLayout(new GridLayout(3, 2, 10, 0));
        Font boldFont = new Font("맑은 고딕", Font.BOLD, 16);
        Font plainFont = new Font("맑은 고딕", Font.PLAIN, 16);

        routineInfo.add(new JLabel("DINNER", SwingConstants.LEFT) {{ setFont(boldFont); setForeground(Color.WHITE); }});
        routineInfo.add(new JLabel("따뜻한 저녁 식사", SwingConstants.LEFT) {{ setFont(plainFont); setForeground(Color.WHITE); }});
        routineInfo.add(new JLabel("CONTENT TIME", SwingConstants.LEFT) {{ setFont(boldFont); setForeground(Color.WHITE); }});
        routineInfo.add(new JLabel("가볍고 편안한 콘텐츠", SwingConstants.LEFT) {{ setFont(plainFont); setForeground(Color.WHITE); }});
        routineInfo.add(new JLabel("WIND DOWN", SwingConstants.LEFT) {{ setFont(boldFont); setForeground(Color.WHITE); }});
        routineInfo.add(new JLabel("샤워 후 스트레칭", SwingConstants.LEFT) {{ setFont(plainFont); setForeground(Color.WHITE); }});

        panel.add(rankLabel, BorderLayout.WEST);
        panel.add(routineInfo, BorderLayout.CENTER);

        // 구분선
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(80, 120, 180));
        panel.add(sep, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminDashboardPage::new);
    }
}