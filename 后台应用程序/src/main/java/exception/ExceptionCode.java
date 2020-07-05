package exception;

public enum ExceptionCode {
    REQ_PARAM_ERR(10001,"请求参数异常"),
    NOT_FOUND_ERR(10004,"无结果");

    private int code;

    ExceptionCode(int code,String msg){
        this.code=code;
    }

    public int getCode(){
        return code;
    }

}
