// RoutineRepository.java

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;

public class RoutineRepository {

    private List<RoutineCard> routineCards;

    public RoutineRepository() {
        loadRoutines();
    }

    private void loadRoutines() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileInputStream input = new FileInputStream("data/routines.json"); // ✅ 여기 경로 수정됨
            routineCards = mapper.readValue(input, new TypeReference<List<RoutineCard>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RoutineCard> getAll() {
        return routineCards;
    }

    public List<RoutineCard> getShuffled() {
        Collections.shuffle(routineCards);
        return routineCards;
    }
}
