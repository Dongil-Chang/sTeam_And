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
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FragCommunity extends Fragment {
MainActivity activity;
FloatingActionButton commuFabAdd;
Fragment fragCommunityWriting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //프레그먼트 이동을 위한 객체 생성
        fragCommunityWriting = new FragCommunityWriting();

        //프래그먼트랑 xml랑 합쳐주는 역할  ViewGroup rootView
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community, container,false);

        //레이아웃 아이디값 찾기
        commuFabAdd = rootView.findViewById(R.id.fabAdd);

        // 글작성 버튼 누르면 FragCommunityWriting 이동
        commuFabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragCommunityWriting);
            }//onClick
        });//commuAddBtn.setOnClickListener

        return rootView;
    }//onCreateView

}//FragCommunity