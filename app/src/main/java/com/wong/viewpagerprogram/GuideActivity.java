package com.wong.viewpagerprogram;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends FragmentActivity {

//    private ViewPager guide_vp;
//    private List<View> views;
//    private MyViewPagerAdapter adapter;
//    private Button button;
//    private ImageView[] dots;
//    private int[] ids = {R.id.guide_iv1,R.id.guide_iv2,R.id.guide_iv3,R.id.guide_iv4};


    private ViewPager viewPager;
    private LinearLayout guide_tabin;
    private List<ImageView> tabinList;
    List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        viewPager = (ViewPager) findViewById(R.id.vp);
        guide_tabin = (LinearLayout) findViewById(R.id.guide_tabin);
        initData();
        initListener();
//        initViews();
//        initDots();
    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                guide_tabin.removeAllViews();
                tabinList.clear();
//显示指示器
                setTabIn(list, position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void initData() {
        tabinList = new ArrayList<>();
        list = new ArrayList<>();

        Bundle bundle1 = new Bundle();
        bundle1.putString("Title", "第一个Fragment");
        bundle1.putInt("pager_num", 1);
        Fragment fg1 = FragmentView.newInstance(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putString("Title", "第二个Fragment");
        bundle2.putInt("pager_num", 2);
        Fragment fg2 = FragmentView.newInstance(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putString("Title", "第三个Fragment");
        bundle3.putInt("pager_num", 3);
        Fragment fg3 = FragmentView.newInstance(bundle3);

        Bundle bundle4 = new Bundle();
        bundle4.putString("Title", "第四个Fragment");
        bundle4.putInt("pager_num", 4);
        Fragment fg4 = FragmentView.newInstance(bundle4);

        list.add(fg1);
        list.add(fg2);
        list.add(fg3);
        list.add(fg4);

        viewPager.setAdapter(new MyFragmentStateAdapter(getSupportFragmentManager(), list));
        //显示指示器
        setTabIn(list, 0);

    }


    private void setTabIn(List<Fragment> listF, int p) {
        for (int i = 0; i < listF.size(); i++) {
            ImageView imageView = new ImageView(this);

            LinearLayout.LayoutParams lp =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.width = 30;
            lp.setMargins(5, 5, 5, 5);
            if (i == p) {
                imageView.setImageResource(R.drawable.current_room);
            } else {
                imageView.setImageResource(R.drawable.current_no_room);
            }
            imageView.setLayoutParams(lp);
            guide_tabin.addView(imageView);
            tabinList.add(imageView);
        }

    }
//    /*
//    * 初始化欢迎的
//    * */
//    private void initViews(){
//        LayoutInflater inflater = LayoutInflater.from(GuideActivity.this);
//        views = new ArrayList<>();
//        views.add(inflater.inflate(R.layout.guide_01,null));
//        views.add(inflater.inflate(R.layout.guide_01,null));
//        views.add(inflater.inflate(R.layout.guide_01,null));
//        views.add(inflater.inflate(R.layout.guide_01,null));
////        views.add(inflater.inflate(R.layout.guide_02,null));
////        views.add(inflater.inflate(R.layout.guide_03,null));
////        views.add(inflater.inflate(R.layout.guide_04,null));
//
//        adapter = new MyViewPagerAdapter(views);
//        guide_vp = (ViewPager)findViewById(R.id.guide_vp);
//        guide_vp.setAdapter(adapter);
//
//        guide_vp.addOnPageChangeListener(this);
//
//
//        /*
//        * 这里要特别注意，第四个欢迎页上的按钮通过
//        * button = (Button)findViewById(R.id.button)
//        * 肯定是不行的，一定会报空指针，因为当前的view是R.layout.guide_activity
//        * 必须在button所在的view进行findViewById查找才可以
//        *
//        * */
//        button = (Button)views.get(3).findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GuideActivity.this,HomeActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }
//    /*
//    * 初始化点
//    * */
//    private void initDots(){
//        dots = new ImageView[views.size()];
//        for (int i = 0;i < ids.length;i++){
//            dots[i] = (ImageView)findViewById(ids[i]);
//        }
//    }
//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        for(int i = 0 ; i < ids.length;i++){
//            if(position == i){
//                dots[i].setImageResource(R.drawable.current_room);
//            }else{
//                dots[i].setImageResource(R.drawable.current_no_room);
//            }
//        }
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
}
