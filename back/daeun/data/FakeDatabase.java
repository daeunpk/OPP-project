package data;

import model.*;
import java.util.*;

public class FakeDatabase {
    public static List<RoutineCard> getAllRoutines() {
        return List.of(
            new RoutineCard("루틴 1 - 혼자 여유", List.of("21:25 DINNER", "22:25 CONTENT TIME", "23:45 WIND DOWN", "00:25 WRAP UP")),
            new RoutineCard("루틴 2 - 친구와 회복", List.of("21:00 DINNER", "21:45 LIGHT TALK", "22:30 HOME", "23:00 WRAP UP")),
            new RoutineCard("루틴 3 - 오늘은 논다!", List.of("21:00 MEET & EAT", "21:45 GAME TIME", "23:00 LATE NIGHT", "00:00 WRAP UP"))
        );
    }

    public static List<RoutineDetail> getRoutineDetails() {
        return List.of(
            new RoutineDetail("식사", List.of("유부우동", "버섯전골", "연어덮밥")),
            new RoutineDetail("OTT", List.of("넷플릭스 <오늘도 무사히>", "왓챠 <휴가에 뭐하지?>")),
            new RoutineDetail("스트레칭", List.of("유튜브 <10분 전신 루틴>")),
            new RoutineDetail("자기계발", List.of("10분 책 읽기", "영어 단어 암기 앱"))
        );
    }
}