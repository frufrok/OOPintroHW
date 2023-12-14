package Task1;

import java.time.LocalDateTime;

public class HistoryRecord {
    private final LocalDateTime dateTime;
    private final String operation;

    public HistoryRecord(String operation) {
        this.dateTime = LocalDateTime.now();
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.dateTime.toString(), this.operation);
    }
}
