import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    public MainPage() {
        setTitle("GOODBYE OFFICE");

        setExtendedState(JFrame.MAXIMIZED_BOTH); // 전체화면
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 전체 화면 설정
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // NAVY 배경
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(13, 39, 84));
        mainPanel.setLayout(null); // 수동 배치
        add(mainPanel);

        // 제목
        JLabel titleLabel = new JLabel("GOODBYE-OFFICE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Pretendard", Font.BOLD, 60)); // Pretendard 적용했으면 이 폰트 사용
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 100, screenSize.width, 70);
        mainPanel.add(titleLabel);

        // 구분선 (하얀 줄)
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(screenSize.width / 4, 180, screenSize.width / 2, 2);
        mainPanel.add(separator);

        // 소개 텍스트 (두 줄)
        JLabel descLabel = new JLabel("<html><div style='text-align: center;'>오늘 하루, 어땠나요?<br>간단한 입력만으로<br>퇴근 시간과 당신에게 꼭 맞는 마무리 루틴을 추천해드릴게요.</div></html>", SwingConstants.CENTER);
        descLabel.setFont(new Font("Pretendard", Font.PLAIN, 20));
        descLabel.setForeground(new Color(255, 244, 225));
        descLabel.setBounds(0, 210, screenSize.width, 120);
        mainPanel.add(descLabel);

        // 루틴 추천 텍스트
        JLabel routineLabel = new JLabel("루틴 추천", SwingConstants.CENTER);
        routineLabel.setFont(new Font("Pretendard", Font.PLAIN, 22));
        routineLabel.setForeground(new Color(255, 244, 225));
        routineLabel.setBounds(0, 400, screenSize.width, 30);
        mainPanel.add(routineLabel);

        // 시작 버튼
        JButton startButton = new JButton("지금 시작하기");
        startButton.setFont(new Font("Pretendard", Font.PLAIN, 18));
        startButton.setBackground(new Color(255, 244, 225));;
        startButton.setForeground(new Color(13, 39, 84));
        startButton.setFocusPainted(false);
        startButton.setBounds(screenSize.width / 2 - 100, 450, 200, 50);
        startButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        mainPanel.add(startButton);

        // 👉 로그인 페이지로 이동
        startButton.addActionListener(e -> {
            new LoginPage().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }
}
