package ui;

import model.*;
import service.RoutineRecommender;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RoutineDetailPageGUI extends JFrame {
    private RoutineCard selectedRoutine;
    private Map<String, JComboBox<String>> selectionBoxes = new HashMap<>();

    public RoutineDetailPageGUI(RoutineCard routine) {
        this.selectedRoutine = routine;

        setTitle("세부 루틴 추천");
        setSize(500, 600);
        setLayout(new GridLayout(0, 1));

        add(new JLabel("선택된 루틴: " + routine.title));

        for (RoutineDetail detail : RoutineRecommender.getDetails()) {
            add(new JLabel("[" + detail.category + "] 선택하세요:"));
            JComboBox<String> box = new JComboBox<>(detail.options.toArray(new String[0]));
            selectionBoxes.put(detail.category, box);
            add(box);
        }

        JButton confirm = new JButton("최종 루틴 확정");
        add(confirm);

        confirm.addActionListener(e -> {
            Map<String, String> selections = new HashMap<>();
            for (Map.Entry<String, JComboBox<String>> entry : selectionBoxes.entrySet()) {
                selections.put(entry.getKey(), (String) entry.getValue().getSelectedItem());
            }
            dispose();
            new RoutineConfirmPageGUI(selectedRoutine, selections).setVisible(true);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}