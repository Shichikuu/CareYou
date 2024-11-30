package CareYou.careyou.dto;

public class Response<T> {
    private boolean success;
    private String message;
    private String field;
    private T payload;

    // Constructors
    public Response(boolean success, String message, String field, T payload) {
        this.success = success;
        this.message = message;
        this.field = field;
        this.payload = payload;
    }

    // Getters and setters
    // ...
}
