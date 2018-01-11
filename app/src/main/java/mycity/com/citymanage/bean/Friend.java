package mycity.com.citymanage.bean;

import mycity.com.citymanage.activity.PinYin;

/**
 * Created by Administrator on 2017/12/28.
 */

public class Friend implements Comparable<Friend> {
    private String name;
    public   String pinyin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Friend(String name) {
        this.name = name;
        this.pinyin= PinYin.getPinYin(name);
    }


    @Override
    public int compareTo(Friend o) {
        return pinyin.compareTo(o.pinyin);
    }
}
