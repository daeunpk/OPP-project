import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    public MainPage() {
        setTitle("GOODBYE OFFICE");

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
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 60, screenSize.width, 60);
        mainPanel.add(titleLabel);

        // 소개 텍스트
        JLabel serviceLabel = new JLabel("<html><div style='text-align: center;'>서비스 소개<br>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>~~~</div></html>", SwingConstants.CENTER);
        serviceLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        serviceLabel.setForeground(Color.WHITE);
        serviceLabel.setBounds(0, 140, screenSize.width, 100);
        mainPanel.add(serviceLabel);

        // 루틴 추천 박스
        JPanel routineBox = new JPanel();
        routineBox.setBackground(new Color(13, 39, 84));
        routineBox.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));
        routineBox.setLayout(null);
        routineBox.setBounds(screenSize.width/2 - 250, 280, 500, 300); // 중앙에 박스
        mainPanel.add(routineBox);

        JLabel routineLabel = new JLabel("루틴 추천", SwingConstants.CENTER);
        routineLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        routineLabel.setForeground(Color.WHITE);
        routineLabel.setBounds(0, 30, 500, 30);
        routineBox.add(routineLabel);

        // 시작 버튼
        JButton startButton = new JButton("지금 시작하기");
        startButton.setFont(new Font("Dialog", Font.PLAIN, 15));
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(new Color(13, 39, 84));
        startButton.setFocusPainted(false);
        startButton.setBounds(180, 200, 140, 40); // 박스 내 배치
        routineBox.add(startButton);

        // 👉 로그인 페이지로 이동
        startButton.addActionListener(e -> {
            new LoginPage().setVisible(true); // LoginPage로 이동
            dispose(); // 현재 창 닫기
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }
}
