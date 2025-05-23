package ui;

import controller.RoutineController;
import model.RoutineCard;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RoutineConfirmPageGUI extends JFrame {
    public RoutineConfirmPageGUI(RoutineCard routine, Map<String, String> selectedDetails) {
        setTitle("최종 루틴 확인");
        setSize(500, 600);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("[선택된 루틴]\n").append(routine.title).append("\n");
        for (String step : routine.steps) sb.append("- ").append(step).append("\n");

        sb.append("\n[세부 항목 선택]\n");
        for (Map.Entry<String, String> entry : selectedDetails.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        area.setText(sb.toString());
        add(new JScrollPane(area), BorderLayout.CENTER);

        JButton closeBtn = new JButton("확인 및 저장 완료");
        closeBtn.addActionListener(e -> {
            RoutineController.saveFinalRoutine(routine, selectedDetails);
            JOptionPane.showMessageDialog(this, "루틴이 저장되었습니다. 감사합니다!", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
        add(closeBtn, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
