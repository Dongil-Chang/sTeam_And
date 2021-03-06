package com.example.steam_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steam_android.fragment.FragColumn;
import com.example.steam_android.fragment.FragColumnList;
import com.example.steam_android.fragment.FragColumnMyPage;
import com.example.steam_android.fragment.FragCommunity;
import com.example.steam_android.fragment.FragCommunityComments;
import com.example.steam_android.fragment.FragCommunityModify;
import com.example.steam_android.fragment.FragCommunityScreen;
import com.example.steam_android.fragment.FragCommunityWriting;
import com.example.steam_android.fragment.FragNotQna;
import com.example.steam_android.fragment.FragQna;
import com.example.steam_android.fragment.FragQnaScreen;
import com.example.steam_android.fragment.FragQnaWriting;
import com.example.steam_android.fragment.FragShopMap;
import com.example.steam_android.fragment.FragShopMenu;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    FragColumnList fragColumnList;
    FragCommunity fragCommunity;
    FragQna fragQna;
    FragColumn fragColumn;
    FragColumnMyPage fragColumnMyPage;
    FragCommunityComments fragCommunityComments;
    FragCommunityModify fragCommunityModify;
    FragCommunityScreen fragCommunityScreen;
    FragCommunityWriting fragCommunityWriting;
    FragNotQna fragNotQna;
    FragQnaScreen fragQnaScreen;
    FragQnaWriting fragQnaWriting;
    FragShopMap fragShopMap;
    FragShopMenu fragShopMenu;
    Fragment change = null;


    //????????? ??????
    RecyclerView recyclerView;
    ColumnAdapter adapter;
    ArrayList<ColumnDTO> dtos;




    Button mainMemoBtn, mainCommuBtn,  mainQnaBtn, mainRsvBtn;
    TextView mainMoreTv;
    RecyclerView mainPageRecyclerview;

    /* -------------------?????? ?????? ??????-----------------------*/
    private ViewPager2 sliderViewPager;
    private LinearLayout layoutIndicator;
    private int[] images = new int[]{
            R.drawable.slider_hair1,
            R.drawable.slider_hair2,
            R.drawable.slider_hair3,
            R.drawable.slider_hair4jpg
    };
    private int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; //
    //----------------?????? ?????? ???-----------------------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Fragment ?????? ??????
        fragCommunity = new FragCommunity();
        fragQna = new FragQna();
        fragColumnList = new FragColumnList();
        fragColumn = new FragColumn();
        fragColumnMyPage = new FragColumnMyPage();
        fragCommunityComments = new FragCommunityComments();
        fragCommunityModify = new FragCommunityModify();
        fragCommunityScreen = new FragCommunityScreen();
        fragCommunityWriting = new FragCommunityWriting();
        fragNotQna = new FragNotQna();
        fragQnaScreen = new FragQnaScreen();
        fragQnaWriting = new FragQnaWriting();
        fragShopMap = new FragShopMap();
        fragShopMenu = new FragShopMenu();


        //????????? ????????? ???????????? ????????????
        mainCommuBtn = findViewById(R.id.mainCommuBtn);
        mainMemoBtn = findViewById(R.id.mainMemoBtn);
        mainQnaBtn = findViewById(R.id.mainQnaBtn);
        mainRsvBtn = findViewById(R.id.mainRsvBtn);
        mainMoreTv = findViewById(R.id.mainMoreTv);
        mainPageRecyclerview = findViewById(R.id.mainPageRecyclerview);



        //-------------------------------???????????? ??????----------------------------
        sliderViewPager = findViewById(R.id.sliderViewPager);
        layoutIndicator = findViewById(R.id.layoutIndicators);
        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(this, images));

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.length);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(images.length == currentPage) {
                    currentPage = 0;
                }
                sliderViewPager.setCurrentItem(currentPage++, true);
            }
        }, DELAY_MS, PERIOD_MS);
        //----------?????? ??? -------------------



        //????????? ?????? ????????? FragCommunity ????????? ??????
        mainCommuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragCommunity).addToBackStack(null). commit();
            }//onClick
        });//mainCommuBtn.setOnClickListener

        //QnA ????????? FragQna ????????? ??????
        mainQnaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragQna).addToBackStack(null). commit();
            }//onClick
        });//mainQnaBtn.setOnClickListener mainRsvBtn


        //????????? ????????? fragColumnList ????????? ??????
        mainMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragColumnList).addToBackStack(null).commit();
            }//onClick
        });//mainMoreTv.setOnClickListener




        //===================????????????????????? ??????==============================================
        dtos = new ArrayList<>();

        recyclerView = findViewById(R.id.mainPageRecyclerview);
        //???????????? ???????????? ?????? ???????????? ????????? ????????????
        //recyclerView??? ????????????
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ColumnAdapter(MainActivity.this, dtos);
        adapter.addDto(new ColumnDTO("?????????/????????????", "2021 F/W ?????? ????????? ??????", 30, R.drawable.shop1));
        adapter.addDto(new ColumnDTO("?????????/????????????", "????????? ?????? ????????? ?????????", 11, R.drawable.shop2));
        adapter.addDto(new ColumnDTO("?????????/????????????", "???????????? ?????????, ?????? ?????? ?????????????", 344, R.drawable.shop3));
        adapter.addDto(new ColumnDTO("?????????/?????????", "???????????? ?????? ?????? ?????? ?????????", 45, R.drawable.shop4));
        adapter.addDto(new ColumnDTO("?????????/????????????", "????????? ????????? ?????????", 23, R.drawable.shop5));
        adapter.addDto(new ColumnDTO("?????????/????????????", "2021 F/W ?????? ????????? ??????", 30, R.drawable.shop1));
        adapter.addDto(new ColumnDTO("?????????/????????????", "????????? ?????? ????????? ?????????", 11, R.drawable.shop2));
        adapter.addDto(new ColumnDTO("?????????/????????????", "???????????? ?????????, ?????? ?????? ?????????????", 344, R.drawable.shop3));
        adapter.addDto(new ColumnDTO("?????????/?????????", "???????????? ?????? ?????? ?????? ?????????", 45, R.drawable.shop4));
        adapter.addDto(new ColumnDTO("?????????/????????????", "????????? ????????? ?????????", 23, R.drawable.shop5));


        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListner(new OnSingerItemClickListner() {
            @Override
            public void onItemClick(ColumnAdapter.ViewHolder holder, View view, int position) {
                ColumnDTO dto = adapter.getItem(position);
                Toast.makeText(MainActivity.this, dto.getName(), Toast.LENGTH_SHORT).show();

                fragmentChange(fragColumn);
            }
        });
        //===================????????????????????? ??????==============================================


    }//onCreate


    //-------------------??????????????? ?????? ?????? -------------------------
    public void fragmentChange(Fragment change){
        if(change.equals(fragCommunityWriting)){
        }else if(change.equals(fragCommunityScreen)){
        }else if(change.equals(fragCommunity)){
        }else if(change.equals(fragCommunityModify)){
        }else if(change.equals(fragQnaWriting)){
        }else if(change.equals(fragQnaScreen)){
        }else if(change.equals(fragQna)){
        }else if(change.equals(fragColumn)){
        }else if(change.equals(fragColumnMyPage)){
        }
        // if~else if {} ???
        getSupportFragmentManager().beginTransaction().replace(R.id.container, change ).addToBackStack(null).commit();
    }//fragmentChange ---------------??????????????? ??? ?????? ???----------------------------------


















    //-------------------------?????? ??????-------------------------------
    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
    //  -------------------------?????? ??? ---------------------------------
}