import javax.swing.*;
import java.awt.*;

public class RoutineDonePage extends JFrame {

    public RoutineDonePage() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("전송 완료");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(13, 39, 84)); // 딥 네이비

        setLayout(new BorderLayout());

        // 상단 타이틀 바
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(13, 39, 84));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        JLabel titleLabel = new JLabel("GOODBYE-OFFICE");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
        topPanel.add(titleLabel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);

        // 중앙 내용
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(13, 39, 84));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel completeLabel = new JLabel("전송 완료!");
        completeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        completeLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        completeLabel.setForeground(new Color(255, 244, 225));
        completeLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));

        // 체크 아이콘 (흰색 원 안에 ✓)
        // 체크 아이콘을 그리는 사용자 정의 컴포넌트
        // 투명 배경에 원과 체크 표시만 그리는 패널
        JPanel circleCheck = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // 투명 배경 설정
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // 원 그리기
                g2.setColor(Color.WHITE);
                g2.fillOval(0, 0, getWidth(), getHeight());

                // 체크 문자 그리기
                g2.setColor(new Color(13, 39, 84));
                g2.setFont(new Font("Dialog", Font.BOLD, 40));
                FontMetrics fm = g2.getFontMetrics();
                String check = "✓";
                int x = (getWidth() - fm.stringWidth(check)) / 2;
                int y = (getHeight() + fm.getAscent()) / 2 - 5;
                g2.drawString(check, x, y);
            }
        };

        circleCheck.setPreferredSize(new Dimension(80, 80));
        circleCheck.setMaximumSize(new Dimension(80, 80));
        circleCheck.setAlignmentX(Component.CENTER_ALIGNMENT);
        circleCheck.setOpaque(false); // 💡 사각형 배경 제거 핵심


        circleCheck.setPreferredSize(new Dimension(80, 80));
        circleCheck.setMaximumSize(new Dimension(80, 80));
        circleCheck.setAlignmentX(Component.CENTER_ALIGNMENT);


        // 메인 화면 버튼
        JButton backButton = new JButton("메인 화면");
        backButton.setFocusPainted(false);
        backButton.setBackground(new Color(255, 244, 225));
        backButton.setForeground(new Color(29, 44, 107));
        backButton.setFont(new Font("Dialog", Font.BOLD, 14));
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            dispose();
            new MainPage().setVisible(true); // 메인 페이지로 이동
        });

        centerPanel.add(completeLabel);
        centerPanel.add(circleCheck);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(backButton);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

