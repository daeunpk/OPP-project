// DetailRecommender.java

import java.util.*;

public class DetailRecommender {

    private static final Map<String, List<String>> detailMap = new HashMap<>();

    static {
        detailMap.put("식사", Arrays.asList("부대찌개", "순두부찌개", "소불고기 정식", "유부우동", "버섯전골"));
        detailMap.put("OTT", Arrays.asList("넷플릭스 <무브 투 헤븐>", "왓챠 <너의 시간 속으로>", "웨이브 <약한 영웅 Class 1>"));
        detailMap.put("음악", Arrays.asList("Lo-Fi 재생목록 ‘Rainy Night Jazz’", "잔잔한 클래식 모음", "기분 좋은 시티팝"));
        detailMap.put("독서", Arrays.asList("1일 5분 에세이 - 김수현", "아주 작은 습관의 힘", "퇴근 후 1시간"));
        detailMap.put("휴식", Arrays.asList("라벤더 입욕제 🛀", "핫팩 찜질", "차분한 명상 유튜브 추천"));
    }

    public static String recommendDetail(String category) {
        List<String> options = detailMap.getOrDefault(category, Collections.singletonList("추천 항목 없음"));
        Collections.shuffle(options);
        return options.get(0);
    }
}
