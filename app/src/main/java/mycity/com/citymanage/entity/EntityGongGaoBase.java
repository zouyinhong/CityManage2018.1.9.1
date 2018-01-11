package mycity.com.citymanage.entity;

import java.util.List;

/**
 * class EntityGongGaoBase
 * <p/>
 * Created by Kyle on 2017/4/8.
 */
public class EntityGongGaoBase {
    int result;
    String msg;
    List<EntityGongGao> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<EntityGongGao> getData() {
        return data;
    }

    public void setData(List<EntityGongGao> data) {
        this.data = data;
    }
}
