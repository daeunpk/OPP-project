import javax.swing.*;
import java.awt.*;

public class RoutineDonePage extends JFrame {
    public RoutineDonePage() {
        setTitle("전송 완료");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel completeLabel = new JLabel("전송 완료!", SwingConstants.CENTER);
        completeLabel.setFont(new Font("dialog", Font.BOLD, 20));
        add(completeLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("메인 화면");
        backButton.addActionListener(e -> {
            dispose();
            new MainPage(); // 다시 메인 페이지로 이동
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
