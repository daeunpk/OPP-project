import javax.swing.*;
import java.awt.*;

public class RoutineDonePage extends JFrame {

    public RoutineDonePage() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("전송 완료");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(13, 39, 84));

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

        // 체크 아이콘
        JPanel circleCheck = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillOval(0, 0, getWidth(), getHeight());
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
        circleCheck.setOpaque(false);

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
            new MainPage().setVisible(true);
        });

        centerPanel.add(completeLabel);
        centerPanel.add(circleCheck);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(backButton);
        
        // 캐릭터 애니메이션 패널 추가
        centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        MovingCharacterPanel charPanel = new MovingCharacterPanel();
        charPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(charPanel);

        add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // 움직이는 캐릭터 패널 (CharacterTestView1 코드 반영)
    class MovingCharacterPanel extends JPanel implements Runnable {
        private int char1X = 50, char1Y = 50;
        private int char1DX = 2, char1DY = 1;
        private int char2X = 200, char2Y = 80;
        private int char2DX = -3, char2DY = 2;
        private Thread animator;
        private boolean running = true;

        public MovingCharacterPanel() {
            setOpaque(false);
            setPreferredSize(new Dimension(600, 200));
            animator = new Thread(this);
            animator.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            drawMascot(g2, char1X, char1Y, false); // 기본 캐릭터
            drawMascot(g2, char2X, char2Y, true);  // 치어리더
        }

        private void drawMascot(Graphics2D g2, int x, int y, boolean cheerLeader) {
            Color mainBlue = new Color(124, 181, 236);
            Color yellow = new Color(255, 200, 40);

            // 몸통(삼각형 치마)
            g2.setColor(mainBlue);
            int[] bodyX = {x + 40, x + 15, x + 65};
            int[] bodyY = {y + 40, y + 100, y + 100};
            g2.fillPolygon(bodyX, bodyY, 3);

            // 머리(삼각+뿔)
            g2.setColor(mainBlue);
            int[] headX = {x + 40, x + 0, x + 80};
            int[] headY = {y + 0, y + 60, y + 60};
            g2.fillPolygon(headX, headY, 3);
            // 뿔
            g2.fillRect(x + 5, y + 25, 12, 8);
            g2.fillRect(x + 62, y + 25, 12, 8);
            g2.fillRect(x + 18, y + 10, 8, 12);
            g2.fillRect(x + 54, y + 10, 8, 12);

            // 얼굴
            g2.setColor(Color.WHITE);
            g2.fillOval(x + 20, y + 23, 40, 35);

            // S 마크
            g2.setColor(yellow);
            g2.setFont(new Font("Dialog", Font.BOLD, 22));
            g2.drawString("S", x + 32, y + 88);

            // 팔
            g2.setColor(mainBlue);
            g2.setStroke(new BasicStroke(4));
            if (!cheerLeader) {
                // 기본 캐릭터
                g2.drawLine(x + 32, y + 66, x + 7, y + 85);
                g2.drawLine(x + 48, y + 66, x + 73, y + 85);
            } else {
                // 치어리더: 팔 위로, 폼폼
                g2.drawLine(x + 18, y + 75, x - 2, y + 55);
                g2.drawLine(x + 62, y + 75, x + 82, y + 55);
                g2.setColor(yellow);
                g2.fillOval(x - 8, y + 48, 22, 22);
                g2.fillOval(x + 66, y + 48, 22, 22);
            }

            // 다리
            g2.setColor(mainBlue);
            g2.setStroke(new BasicStroke(4));
            if (!cheerLeader) {
                g2.drawLine(x + 34, y + 90, x + 34, y + 120);
                g2.drawLine(x + 46, y + 90, x + 46, y + 120);
            } else {
                // 치어리더: 한쪽 다리만
                g2.drawLine(x + 34, y + 90, x + 53, y + 120);
				g2.drawLine(x + 46, y + 90, x + 55, y + 120);
            }

            // 눈
            g2.setColor(new Color(13, 39, 84));
            g2.fillOval(x + 30, y + 35, 6, 10);
            g2.fillOval(x + 50, y + 35, 6, 10);

            // 입
            g2.setStroke(new BasicStroke(2));
            if (!cheerLeader) {
                g2.drawArc(x + 33, y + 44, 18, 10, 190, 160);
            } else {
                g2.drawArc(x + 35, y + 44, 14, 10, 190, 160);
            }
        }

        @Override
        public void run() {
            while (running) {
                char1X += char1DX;
                char1Y += char1DY;
                if (char1X <= 0 || char1X >= getWidth() - 100) char1DX = -char1DX;
                if (char1Y <= 0 || char1Y >= getHeight() - 150) char1DY = -char1DY;

                char2X += char2DX;
                char2Y += char2DY;
                if (char2X <= 0 || char2X >= getWidth() - 100) char2DX = -char2DX;
                if (char2Y <= 0 || char2Y >= getHeight() - 150) char2DY = -char2DY;

                repaint();
                try { Thread.sleep(20); } 
                catch (InterruptedException e) { running = false; }
            }
        }

        public void stopAnimation() {
            running = false;
            if (animator != null) animator.interrupt();
        }
    }
}
