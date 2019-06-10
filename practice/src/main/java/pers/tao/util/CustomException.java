package pers.tao.util;

/**
 * 自定义异常
 *
 * @author: chenyutao
 * @date: 2019-06-09 14:18
 */
public class CustomException extends RuntimeException{
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

}
