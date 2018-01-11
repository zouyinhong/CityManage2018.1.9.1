package mycity.com.citymanage.activity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import mycity.com.citymanage.R;

/**
 * Created by Administrator on 2017/12/21.
 */

public class DocumentActivity extends Activity {

    private RadioGroup radioGroup1;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6;
    private ImageView imageView1;
    private HorizontalScrollView mHorizontalScrollView;
    private Button btnimg;
    private ViewPager mViewPager;
    private Point point=new Point();
    private ArrayList<View> mViews;// 用来存放下方滚动的layout

    private int from = 0;
    private  float mCurrentCheckedRadioLeft;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_document);
        initView();
        iniListener();// 对生产分析各控件进行监听事件
        iniVariable();// ViewPager中布局添加
        iniOthers();// 实例化、使能、调用等操作
    }

    private void iniOthers() {

        radioButton1.setChecked(true);
        mViewPager.setCurrentItem(1);
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();

    }


    private void initView() {
        radioGroup1=(RadioGroup) findViewById(R.id.radioGroup);
        radioButton1=(RadioButton) findViewById(R.id.btn1);
        radioButton2=(RadioButton) findViewById(R.id.btn2);
        radioButton3=(RadioButton) findViewById(R.id.btn3);
        radioButton4=(RadioButton) findViewById(R.id.btn4);
        radioButton5=(RadioButton) findViewById(R.id.btn5);
        radioButton6=(RadioButton) findViewById(R.id.btn6);
       /* getWindowManager().getDefaultDisplay().getSize(point);
        radioButton1.setWidth(point.x/6);
        radioButton2.setWidth(point.x/6);
        radioButton3.setWidth(point.x/6);
        radioButton4.setWidth(point.x/6);
        radioButton5.setWidth(point.x/6);
        radioButton6.setWidth(point.x/6);*/
        btnimg=(Button) findViewById(R.id.img1);
      /*  btnimg.setWidth(point.x/6);*/
        mViewPager=(ViewPager) findViewById(R.id.pager);
        mHorizontalScrollView=(HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                AnimationSet _AnimationSet = new AnimationSet(true);
                TranslateAnimation _TranslateAnimation;

                Log.i("zj", "checkedid=" + checkedId);
                if (checkedId == R.id.btn1) {
                    _TranslateAnimation = new TranslateAnimation(
                            mCurrentCheckedRadioLeft, getResources().getDimension(
                            R.dimen.rdo1), 0f, 0f);
                    _AnimationSet.addAnimation(_TranslateAnimation);
                    _AnimationSet.setFillBefore(false);
                    _AnimationSet.setFillAfter(true);
                    _AnimationSet.setDuration(100);
                    btnimg.startAnimation(_AnimationSet);// 开始上面横条图片的动画切换
                    mViewPager.setCurrentItem(1);// 让下方ViewPager跟随上面的HorizontalScrollView切换
                } else if (checkedId == R.id.btn2) {
                    _TranslateAnimation = new TranslateAnimation(
                            mCurrentCheckedRadioLeft,getResources().getDimension(
                            R.dimen.rdo2), 0f, 0f);
                    _AnimationSet.addAnimation(_TranslateAnimation);
                    _AnimationSet.setFillBefore(false);
                    _AnimationSet.setFillAfter(true);
                    _AnimationSet.setDuration(100);
                    btnimg.startAnimation(_AnimationSet);
                    mViewPager.setCurrentItem(2);
                } else if (checkedId == R.id.btn3) {
                    _TranslateAnimation = new TranslateAnimation(
                            mCurrentCheckedRadioLeft, getResources().getDimension(
                            R.dimen.rdo3), 0f, 0f);
                    _AnimationSet.addAnimation(_TranslateAnimation);
                    _AnimationSet.setFillBefore(false);
                    _AnimationSet.setFillAfter(true);
                    _AnimationSet.setDuration(100);
                    btnimg.startAnimation(_AnimationSet);
                    mViewPager.setCurrentItem(3);
                }
                else if (checkedId == R.id.btn4) {
                    _TranslateAnimation = new TranslateAnimation(
                            mCurrentCheckedRadioLeft, getResources().getDimension(
                            R.dimen.rdo4), 0f, 0f);
                    _AnimationSet.addAnimation(_TranslateAnimation);
                    _AnimationSet.setFillBefore(false);
                    _AnimationSet.setFillAfter(true);
                    _AnimationSet.setDuration(100);
                    btnimg.startAnimation(_AnimationSet);
                    mViewPager.setCurrentItem(4);
                }
                else if (checkedId == R.id.btn5) {
                    _TranslateAnimation = new TranslateAnimation(
                            mCurrentCheckedRadioLeft, getResources().getDimension(
                            R.dimen.rdo5), 0f, 0f);
                    _AnimationSet.addAnimation(_TranslateAnimation);
                    _AnimationSet.setFillBefore(false);
                    _AnimationSet.setFillAfter(true);
                    _AnimationSet.setDuration(100);
                    btnimg.startAnimation(_AnimationSet);
                    mViewPager.setCurrentItem(5);
                }
                else if (checkedId == R.id.btn6) {
                    _TranslateAnimation = new TranslateAnimation(
                            mCurrentCheckedRadioLeft, getResources().getDimension(
                            R.dimen.rdo6), 0f, 0f);
                    _AnimationSet.addAnimation(_TranslateAnimation);
                    _AnimationSet.setFillBefore(false);
                    _AnimationSet.setFillAfter(true);
                    _AnimationSet.setDuration(100);
                    btnimg.startAnimation(_AnimationSet);
                    mViewPager.setCurrentItem(6);
                }


                mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();// 更新当前横条距离左边的距离

                Log.i("zj", "getCurrentCheckedRadioLeft="
                        + getCurrentCheckedRadioLeft());
                Log.i("zj", "getDimension=" + point.x/3);

                mHorizontalScrollView.smoothScrollTo((int) mCurrentCheckedRadioLeft
                        -(int)getResources().getDimension(R.dimen.rdo2), 0);
            }
        });
    }
    private void iniVariable() {
        mViews = new ArrayList<View>();
        mViews.add(getLayoutInflater().inflate(
                R.layout.document_all, null));
        mViews.add(getLayoutInflater().inflate(
                R.layout.document_all, null));
        mViews.add(getLayoutInflater().inflate(R.layout.document_file,
                null));
        mViews.add(getLayoutInflater().inflate(R.layout.document_huiyi,
                null));
        mViews.add(getLayoutInflater().inflate(R.layout.document_gonghan,
                null));
        mViews.add(getLayoutInflater().inflate(R.layout.document_notice,
                null));
        mViews.add(getLayoutInflater().inflate(R.layout.document_book,
                null));
       /* mViews.add(getLayoutInflater().inflate(R.layout.document_book,
                null));*/

        mViewPager.setAdapter(new MyPagerAdapter());// 设置ViewPager的适配器
    }
    /**
     * @description:ViewPager的适配器
     * @author:sunyr
     * @date:2017-8-11上午9:06:20
     */
    private class MyPagerAdapter extends PagerAdapter {

        // 如果超出范围则销毁
        @Override
        public void destroyItem(View v, int position, Object obj) {
            // TODO Auto-generated method stub
            ((ViewPager) v).removeView(mViews.get(position));
        }

        @Override
        public void finishUpdate(View arg0) {
            // TODO Auto-generated method stub

        }

        // 获得要滑动的控件的总数
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mViews.size();
        }

        // 要显示的内容进行缓冲
        @Override
        public Object instantiateItem(View v, int position) {
            ((ViewPager) v).addView(mViews.get(position));
            return mViews.get(position);
        }

        // 判断显示的的是否是同一个
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public Parcelable saveState() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
            // TODO Auto-generated method stub

        }

    }
    private void iniListener() {

       mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());


    }

    /**
     * 获得当前被选中的RadioButton距离左侧的距离
     */
    private float getCurrentCheckedRadioLeft() {
        // TODO Auto-generated method stub
        if (radioButton1.isChecked()) {
            return getResources().getDimension(R.dimen.rdo1);
        } else if (radioButton2.isChecked()) {
            return getResources().getDimension(R.dimen.rdo2);
        } else if (radioButton3.isChecked()) {
            return getResources().getDimension(R.dimen.rdo3);
        } else if (radioButton4.isChecked()) {
            return getResources().getDimension(R.dimen.rdo4);
        } else if (radioButton5.isChecked()) {
            return getResources().getDimension(R.dimen.rdo5);
        } else if (radioButton6.isChecked()) {
            return getResources().getDimension(R.dimen.rdo6);
        }

        return 0f;
    }

    /**
     * @description:ViewPager的PageChangeListener(页面改变的监听器)
     * @author:sunyr
     * @date:2017-8-11上午9:09:36
     */
    private class MyPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        /**
         * 滑动ViewPager的时候,让上方的HorizontalScrollView自动切换
         */
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            // Log.i("zj", "position="+position);
            // layout_buffer和position的0、4值是实现第一个向右滑动和最后一个向左滑动时用户体验友好
            if (position == 0) {
                mViewPager.setCurrentItem(1);
            } else if (position == 1) {
                radioButton1.performClick();// 模拟点击按钮
            } else if (position == 2) {
                radioButton2.performClick();
            } else if (position == 3) {
                radioButton3.performClick();
            }
            else if (position == 4) {
                radioButton4.performClick();
            }
            else if (position == 5) {
                radioButton5.performClick();
            } else if (position == 6) {
                radioButton6.performClick();
            }
            else if (position == 7) {
                mViewPager.setCurrentItem(7);
            }
            /**
             * 对mViewPager.getCurrentItem()的判断是实现进入相应布局并对其布局进行各控件实现
             */
            // 综合分析页面
            if (mViewPager.getCurrentItem() == 1) {
                Toast.makeText(DocumentActivity.this,"全部",Toast.LENGTH_LONG).show();
            }

            // 溯源管理页面
            if (mViewPager.getCurrentItem() == 2) {
                Toast.makeText(DocumentActivity.this,"文件",Toast.LENGTH_LONG).show();
            }
            // 案例管理页面
            if (mViewPager.getCurrentItem() == 3) {
                Toast.makeText(DocumentActivity.this,"会议记录",Toast.LENGTH_LONG).show();

            }
            if (mViewPager.getCurrentItem() == 4) {
                Toast.makeText(DocumentActivity.this,"公函",Toast.LENGTH_LONG).show();

            }
            if (mViewPager.getCurrentItem() == 5) {
                Toast.makeText(DocumentActivity.this,"通知",Toast.LENGTH_LONG).show();

            }
            if (mViewPager.getCurrentItem() == 6) {
                Toast.makeText(DocumentActivity.this,"使用手册",Toast.LENGTH_LONG).show();

            }
        }

    }
}
