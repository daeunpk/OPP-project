package ui;

import model.*;
import service.RoutineRecommender;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RoutineResultPageGUI extends JFrame {
    private JTextArea area;
    private List<RoutineCard> recommended;
    private UserInput input;

    public RoutineResultPageGUI(UserInput input) {
        this.input = input;
        this.recommended = RoutineRecommender.recommend(input);

        setTitle("오늘의 루틴 추천");
        setSize(600, 400);
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setFont(new Font("Pretendard", Font.PLAIN, 14));
        area.setEditable(false);
        add(new JScrollPane(area), BorderLayout.CENTER);

        JButton selectBtn = new JButton("이 루틴 선택");
        JButton retryBtn = new JButton("다시 추천");

        JPanel bottom = new JPanel();
        bottom.add(selectBtn);
        bottom.add(retryBtn);
        add(bottom, BorderLayout.SOUTH);

        showRoutines();

        selectBtn.addActionListener(e -> {
            dispose();
            new RoutineDetailPageGUI(recommended.get(0)).setVisible(true);
        });

        retryBtn.addActionListener(e -> {
            recommended = RoutineRecommender.recommend(input);
            showRoutines();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showRoutines() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recommended.size(); i++) {
            RoutineCard r = recommended.get(i);
            sb.append("\n[루틴 ").append(i + 1).append("] ").append(r.title).append("\n");
            for (String step : r.steps) sb.append("- ").append(step).append("\n");
        }
        area.setText(sb.toString());
    }
}