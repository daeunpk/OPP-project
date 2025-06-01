import javax.swing.*;
import java.awt.*;

public class RoutineResultPage extends JFrame {
    private JRadioButton jsonOption, txtOption;

    public RoutineResultPage() {
        setTitle("루틴 추천 결과");
        UIStyle.applyFrameStyle(this);  // 이 부분은 UIStyle 클래스 존재해야 함
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(13, 39, 84)); // NAVY

        // 레이아웃을 BorderLayout으로 고정
        setLayout(new BorderLayout());
        setBackground(new Color(13, 39, 84));
        // 타이틀
        JLabel titleLabel = new JLabel("루틴 저장 완료!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("dialog", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.NORTH);

        // 옵션 패널
        JPanel optionPanel = new JPanel(new GridLayout(2, 1));
        optionPanel.setBackground(new Color(13, 39, 84)); // 배경색도 맞추기

        jsonOption = new JRadioButton("JSON 형식으로 저장하기");
        txtOption = new JRadioButton("TXT 형식으로 저장하기");

        // 라디오 버튼 글자 색 흰색으로 설정
        jsonOption.setForeground(Color.WHITE);
        txtOption.setForeground(Color.WHITE);

        ButtonGroup group = new ButtonGroup();
        group.add(jsonOption);
        group.add(txtOption);

        jsonOption.setSelected(true); // 기본 선택

        optionPanel.add(jsonOption);
        optionPanel.add(txtOption);

        add(optionPanel, BorderLayout.CENTER);

        // 선택 완료 버튼
        JButton completeButton = new JButton("선택 완료");
        completeButton.addActionListener(e -> {
            dispose(); // 현재 창 닫기
            new RoutineDonePage(); // 다음 페이지 열기
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(completeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
