package mycity.com.citymanage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

import mycity.com.citymanage.R;

/**
 * Created by Administrator on 2018/1/8.
 */

public class BaiduMapLocation extends Activity{
    // 百度地图控件
    private MapView mMapView = null;
    // 百度地图对象
    private BaiduMap bdMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.baidumaplocation);
        mMapView=(MapView)findViewById(R.id.bmapView);
    }
}
