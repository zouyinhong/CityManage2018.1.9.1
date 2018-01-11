package mycity.com.citymanage.net;

/**
 * Created by kyle on 16/11/14.
 */
public interface Listener {

    void onResponseListener(String result);

    void onErrorListener(String error);
}
