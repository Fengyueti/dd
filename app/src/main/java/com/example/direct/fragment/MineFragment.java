package com.example.direct.fragment;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.direct.R;
import com.example.direct.activity.HelpActivity;
import com.example.direct.activity.MemberActivity;
import com.example.direct.activity.MySetActivity;
import com.example.direct.activity.ZhuActivity;

public class MineFragment extends Fragment {

    private TextView myset,help,member,customer,myname,zhubo;
    private PopupWindow popupWindow;
    private ImageView cha,back;
    private ImageView myimg,suo,pen;
    private  TextView wallet;
    private LinearLayout mine;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.minefragment, container, false);
        myset = view.findViewById(R.id.myset);//我的设置
        help=view.findViewById(R.id.help);//帮助中心
        member=view.findViewById(R.id.member);//我的会员
        customer = view.findViewById(R.id.customerservice);//我的客服
        zhubo = view.findViewById(R.id.zhubo);//主播认证
        wallet =view.findViewById(R.id.wallet);//我的钱包
        myimg =view.findViewById(R.id.myimg);
        myname = view.findViewById(R.id.myname);
        suo = view.findViewById(R.id.suo);
        pen = view.findViewById(R.id.pen);
        mine = view.findViewById(R.id.mine);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWallect();
            }
        });
        myset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MySetActivity.class));
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HelpActivity.class));
            }
        });
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MemberActivity.class));
            }
        });
        zhubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ZhuActivity.class));
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myimg.setVisibility(View.INVISIBLE);
                myname.setVisibility(View.INVISIBLE);
                suo.setVisibility(View.INVISIBLE);
                pen.setVisibility(View.INVISIBLE);
                PopupCustomer();
            }
        });
        return view;
    }
    //我的钱包
    private void PopupWallect() {
        View v = View.inflate(getActivity(), R.layout.wallet, null);
        mine.setAlpha((float) 0.6);
        back = v.findViewById(R.id.back);
        //设置PopupWindow
        popupWindow = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //设置焦点
        popupWindow.setFocusable(true);
        //设置背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置可触摸
        popupWindow.setTouchable(true);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mine.setAlpha((float) 1.0);
                popupWindow.dismiss();
            }
        });
        //设置位置
        // popupWindow.showAsDropDown(v,0,0);
        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);
    }
    //我的客服
    private void PopupCustomer() {
        View v = View.inflate(getActivity(), R.layout.customerserve, null);
        cha = v.findViewById(R.id.cha);
        //设置PopupWindow
        popupWindow = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //设置焦点
        popupWindow.setFocusable(true);
        //设置背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置可触摸
        popupWindow.setTouchable(true);
        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myimg.setVisibility(View.VISIBLE);
                myname.setVisibility(View.VISIBLE);
                suo.setVisibility(View.VISIBLE);
                pen.setVisibility(View.VISIBLE);
                popupWindow.dismiss();
            }
        });
        //设置位置
        // popupWindow.showAsDropDown(v,0,0);
        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);
    }
}
