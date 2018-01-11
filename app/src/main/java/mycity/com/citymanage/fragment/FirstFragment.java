package mycity.com.citymanage.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import mycity.com.citymanage.R;
import mycity.com.citymanage.activity.Acquistion;
import mycity.com.citymanage.activity.DocumentActivity;
import mycity.com.citymanage.activity.HotPush;
import mycity.com.citymanage.activity.Inspector;
import mycity.com.citymanage.activity.LeftPopupWindow;
import mycity.com.citymanage.adapter.AdapterGongGao;
import mycity.com.citymanage.adapter.ImagePaperAdapter;
import mycity.com.citymanage.config.Constant;
import mycity.com.citymanage.entity.EntityGongGao;
import mycity.com.citymanage.entity.EntityGongGaoBase;
import mycity.com.citymanage.log.DebugLog;
import mycity.com.citymanage.net.Listener;
import mycity.com.citymanage.net.NetQueue;
import mycity.com.citymanage.net.Request;


public class FirstFragment extends Activity {
    private GridView gridView;

    AdapterGongGao adapters;
    ListView ggListView;
    String imag;
    String cont = null;
    String title = null;
    String endate = null;
    private int keyBackClickCount;
    private ViewPager mviewPager;
    private Button btn_hotpush,btn_hot1,btn_hot2,btn_hot3;
    private ImageView imgLeft;
    private int from = 0;
    LeftPopupWindow leftslide;
    /**
     * 用于小圆点图片
     */
    private List<ImageView> dotViewList;
    /**
     * 用于存放轮播效果图片
     */
    private List<View> listImag = new ArrayList<View>();
    private List<View> defaultImag = new ArrayList<View>();
    private List<EntityGongGao> listdata = new ArrayList<EntityGongGao>();
    LinearLayout dotLayout;
    TextView tvgongtitle;
    TextView tvgongcont;
    TextView tvgongendDate;

    private int currentItem = 0;//当前页面

    boolean isAutoPlay = true;//是否自动轮播

    private ScheduledExecutorService scheduledExecutorService;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                mviewPager.setCurrentItem(currentItem);
            }
        }

    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);



        btn_hotpush=(Button) findViewById(R.id.btn_hotpush);
        btn_hot1=(Button) findViewById(R.id.btn_hot1);
        btn_hot2=(Button) findViewById(R.id.btn_hot2);
        btn_hot3=(Button) findViewById(R.id.btn_hot3);
        btn_hotpush.setOnClickListener(new HotPushOnClickListener());
        leftslide = new LeftPopupWindow(FirstFragment.this, from);
        imgLeft=(ImageView) findViewById(R.id.img_leftside);
        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from = mycity.com.citymanage.fragment.SlideLocation.LEFT.ordinal();
                leftslide.initPopupWindow(from);
            }
        });
        gridView = (GridView)findViewById(R.id.gridView1);
        tvgongcont = (TextView) findViewById(R.id.tv_gonggao_content);
        tvgongtitle = (TextView)findViewById(R.id.tv_gonggao_title);
        tvgongendDate = (TextView)findViewById(R.id.tv_gonggao_endDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前日期时间
        String str = formatter.format(curDate);
        tvgongendDate.setText(str);
        mviewPager = (ViewPager) findViewById(R.id.myviewPager);
        dotLayout = (LinearLayout) findViewById(R.id.dotLayout);
        dotLayout.removeAllViews();
        setGongGaoOnGetRequest();//公告数据请求
        initGridView(); //九宫格初始化。
       // setESC(); //退出登录

        if (isAutoPlay) { //公告图片自动播放
            startPlay();
        }

        initGridView(); //九宫格初始化。


    }

    private void initGridView() {

        ArrayList<HashMap<String, Object>> lst = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 6; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();

            switch (i) {

                case 0:
                    map.put("itemImage", R.mipmap.qiandao2);
                    map.put("itemText", "一键签到");
                    break;
                case 1:
                    map.put("itemImage", R.mipmap.caiji1);
                    map.put("itemText", "一键采集");
                    break;
                case 2:
                    map.put("itemImage", R.mipmap.renwu1);
                    map.put("itemText", "任务管理");
                    break;

                case 3:
                    map.put("itemImage", R.mipmap.rizhi2);
                    map.put("itemText", "风纪督察");
                    break;
                case 4:
                    map.put("itemImage", R.mipmap.kongjian1);
                    map.put("itemText", "空间系统");
                    break;
                case 5:
                    map.put("itemImage", R.mipmap.gengduo1);
                    map.put("itemText", "更多");
                    break;


                default:
                    break;
            }
            lst.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, lst, R.layout.gridview_public_textorimage, new String[]{"itemImage", "itemText"},
                new int[]{R.id.imageView_ItemImage, R.id.textView_ItemText});
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //获取每个选中的控件textview
                Object obj = gridView.getAdapter().getItem(position);
                HashMap<String, Object> map = (HashMap<String, Object>) obj;
                String str = (String) map.get("itemText");
