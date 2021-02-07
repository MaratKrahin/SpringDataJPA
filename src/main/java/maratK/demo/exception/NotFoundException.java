package maratK.demo.exception;

public class NotFoundException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Пользователь не найден";

    public NotFoundException() {
        super(ERROR_MESSAGE);
    }
}
