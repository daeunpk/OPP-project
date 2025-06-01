import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {
        setTitle("로그인");

        setExtendedState(JFrame.MAXIMIZED_BOTH); // 전체화면
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(13, 39, 84));
        panel.setLayout(null);

        // 화면 크기 정보 얻기
        int frameWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        // 제목 라벨
        JLabel titleLabel = new JLabel("GOODBYE-OFFICE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds((frameWidth - 250) / 2, 80, 250, 30);
        panel.add(titleLabel);

        // 사번 라벨
        JLabel idLabel = new JLabel("사번:");
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds((frameWidth - 300) / 2, 150, 40, 25);
        panel.add(idLabel);

        // 사번 입력 필드
        JTextField idField = new JTextField();
        idField.setBounds((frameWidth - 300) / 2 + 50, 150, 200, 25);
        panel.add(idField);

        // 이름 라벨
        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds((frameWidth - 300) / 2, 190, 40, 25);
        panel.add(nameLabel);

        // 이름 입력 필드
        JTextField nameField = new JTextField();
        nameField.setBounds((frameWidth - 300) / 2 + 50, 190, 200, 25);
        panel.add(nameField);

        // 버튼 크기 및 위치 공통 변수
        int buttonWidth = 200;
        int buttonHeight = 40;
        int centerX = (frameWidth - buttonWidth) / 2;

        // 로그인 버튼
        JButton loginButton = new JButton("로그인 하기");
        loginButton.setBounds(centerX, 240, buttonWidth, buttonHeight);
        panel.add(loginButton);

        // 회원가입 버튼
        JButton signUpButton = new JButton("회원가입 하기");
        signUpButton.setBounds(centerX, 300, buttonWidth, buttonHeight);
        panel.add(signUpButton);

        // 회원가입 페이지로 이동
        signUpButton.addActionListener(e -> {
            new SignUpPage().setVisible(true);
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}
