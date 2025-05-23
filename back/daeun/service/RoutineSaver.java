package service;

import model.RoutineCard;

import java.io.*;
import java.util.*;

public class RoutineSaver {
    public static void save(RoutineCard routine, Map<String, String> selectedDetails) {
        System.out.println("[저장된 루틴]");
        System.out.println("루틴 제목: " + routine.title);
        for (String step : routine.steps) System.out.println("- " + step);
        System.out.println("[세부 선택 항목]");
        for (Map.Entry<String, String> entry : selectedDetails.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        try (FileWriter writer = new FileWriter("final_routine.txt", true)) {
            writer.write("루틴 제목: " + routine.title + "\n");
            for (String step : routine.steps) writer.write("- " + step + "\n");
            writer.write("세부 항목:\n");
            for (Map.Entry<String, String> entry : selectedDetails.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.write("--------------------------\n");
        } catch (IOException e) {
            System.err.println("루틴 저장 실패: " + e.getMessage());
        }
    }

    public static List<String> loadAll() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("final_routine.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("불러오기 실패: " + e.getMessage());
        }
        return lines;
    }
}
