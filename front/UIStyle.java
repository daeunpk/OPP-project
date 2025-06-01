import javax.swing.*;
import java.awt.*;

public class UIStyle {

    // NAVY 배경 색상
    public static final Color BACKGROUND_COLOR = new Color(13, 39, 84);
    public static final Color FONT_COLOR = Color.WHITE;
    public static final Font DEFAULT_FONT = new Font("dialog", Font.PLAIN, 18);
    public static final Font TITLE_FONT = new Font("dialog", Font.BOLD, 28);

    // 전체 프레임 설정 공통 메서드
    public static void applyFrameStyle(JFrame frame) {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // 전체화면
        frame.getContentPane().setBackground(BACKGROUND_COLOR);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 공통 텍스트 스타일 적용
    public static void styleLabel(JLabel label) {
        label.setForeground(FONT_COLOR);
        label.setFont(DEFAULT_FONT);
    }

    public static void styleTitleLabel(JLabel label) {
        label.setForeground(FONT_COLOR);
        label.setFont(TITLE_FONT);
    }

    public static void styleButton(JButton button) {
        button.setForeground(FONT_COLOR);
        button.setBackground(new Color(25, 25, 112)); // 버튼도 진한 파랑
        button.setFont(DEFAULT_FONT);
    }

    public static void styleTextField(JTextField field) {
        field.setForeground(FONT_COLOR);
        field.setBackground(new Color(30, 30, 60));
        field.setFont(DEFAULT_FONT);
        field.setCaretColor(Color.WHITE);
    }

    public static void styleTextArea(JTextArea area) {
        area.setForeground(FONT_COLOR);
        area.setBackground(new Color(30, 30, 60));
        area.setFont(DEFAULT_FONT);
        area.setCaretColor(Color.WHITE);
    }
}
