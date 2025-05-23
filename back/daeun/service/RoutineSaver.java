// ✅ service/RoutineSaver.java (불러오기 기능 추가)
package service;

import model.RoutineCard;

import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

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

        try (FileWriter jsonWriter = new FileWriter("final_routine.json", true)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("title", routine.title);
            jsonMap.put("steps", routine.steps);
            jsonMap.put("details", selectedDetails);
            jsonWriter.write(gson.toJson(jsonMap));
            jsonWriter.write(",\n");
        } catch (IOException e) {
            System.err.println("JSON 저장 실패: " + e.getMessage());
        }
    }

    public static List<Map<String, Object>> loadAll() {
        List<Map<String, Object>> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("final_routine.json"))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            String jsonData = "[" + json.toString().replaceAll(",\\s*$", "") + "]";
            Gson gson = new Gson();
            result = gson.fromJson(jsonData, new TypeToken<List<Map<String, Object>>>() {}.getType());
        } catch (IOException e) {
            System.err.println("불러오기 실패: " + e.getMessage());
        }
        return result;
    }
}
