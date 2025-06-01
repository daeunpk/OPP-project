import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SettingsPage extends JFrame {

    public SettingsPage() {
        setTitle("설정");
        UIStyle.applyFrameStyle(this);

        JLabel title = new JLabel("사용자 설정 및 히스토리");
        title.setBounds(100, 50, 400, 40);
        UIStyle.styleTitleLabel(title);
        add(title);

        JButton adminBtn = new JButton("관리자 화면");
        adminBtn.setBounds(100, 200, 200, 40);
        UIStyle.styleButton(adminBtn);
        add(adminBtn);

        adminBtn.addActionListener(e -> {
            dispose();
            new AdminDashboardPage();
        });

        setVisible(true);
    }
}

