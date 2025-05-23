import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.time.LocalDate;

public class RoutineSaver {

    public static void save(FinalRoutine finalRoutine) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String fileName = "saved/" + finalRoutine.getDate() + "_routine.json";
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), finalRoutine);
            System.out.println("✅ 루틴이 저장되었습니다: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
