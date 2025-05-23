// TimeEstimator.java

import java.time.LocalTime;

public class TimeEstimator {

    // 기본 퇴근 시간 (18:00)
    private static final LocalTime BASE_TIME = LocalTime.of(18, 0);

    public static LocalTime estimateLeaveTime(int taskCount, int intensity, boolean hasMeeting, int meetingCount, int bossMoodScore) {
        int totalMinutes = 0;

        // 1. 업무 개수 기준: 1개당 20분
        totalMinutes += taskCount * 20;

        // 2. 강도 기준: 1~5 → 1당 10분
        totalMinutes += intensity * 10;

        // 3. 회의 여부
        if (hasMeeting) {
            totalMinutes += meetingCount * 15; // 회의 1건당 15분
        }

        // 4. 상사 기분 (1~5): 낮을수록 시간 ↑
        // 3 → 변화 없음, 1~2 → 시간 추가, 4~5 → 감점 없음
        if (bossMoodScore <= 2) {
            totalMinutes += 20;
        }

        return BASE_TIME.plusMinutes(totalMinutes);
    }
}
