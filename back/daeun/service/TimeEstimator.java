// ✅ service/TimeEstimator.java
package service;

public class TimeEstimator {

    /**
     * 입력받은 요소를 기반으로 퇴근 시간을 예측합니다.
     * 기준 시간은 18:00 (오후 6시)이며,
     * 추가 소요 시간은 다음 규칙에 따라 계산됩니다:
     *
     * - 업무 개수 × 30분
     * - 업무 강도 × 3분
     * - 회의 수 × 25분
     * - 상사의 기분(1~5) × 10분 (숫자가 클수록 나쁨)
     */
    public static String estimate(int taskCount, int taskIntensity, int meetingCount, int bossMood) {
        int additionalMinutes =
            (taskCount * 30) +
            (taskIntensity * 3) +
            (meetingCount * 25) +
            (bossMood * 10);

        int baseHour = 18; // 오후 6시 기준
        int totalMinutes = baseHour * 60 + additionalMinutes;

        int hour = totalMinutes / 60;
        int minute = totalMinutes % 60;

        return String.format("%02d:%02d", hour, minute);
    }

    // ✅ 테스트용 메인
    public static void main(String[] args) {
        String result = estimate(3, 6, 2, 4); // 업무3, 강도6, 회의2, 상사기분4
        System.out.println("예상 퇴근 시각: " + result);
    }
}
