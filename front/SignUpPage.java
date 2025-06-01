import javax.swing.*;
import java.awt.*;

public class SignUpPage extends JFrame {

    public SignUpPage() {
        setTitle("회원가입");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // 전체 화면
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(13, 39, 84));
        setLayout(null);

        int fieldWidth = 250;
        int fieldHeight = 30;
        int labelWidth = 80;
        int startX = 500;
        int startY = 150;
        int gap = 50;

        JLabel title = new JLabel("회원가입");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(startX, 60, 300, 50);
        add(title);

        // 라벨 + 텍스트필드 배열로 구성
        String[] labels = {"이름", "나이", "주소", "이메일", "사번"};
        JTextField[] fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ":");
            label.setForeground(Color.WHITE);
            label.setBounds(startX, startY + i * gap, labelWidth, fieldHeight);
            add(label);

            JTextField textField = new JTextField();
            textField.setBounds(startX + labelWidth + 10, startY + i * gap, fieldWidth, fieldHeight);
            add(textField);

            fields[i] = textField;
        }

        JButton completeBtn = new JButton("가입 완료");
        completeBtn.setBounds(startX, startY + labels.length * gap + 20, fieldWidth + labelWidth + 10, 40);
        completeBtn.setBackground(new Color(255, 255, 255));
        completeBtn.setForeground(new Color(13, 39, 84));
        completeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        add(completeBtn);

        completeBtn.addActionListener(e -> {
            String name = fields[0].getText();
            String age = fields[1].getText();
            String address = fields[2].getText();
            String email = fields[3].getText();
            String empId = fields[4].getText();

            // 콘솔 출력 (DB 저장 등으로 확장 가능)
            System.out.println("회원가입 완료:");
            System.out.println("이름: " + name);
            System.out.println("나이: " + age);
            System.out.println("주소: " + address);
            System.out.println("이메일: " + email);
            System.out.println("사번: " + empId);

            // 다음 페이지로 이동 (예: 루틴 예측 화면)
            dispose();
            new RoutineManagementPage(); // 루틴 페이지로 연결
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
