package com.example.steam_android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.steam_android.MainActivity;
import com.example.steam_android.R;


public class FragCommunityModify extends Fragment {
MainActivity activity;
Button commuModifyBtn, commuModifyCanBtn;
Fragment fragCommunityScreen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프레그먼트 이동을 위한 객체 생성
        fragCommunityScreen = new FragCommunityScreen();

        //프래그먼트랑 xml랑 합쳐주는 역할  ViewGroup rootView
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_modify, container,false);

        //레이아웃 아이디값 찾기
        commuModifyBtn = rootView.findViewById(R.id.commuModifyBtn);
        commuModifyCanBtn = rootView.findViewById(R.id.commuModifyCanBtn);

       // 수정 버튼 누르면 FragCommunityScreen 이동
        commuModifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragCommunityScreen);
            }//onClick
        });//commuAddBtn.setOnClickListener

        //취소 버튼 누르면 FragCommunityScreen 이동
        commuModifyCanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragCommunityScreen);
            }
        });

        return rootView;
    }//onCreateView
}//FragCommunityModify

