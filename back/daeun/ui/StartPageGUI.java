package ui;

import model.*;
import service.RoutineRecommender;
import service.TimeEstimator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StartPageGUI extends JFrame {
    public StartPageGUI() {
        setTitle("오늘 하루 상태 입력");
        setSize(500, 600);
        setLayout(new GridLayout(0, 1));

        JComboBox<String> moodBox = new JComboBox<>(new String[] {"🤩 아주 좋음", "🙂 좋음", "😐 보통", "😫 안 좋음"});
        add(new JLabel("오늘의 기분은?"));
        add(moodBox);

        JSlider energySlider = new JSlider(0, 100, 50);
        energySlider.setMajorTickSpacing(25);
        energySlider.setPaintTicks(true);
        energySlider.setPaintLabels(true);
        add(new JLabel("오늘 남은 활력은 어느 정도예요?"));
        add(energySlider);

        JRadioButton alone = new JRadioButton("혼자 있고 싶어요");
        JRadioButton withPeople = new JRadioButton("사람을 만나고 싶어요", true);
        ButtonGroup peopleGroup = new ButtonGroup();
        peopleGroup.add(alone);
        peopleGroup.add(withPeople);
        add(new JLabel("퇴근 후 사람과 함께하고 싶으신가요?"));
        add(alone);
        add(withPeople);

        JRadioButton auto = new JRadioButton("자동 예측할게요");
        JRadioButton manual = new JRadioButton("직접 입력할게요", true);
        JTextField timeField = new JTextField("18:45");
        ButtonGroup timeGroup = new ButtonGroup();
        timeGroup.add(auto);
        timeGroup.add(manual);
        add(new JLabel("오늘의 일과는 몇 시에 끝나나요?"));
        add(auto);
        add(manual);
        add(timeField);

        JButton next = new JButton("다음");
        add(next);

        next.addActionListener(e -> {
            Mood mood = Mood.values()[moodBox.getSelectedIndex()];
            Energy energy = (energySlider.getValue() < 34) ? Energy.LOW : (energySlider.getValue() < 67) ? Energy.MEDIUM : Energy.HIGH;
            boolean wantPeople = withPeople.isSelected();
            boolean autoSelected = auto.isSelected();

            UserInput input = new UserInput(mood, energy, wantPeople, autoSelected);
            if (!autoSelected) {
                input.manualEndTime = timeField.getText();
                dispose();
                new RoutineResultPageGUI(input).setVisible(true);
            } else {
                dispose();
                new AutoEstimatePageGUI(input).setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}