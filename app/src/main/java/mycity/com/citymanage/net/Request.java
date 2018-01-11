package mycity.com.citymanage.net;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求体<br/>
 * 每个任务都是不同的，（NetQueue）会根据属性来配置请求，调整请求开始完成或失败后不同的事件
 */
public class Request implements Comparable {
    private int type;
    private boolean sFile;
    private boolean hadRootAddress; //是否已加入根地址
    private boolean useFactory; //是否使用预设值
    private String method;
    private String mUrl;
    private Downloadable mDownloadable;
    private Listener mListener;
    private Map<String,String> mParams;
    private Map<String,File> mFiles;



    public Request(String url){
        this("POST",url);
    }

    public Request(){
        this("");
    }

    public Request(String method, String mUrl){
        this(method, mUrl, NetQueue.TYPE_INDEPEND);
    }

    public Request(String method, String mUrl, int type){
        this.method=method.toUpperCase();
        this.mUrl = mUrl;
        this.type=type;
        useFactory=true;
    }

    @Override
    public int compareTo(Object another){
        if(another instanceof Request)
            return ((Request) another).getUrl().equals(mUrl)?1:0;
        return 0;
    }

    /**
     * 简易地添加请求参数
     * @param key
     * @param value
     */
    public Request put(String key, String value){
        if(mParams==null)
            mParams=new HashMap<>();
        mParams.put(key, value);
        return this;
    }
    public Request put(String key, int value){
        return put(key, Integer.toString(value));
    }

    /**
     * 简易地添加请求参数
     * @param params
     * @return
     */
    public Request put(Map<String,String> params){
        if(mParams==null)
            mParams=params;
        else
            mParams.putAll(params);
        return this;
    }


    public Request put(String key, File file){
        if(mFiles==null)
            mFiles=new HashMap<>();
        mFiles.put(key,file);
        return this;
    }


    public Request putFile(Map<String,File> fileParams){
        if(mFiles==null)
            mFiles=fileParams;
        else
            mFiles.putAll(fileParams);
        return this;
    }

    /**
     * 参数递增
     * @param key
     * @param count
     */
    public void increment(String key, int count){
        if(!checkNumberParams(key))
            return;
        String value=mParams.get(key);
        mParams.put(key, Integer.toString(Integer.parseInt(value) + count));

    }

    /**
     * 参数递减
     * @param key
     * @param count
     */
    public void decrease(String key, int count){
        if(!checkNumberParams(key))
            return;
        String value=mParams.get(key);
        mParams.put(key, Integer.toString(Integer.parseInt(value)-count));
    }

    private boolean checkNumberParams(String key){
        if(mParams==null){
            mParams=new HashMap<>();
            mParams.put(key,"0");
            return false;
        }
        if(!mParams.containsKey(key)) {
            mParams.put(key,"0");
            return false;
        }
        try{
            Integer.parseInt(mParams.get(key));
            return true;
        }catch (NumberFormatException e){
            mParams.put(key,"0");
            return false;
        }
    }

    public Map<String,String> getParams(){
        return mParams;
    }

    public void setParams(Map<String,String> params){
        mParams=params;
    }

    public void setFiles(Map<String,File> files){
        mFiles=files;
    }

    public Map<String,File> getFiles(){
        return mFiles;
    }

    public int getType(){
        return type;
    }

    public void setUrl(String mUrl){
        this.mUrl = mUrl;
    }

    public Request setListener(Listener l){
        mListener=l;
        return this;
    }

    public Listener getListener(){
        return mListener;
    }

    public String getUrl(){return mUrl;}

    public String getMethod(){
        return method;
    }

    public Request setMethod(String method){
        this.method=method.toUpperCase();
        return this;
    }

    public boolean isFile() {
        return sFile;
    }

    public void setFile(boolean sFile) {
        this.sFile = sFile;
    }

    public Request setDownloadable(Downloadable d){
        mDownloadable=d;
        return this;
    }

    public Downloadable getDownloadable(){
        return mDownloadable;
    }

    public boolean isUseFactory() {
        return useFactory;
    }

    public Request setUseFactory(boolean useFactory) {
        this.useFactory = useFactory;
        return this;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isHadRootAddress() {
        return hadRootAddress;
    }

    public void setHadRootAddress(boolean hadRootAddress) {
        this.hadRootAddress = hadRootAddress;
    }

    public boolean downloadable(){
        return mDownloadable!=null&&mDownloadable.getTargetFile()!=null&&mDownloadable.getTargetFile().exists();
    }
}