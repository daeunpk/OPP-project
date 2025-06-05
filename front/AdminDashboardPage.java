import javax.swing.*;
import java.awt.*;

public class AdminDashboardPage extends JFrame {

    public AdminDashboardPage() {
        setTitle("관리자 대시보드");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // 전체 화면
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(13, 39, 84)); // NAVY

        // 화면 크기 가져오기
        int frameWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        // 제목 라벨
        JLabel title = new JLabel("전체 통계 요약");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        title.setForeground(new Color(245, 245, 220));
        title.setBounds((frameWidth - 300) / 2, 80, 300, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        // 오늘 이용자 수 라벨
        JLabel todayUsers = new JLabel("오늘 이용자 수: 25,394명");
        todayUsers.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        todayUsers.setForeground(new Color(245, 245, 220));
        todayUsers.setBounds((frameWidth - 300) / 2, 140, 300, 30);
        todayUsers.setHorizontalAlignment(SwingConstants.CENTER);
        add(todayUsers);

        // 버튼 크기
        int buttonWidth = 180;
        int buttonHeight = 40;
        int gap = 30;

        // 유저 관리 버튼
        JButton userManageBtn = new JButton("유저 관리");
        userManageBtn.setBounds((frameWidth - buttonWidth * 2 - gap) / 2, 200, buttonWidth, buttonHeight);
        add(userManageBtn);
        userManageBtn.addActionListener(e -> {
            dispose();
            new UserManagementPage();
        });

        // 루틴 관리 버튼
        JButton routineManageBtn = new JButton("루틴 관리");
        routineManageBtn.setBounds((frameWidth + gap) / 2, 200, buttonWidth, buttonHeight);
        add(routineManageBtn);
        routineManageBtn.addActionListener(e -> {
            dispose();
            new RoutineManagementPage();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminDashboardPage();
    }
}
