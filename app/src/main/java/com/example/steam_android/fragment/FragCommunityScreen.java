package com.example.steam_android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.steam_android.MainActivity;
import com.example.steam_android.R;


public class FragCommunityScreen extends Fragment {
MainActivity activity;
TextView commuScrModifyTv, commuScrDelTv, commuScrContentTv, commuScrCmtTv;
Fragment fragCommunityModify;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프레그먼트 이동을 위한 객체 생성
         fragCommunityModify = new FragCommunityModify();


        //프래그먼트랑 xml랑 합쳐주는 역할  ViewGroup rootView
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_screen, container,false);

        //레이아웃 아이디값 찾기
        commuScrModifyTv = rootView.findViewById(R.id.commuScrModifyTv);
        commuScrDelTv = rootView.findViewById(R.id.commuScrDelTv);
        commuScrContentTv = rootView.findViewById(R.id.commuScrContentTv);
        commuScrCmtTv = rootView.findViewById(R.id.commuScrCmtTv);

        // 수정 누르면 FragCommunityModify 이동
        commuScrModifyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragCommunityModify);
            }//onClick
        });//commuAddBtn.setOnClickListener

        return rootView;
    }//onCreateView
}//FragCommunityScreen
