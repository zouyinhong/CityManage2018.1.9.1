package mycity.com.citymanage.net;

/**
 * Created by kyle on 16/11/14.
 *
 * 网络数据返回时的一些包装，默认返回的数据是json
 */
public class Result {

    private String message;
    private int result;
    private String data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", data='" + data + '\'' +
                '}';
    }

    //    private String message;
//    @SerializedName("data")
//    private String body;
//    private int code;
//    @SerializedName("result")
//    private boolean success;
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    @Override
//    public String toString(){
//        return "success:"+Boolean.toString(success)+" message:"+message+
//                " code:"+Integer.toString(code)+" body:"+body;
//    }
}
