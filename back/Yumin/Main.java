import java.util.List;
import java.util.Map;          // 🔹 Map 추가
import java.util.HashMap;      // 🔹 HashMap 추가
import java.time.LocalTime;
import java.time.LocalDate;    // 🔹 LocalDate 추가


public class Main {
    public static void main(String[] args) {
        // 1. 루틴 불러오기
        RoutineRepository repo = new RoutineRepository();
        List<RoutineCard> routines = repo.getAll();

        if (routines == null || routines.isEmpty()) {
            System.out.println("❌ 루틴이 없습니다!");
            return;
        }

        System.out.println("💡 불러온 루틴 목록:");
        for (RoutineCard card : routines) {
            System.out.println("📝 루틴 이름: " + card.getName());
            System.out.println("👉 설명: " + card.getDescription());
            System.out.println("📋 단계:");
            for (RoutineStep step : card.getSteps()) {
                System.out.println("  - " + step.getTime() + " " + step.getTitle() + ": " + step.getDescription());
            }
            System.out.println("-------------------------");
        }

        // 2. 퇴근 시간 예측 테스트
        System.out.println("\n🕒 퇴근 시간 예측 테스트:");
        LocalTime predicted = TimeEstimator.estimateLeaveTime(
            3, 2, true, 2, 1
        );
        System.out.println("예상 퇴근 시간: " + predicted);

        // 3. 세부 루틴 추천 테스트
        System.out.println("\n🎯 세부 루틴 추천 테스트:");
        String food = DetailRecommender.recommendDetail("식사");
        String music = DetailRecommender.recommendDetail("음악");
        System.out.println("🍽 식사 추천: " + food);
        System.out.println("🎧 음악 추천: " + music);

        // 4. 루틴 저장 테스트
        System.out.println("\n💾 루틴 저장 테스트:");
        Map<String, String> selected = new HashMap<>();
        selected.put("식사", DetailRecommender.recommendDetail("식사"));
        selected.put("음악", DetailRecommender.recommendDetail("음악"));

        FinalRoutine finalRoutine = new FinalRoutine(
            LocalDate.now().toString(),
            routines.get(0), // 첫 번째 루틴을 예시로 저장
            selected
        );

        RoutineSaver.save(finalRoutine);
    }
}