//                TextView text = (TextView) view.findViewById(R.id.textView_ItemText);
                switch (position) {

                    case 0:
                        Intent Document = new Intent(FirstFragment.this, DocumentActivity.class);
                        startActivity(Document);
                        break;
                    case 1:
                        Intent caijiIntent = new Intent(FirstFragment.this, Acquistion.class);
                        startActivity(caijiIntent);
                        break;
                    case 2:
                       /* Intent BaoXiu = new Intent(getActivity(), GridViewBaoXiuActivity.class);
                        startActivity(BaoXiu);*/
                        break;

                    case 3:
                         Intent duchaIntent = new Intent(FirstFragment.this, Inspector.class);
                        startActivity(duchaIntent);
                        break;

                    case 4:
                       /* Intent intentEnvironment = new Intent(FirstFragment.this, WorkFragment.class);
                        startActivity(intentEnvironment);*/
                        break;
                    case 5:
                      /*  Intent intentRuler = new Intent(getActivity(), GridWaterRulerActivity.class);
                        startActivity(intentRuler);*/
                        break;

                    default:
                        break;
                }

//                Toast.makeText(getActivity(), "你选择的是：" + str, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void initView() {
        dotViewList = new ArrayList<ImageView>();

        for (int i = 0; i < listImag.size(); i++) {
            ImageView dotView = new ImageView(FirstFragment.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 10;//设置小圆点的外边距
            params.rightMargin = 10;
            params.height = 20;//设置小圆点的大小
            params.width = 20;

            if (i == 0) {
                dotView.setBackgroundResource(R.mipmap.icon_point_pre);
            } else {

                dotView.setBackgroundResource(R.mipmap.icon_point);
            }
            dotLayout.addView(dotView, params);
            dotViewList.add(dotView);
            //上面是动态添加了四个小圆点
        }

    }
    private void setGongGaoOnGetRequest() {  //数据调用接口
//        showResultDialog();
        setImga();
        final Request r = new Request(Constant.GONGGAO_URL); //默认请求为post，所以可以不用加请求方法
        r.setListener(new Listener() {
            @Override
            public void onResponseListener(String result) {
                DebugLog.i("请求的数据", result);
                if (result != null) {
                    /*if(isAdded()){*/
                    if(true){
                        Gson gson = new Gson();
                        try {
                            EntityGongGaoBase GGEntity = gson.fromJson(result, EntityGongGaoBase.class);
                            if (GGEntity.getResult() == 0) {
                                List<EntityGongGao> data = GGEntity.getData();
                                if(data!=null&&data.size()>0){
                                    for (int i = 0; i < data.size(); i++) {
                                        ImageView img = (ImageView) LayoutInflater.from(FirstFragment.this).inflate(R.layout.wisdom_banner_image, null);
                                        imag = data.get(i).getImagesList();
                                        EntityGongGao egg = new EntityGongGao();
                                        cont = data.get(i).getContent();
                                        title = data.get(i).getTitle();
                                        endate = data.get(i).getEndDate();
                                        egg.setContent(cont);
                                        egg.setTitle(title);
                                        egg.setEndDate(endate);
                                        listdata.add(egg);

                                        Glide.with(FirstFragment.this)
                                                .load(imag)
                                                .placeholder(R.mipmap.u341)//加载中
                                                .error(R.mipmap.u341)//加载失败
                                                .into(img);
                                        listImag.add(img);
                                    }
                                  /*  Constant.gonggaoContent=data.get(data.size()-1).getContent();
                                    Constant.gonggaoTitle=data.get(data.size()-1).getTitle();
                                    Constant.gonggaoDate=data.get(data.size()-1).getEndDate();
                                    tvgongcont.setText(Constant.gonggaoTitle);*/
                                }
                                initView();
                                setviewPagerList();
                                mviewPager.setOnPageChangeListener(new MyPageChangeListener());
//                            Toast.makeText(getActivity(), cont + "", Toast.LENGTH_SHORT).show();
//                            adapters.appendToList(data);
//                            ggListView.setAdapter(adapters);
                            } else {
                                Toast.makeText(FirstFragment.this, GGEntity.getMsg() + "", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            Log.i("1111111111", e.toString() + "");
                            setImga();
                            return;
                        }
                    }


                } else {
                    System.out.println("result:" + "*****请求数据获取失败");
                    setImga();
                }
            }


            public void onErrorListener(String error) {
//                dismissResultDialog();
                Toast.makeText(FirstFragment.this, "请检查网络", Toast.LENGTH_SHORT).show();
                setImga();
            }
        });
        NetQueue.getInstance().netRequest(r);
    }
    private void setviewPagerList() {

        ImagePaperAdapter adapter = new ImagePaperAdapter((ArrayList) listImag);
        mviewPager.setAdapter(adapter);
        mviewPager.setCurrentItem(0);

    }
    public void setImga() {
        ImageView img1 = (ImageView) LayoutInflater.from(FirstFragment.this).inflate(R.layout.wisdom_banner_image, null);
        img1.setBackgroundResource(R.mipmap.u341);
        defaultImag.add(img1);
        ImagePaperAdapter adapter = new ImagePaperAdapter((ArrayList) defaultImag);
        mviewPager.setAdapter(adapter);
        mviewPager.setCurrentItem(0);
    }
    /**
     * 开始轮播图切换
     */
    private void startPlay() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new SlideShowTask(), 1, 4, TimeUnit.SECONDS);
        //根据他的参数说明，第一个参数是执行的任务，第二个参数是第一次执行的间隔，第三个参数是执行任务的周期；
    }

    /**
     * 执行轮播图切换任务
     */
    private class SlideShowTask implements Runnable {

        @Override
        public void run() {
            synchronized (mviewPager) {
                currentItem = (currentItem + 1) % listImag.size();
                handler.sendEmptyMessage(100);
            }
        }
    }

    /**
     * ViewPager的监听器
     * 当ViewPager中页面的状态发生改变时调用
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        boolean isAutoPlay = false;

        @Override
        public void onPageScrollStateChanged(int arg0) {
            switch (arg0) {
                case 1:// 手势滑动，空闲中
                    isAutoPlay = false;
//                    System.out.println(" 手势滑动，空闲中");
                    break;
                case 2:// 界面切换中
                    isAutoPlay = true;
//                    System.out.println(" 界面切换中");
                    break;
                case 0:// 滑动结束，即切换完毕或者加载完毕
                    // 当前为最后一张，此时从右向左滑，则切换到第一张
                    if (mviewPager.getCurrentItem() == mviewPager.getAdapter().getCount() - 1 && !isAutoPlay) {
                        mviewPager.setCurrentItem(0);
//                        System.out.println(" 滑动到最后一张");
                    }
                    // 当前为第一张，此时从左向右滑，则切换到最后一张
                    else if (mviewPager.getCurrentItem() == 0 && !isAutoPlay) {
                        mviewPager.setCurrentItem(mviewPager.getAdapter().getCount() - 1);
//                        System.out.println(" 滑动到第一张");
                    }
                    break;
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            for (int i = 0; i < listdata.size(); i++) {
                tvgongtitle.setText(listdata.get(arg0).getTitle());
                tvgongcont.setText(listdata.get(arg0).getContent());
                tvgongendDate.setText(listdata.get(arg0).getEndDate());
            }
        }

        @Override
        public void onPageSelected(int pos) {
            //这里面动态改变小圆点的被背景，来实现效果
            currentItem = pos;
            for (int i = 0; i < dotViewList.size(); i++) {
                if (i == pos) {
                    ((View) dotViewList.get(pos)).setBackgroundResource(R.mipmap.icon_point_pre);
                } else {
                    ((View) dotViewList.get(i)).setBackgroundResource(R.mipmap.icon_point);
                }
            }
        }

    }


    private class HotPushOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent pushIntent=new Intent();
            pushIntent.setClass(FirstFragment.this, HotPush.class);
            startActivity(pushIntent);
        }
    }
}
