package fitness24;
public class Inbox {

    // Member fields
    private String type; // notification, reminder, message, feedback, announcement
    private Instructor sender;
    private String message;

    // Constructor
    public Inbox(String type, Instructor sender, String message) {
        setType(type); // Use the setter to validate type
        this.sender = sender;
        this.message = message;
    }

    // Setter for 'type'
    public void setType(String type) {
        if (type.equalsIgnoreCase("notification") ||
            type.equalsIgnoreCase("reminder") ||
            type.equalsIgnoreCase("message") ||
            type.equalsIgnoreCase("feedback") ||
            type.equalsIgnoreCase("announcement")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid type. Must be one of: notification, reminder, message, feedback, announcement.");
        }
    }

    // Setters for specific types
    public void setNotificationType() {
        this.type = "notification";
    }

    public void setReminderType() {
        this.type = "reminder";
    }

    public void setMessageType() {
        this.type = "message";
    }

    public void setFeedbackType() {
        this.type = "feedback";
    }

    public void setAnnouncementType() {
        this.type = "announcement";
    }

    // Getter for 'type'
    public String getType() {
        return type;
    }

    // Setter for 'sender'
    public void setSender(Instructor sender) {
        this.sender = sender;
    }

    // Getter for 'sender'
    public Instructor getSender() {
        return sender;
    }

    // Setter for 'message'
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for 'message'
    public String getMessage() {
        return message;
    }
}
