package mycity.com.citymanage.net;

import java.io.File;

/**
 * Created by kyle on 16/11/14.
 */
public interface Downloadable{

    /**
     * 获取下载目标文件位置
     * @return 目标文件
     */
    File getTargetFile();

    void setTargetFile(File f);
}
