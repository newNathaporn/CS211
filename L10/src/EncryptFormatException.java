
public class EncryptFormatException extends RuntimeException {

    public EncryptFormatException() {
        super("Incorrect encrypt format file.");
    }

    public EncryptFormatException(String msg) {
        super(msg);
    }

}
