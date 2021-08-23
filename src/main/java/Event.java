import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * A task that stores the day and time of the event.
 */
public class Event extends Task {
    /**
     * The date of the event.
     */
    protected LocalDate date;

    /**
     * The time of the event.
     */
    protected LocalTime time;

    /**
     * A constructor used to initialize the event.
     *
     * @param description the description of the event.
     * @param date the date of the event.
     * @param time the time of the event.
     */
    protected Event(String description, LocalDate date, LocalTime time) {
        super(description);
        this.date = date;
        this.time = time;
    }

    /**
     * A constructor used to initialize the event through file input.
     *
     * @param description the description of the event.
     * @param isCompleted the state of the event.
     * @param date the date of the event.
     * @param time the time of the event.
     */
    protected Event(String description, boolean isCompleted, LocalDate date, LocalTime time) {
        super(description, isCompleted);
        this.date = date;
        this.time = time;
    }

    /**
     * A constructor used to initialize the event through file input.
     *
     * @param description the description of the event.
     * @param isCompleted the state of the event.
     * @param dayTime the day and time of the event.
     */
    protected Event(String description, boolean isCompleted, String dayTime) {
        super(description, isCompleted);
        this.dayTime = dayTime;
    }

    /**
     * Return the string representation of event.
     *
     * @return the string representation of event.
     */
    @Override
    public String toString() {
        String str = "[E]" + super.toString() + " (at: " + this.date.format(DateTimeFormatter.ofPattern("d/M/yyyy"));
        str += this.time != null ? " " + this.time + ")" : ")";
        return str;
    }

    /**
     * Return the string representation of event for file input/output.
     *
     * @return the string representation of event for file input/output.
     */
    @Override
    public String fileFormat() {
        String displayCompletion = this.isCompleted ? "1" : "0";
        String str = String.format("%s | %s | %s | %s", "E", displayCompletion, this.description,
                this.date.format(DateTimeFormatter.ofPattern("d/M/yyyy")));
        str += this.time != null ? " | " + this.time : "";
        return str;
    }

    /**
     * Return the string representation of event for file input/output.
     *
     * @return the string representation of event for file input/output.
     */
    @Override
    public String fileFormat() {
        String displayCompletion = this.isCompleted ? "1" : "0";
        return String.format("%s | %s | %s | %s", "T", displayCompletion, this.description, this.dayTime);
    }
}
