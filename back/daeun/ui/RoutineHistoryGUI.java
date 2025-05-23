package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import service.RoutineSaver;

public class RoutineHistoryGUI extends JFrame {
    public RoutineHistoryGUI() {
        setTitle("이전에 저장된 루틴 기록");
        setSize(600, 500);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(area);
        add(scrollPane, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeBtn = new JButton("닫기");
        closeBtn.addActionListener(e -> dispose());
        topPanel.add(closeBtn);
        add(topPanel, BorderLayout.NORTH);

        List<Map<String, Object>> history = RoutineSaver.loadAll();
        StringBuilder sb = new StringBuilder();

        if (history.isEmpty()) {
            sb.append("저장된 루틴이 없습니다.");
        } else {
            int count = 1;
            for (Map<String, Object> record : history) {
                sb.append("[루틴 ").append(count++).append("]\n");
                sb.append("제목: ").append(record.get("title")).append("\n");
                sb.append("단계:\n");
                List<?> steps = (List<?>) record.get("steps");
                for (Object step : steps) sb.append("- ").append(step).append("\n");

                sb.append("세부 항목:\n");
                Map<?, ?> details = (Map<?, ?>) record.get("details");
                for (Map.Entry<?, ?> entry : details.entrySet()) {
                    sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
                sb.append("----------------------------\n");
            }
        }

        area.setText(sb.toString());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
