package task1;

public class IdException extends Exception{

    static final long serialVersionUID = 7818375828146090145L; // 序列化的版本号  与序列化操作有关系

    public IdException() {
    }

    public IdException(String message) {
        super(message);
    }
}
