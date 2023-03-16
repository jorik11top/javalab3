import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidCheck implements ValidData {
    private DateTimeFormatter dateFormatter;

    public DateValidCheck(DateTimeFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            this.dateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}