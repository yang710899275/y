package y.y.yadmin.global;

public class CustomException extends RuntimeException {
    private int code;
    private String msg;

    public CustomException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
