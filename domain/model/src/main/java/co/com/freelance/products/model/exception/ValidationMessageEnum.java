package co.com.freelance.products.model.exception;

public enum ValidationMessageEnum {
    UNKNOWN_EXCEPTION("UnknownException.message"),
    NOT_FOUND_EXCEPTION("NotFoundException.message");

    private final String message;

    ValidationMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
