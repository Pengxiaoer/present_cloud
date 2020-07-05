package exception;

public class BaseException extends RuntimeException {
    private int code;
    public BaseException(String msg,ExceptionCode exceptionCode){
        super(msg);
        this.code=exceptionCode.getCode();
    }

    public String getmsg(){
        return super.getMessage();
    }

    public int getCode(){
        return code;
    }
}
