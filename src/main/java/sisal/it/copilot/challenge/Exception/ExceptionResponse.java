package sisal.it.copilot.challenge.Exception;

public class ExceptionResponse {

    private String message;
    private Long timestamp;

    public ExceptionResponse(String message, Long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }



    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
