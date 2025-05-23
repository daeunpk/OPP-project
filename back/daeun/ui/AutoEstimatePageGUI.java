package ui;

import model.UserInput;
import service.TimeEstimator;

import javax.swing.*;
import java.awt.*;

public class AutoEstimatePageGUI extends JFrame {
    public AutoEstimatePageGUI(UserInput input) {
        setTitle("퇴근 시간 예측 입력");
        setSize(500, 500);
        setLayout(new GridLayout(0, 1));

        JTextField taskCountField = new JTextField("3");
        JSlider taskIntensitySlider = new JSlider(0, 10, 5);
        taskIntensitySlider.setPaintTicks(true);
        taskIntensitySlider.setPaintLabels(true);

        JRadioButton hasMeeting = new JRadioButton("있어요", true);
        JRadioButton noMeeting = new JRadioButton("없어요");
        ButtonGroup meetingGroup = new ButtonGroup();
        meetingGroup.add(hasMeeting);
        meetingGroup.add(noMeeting);
        JComboBox<String> meetingCountBox = new JComboBox<>(new String[] {"1", "2", "3", "4"});

        JRadioButton boss1 = new JRadioButton("🤩");
        JRadioButton boss2 = new JRadioButton("🙂", true);
        JRadioButton boss3 = new JRadioButton("😐");
        JRadioButton boss4 = new JRadioButton("😫");
        JRadioButton boss5 = new JRadioButton("😡");
        ButtonGroup bossGroup = new ButtonGroup();
        bossGroup.add(boss1); bossGroup.add(boss2); bossGroup.add(boss3); bossGroup.add(boss4); bossGroup.add(boss5);

        add(new JLabel("남아 있는 업무는 몇 개인가요?"));
        add(taskCountField);
        add(new JLabel("업무 강도는 어느 정도인가요?"));
        add(taskIntensitySlider);
        add(new JLabel("남아 있는 회의가 있나요?"));
        add(hasMeeting); add(noMeeting); add(meetingCountBox);
        add(new JLabel("오늘 상사의 기분은 어떤가요?"));
        add(boss1); add(boss2); add(boss3); add(boss4); add(boss5);

        JButton nextBtn = new JButton("루틴 추천 보기");
        add(nextBtn);

        nextBtn.addActionListener(e -> {
            input.taskCount = Integer.parseInt(taskCountField.getText());
            input.taskIntensity = taskIntensitySlider.getValue();
            input.meetingCount = hasMeeting.isSelected() ? Integer.parseInt((String) meetingCountBox.getSelectedItem()) : 0;
            input.bossMood = boss1.isSelected() ? 1 : boss2.isSelected() ? 2 : boss3.isSelected() ? 3 : boss4.isSelected() ? 4 : 5;

            input.manualEndTime = TimeEstimator.estimate(input.taskCount, input.taskIntensity, input.meetingCount, input.bossMood);
            dispose();
            new RoutineResultPageGUI(input).setVisible(true);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}