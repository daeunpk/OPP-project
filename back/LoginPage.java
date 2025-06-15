import javax.swing.*;
import java.awt.*;
import service.*;
import model.*;

public class LoginPage extends JFrame {

    private JTextField employeeIdField;
    private JTextField nameField;
    private UserService userService = new UserService();


    public LoginPage() {
        setTitle("GOODBYE-OFFICE");

        setExtendedState(JFrame.MAXIMIZED_BOTH); // 전체화면
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
        JPanel panel = new JPanel();
        panel.setBackground(new Color(13, 39, 84));
        panel.setLayout(null);

        // 화면 크기 정보 얻기
        int frameWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        // 제목 라벨
        JLabel titleLabel = new JLabel("로그인");
        titleLabel.setFont(new Font("Pretendard", Font.BOLD, 40));
        titleLabel.setForeground(new Color(250, 240, 230));
        titleLabel.setBounds((frameWidth - 120) / 2, 150, 250, 60);
        panel.add(titleLabel);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(13, 39, 84));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(250, 240, 230)));

        JLabel topTitleLabel = new JLabel("GOODBYE - OFFICE");
        topTitleLabel.setForeground(new Color(250, 240, 230));
        topTitleLabel.setFont(new Font("Pretendard", Font.BOLD, 26));
        topTitleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
        topTitleLabel.setBackground(new Color(13, 39, 84));
        topPanel.add(topTitleLabel, BorderLayout.WEST);
		
		JButton homeButton = new JButton("\u2302");
		homeButton.setFont(new Font("Pretendard", Font.BOLD, 40));
		homeButton.setBackground(new Color(13, 39, 84));
		homeButton.setForeground(new Color(250, 240, 230));
		homeButton.setFocusPainted(false);
		homeButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		
		homeButton.addActionListener(e -> {
			new MainPage().setVisible(true);
			dispose();
		});
		topPanel.add(homeButton, BorderLayout.EAST);
		
        add(topPanel, BorderLayout.NORTH);

        // 사번 라벨
        JLabel idLabel = new JLabel("사번:");
        idLabel.setFont(new Font("Pretendard", Font.BOLD, 24));
        idLabel.setForeground(new Color(250, 240, 230));
        idLabel.setBounds((frameWidth - 420) / 2, 300, 60, 25);
        panel.add(idLabel);

        // 사번 입력 필드
        employeeIdField = new JTextField();
        employeeIdField.setFont(new Font("Pretendard", Font.PLAIN, 18));
        employeeIdField.setBounds((frameWidth - 420) / 2 + 90, 300, 300, 40);
        panel.add(employeeIdField);

        // 이름 라벨
        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setFont(new Font("Pretendard", Font.BOLD, 24));
        nameLabel.setForeground(new Color(250, 240, 230));
        nameLabel.setBounds((frameWidth - 420) / 2, 400, 60, 25);
        panel.add(nameLabel);

        // 이름 입력 필드
        nameField = new JTextField();
		nameField.setFont(new Font("Pretendard", Font.PLAIN, 18));
        nameField.setBounds((frameWidth - 420) / 2 + 90, 400, 300, 40);
        panel.add(nameField);

        // 버튼 크기 및 위치 공통 변수
        int buttonWidth = 250;
        int buttonHeight = 50;
        int centerX = (frameWidth - buttonWidth) / 2;

        // 로그인 버튼
        JButton loginButton = new JButton("로그인 하기");
		loginButton.setFont(new Font("Pretendard", Font.BOLD, 18));
        loginButton.setBackground(new Color(250, 240, 230));;
        loginButton.setForeground(new Color(13, 39, 84));
        loginButton.setBounds(centerX, 550, buttonWidth, buttonHeight);
        panel.add(loginButton);


        loginButton.addActionListener(e -> {
            String empId = employeeIdField.getText().trim();
            String name = nameField.getText().trim();

            // ✅ 관리자 계정인 경우
            if (empId.equals("1111") && name.equals("1111")) {
                JOptionPane.showMessageDialog(null, "관리자 계정으로 로그인합니다.");
                new AdminDashboardPage().setVisible(true);
                dispose(); // 로그인 창 닫기
                return; // 일반 사용자 로그인 로직 건너뛰기
            }

            // ✅ 일반 사용자 로그인
            if (userService.validateLogin(empId, name)) {
                JOptionPane.showMessageDialog(null, "로그인 성공!");
                dispose();
                new UserStatusUI().setVisible(true); // 사용자 입력 화면
            } else {
                JOptionPane.showMessageDialog(null, "사번 또는 이름이 잘못되었습니다.");
            }
        });


//        loginButton.addActionListener(e -> {
//            new UserStatusUI().setVisible(true);
//            dispose();
//        });




        // 회원가입 버튼
        JButton signUpButton = new JButton("회원가입 하기");
		signUpButton.setFont(new Font("Pretendard", Font.BOLD, 18));
        signUpButton.setBackground(new Color(250, 240, 230));;
        signUpButton.setForeground(new Color(13, 39, 84));
        signUpButton.setBounds(centerX, 650, buttonWidth, buttonHeight);
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
