package com.wong.viewpagerprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2018/5/6.
 */

public class FragmentView extends Fragment {

    private Bundle arg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arg = getArguments();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv = (TextView) view.findViewById(R.id.tv);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        int page = arg.getInt("pager_num");

        if (page == 1) {
            view.setBackgroundResource(R.color.red);
            iv.setImageResource(R.mipmap.img1);
        } else if (page == 2) {
            view.setBackgroundResource(R.color.green);
            iv.setImageResource(R.mipmap.img2);
        } else if (page == 3) {
            view.setBackgroundResource(R.color.blue);
            iv.setImageResource(R.mipmap.img3);
        } else if (page == 4) {
            view.setBackgroundResource(R.color.black);
            iv.setImageResource(R.mipmap.img4);
        }

        tv.setText(arg.getString("Title"));
    }

    public static FragmentView newInstance(Bundle args) {
        FragmentView fragment = new FragmentView();
        fragment.setArguments(args);
        return fragment;
    }

}
