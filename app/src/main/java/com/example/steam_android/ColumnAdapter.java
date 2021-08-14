package com.example.steam_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ColumnAdapter extends RecyclerView.Adapter<ColumnAdapter.ViewHolder> implements  OnSingerItemClickListner{

    Context context;
    ArrayList<ColumnDTO> dtos;


    static OnSingerItemClickListner listner;   //메인액티비티에서 접근할수있게 만들어줌.

    public ColumnAdapter(Context context, ArrayList<ColumnDTO> dtos){
        this.context = context;
        this.dtos = dtos;
        //선언 후 초기화 된 상태
        //값을 사용할수 잇는 상태
    }

    //화면xml 연결 ListView에서 ViewHolder를 사용한 경우 똑같음.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.main_page_view, parent, false);



        return new ViewHolder(itemview , listner);
    }

    //데이터 연결부(Binding)
    //ViewHolder가 세팅 되어있는 상태에서 viewHolder를 인자로 받아서 사용
    //이벤트 처리 onClick, 전부 여기서 처리
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ColumnDTO dto = dtos.get(position);
        holder.setItem(dto);  //holder 부분은 우리가 만들어 놓은 ViewHolder에서 작업한다



    }//onBindViewHolder

    @Override
    public int getItemCount() {
        return dtos.size();
    }//getItemCount

    public void  addDto(ColumnDTO dto){dtos.add(dto);}

    public void setOnItemClickListner(OnSingerItemClickListner listner){

        this.listner = listner;
    }//setOnItemClickListner

    //오버라이드 된 이벤트 처리부분
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listner != null){
            listner.onItemClick(holder, view,position);
        }//if
    }//onItemClick

    public ColumnDTO getItem(int position) {
        return dtos.get(position);
    }//SingerDTO

    //ViewHolder를 강제로 만들게끔 처리된 부분
    public class ViewHolder extends RecyclerView.ViewHolder{
        //find가 안된상대 (null)
        LinearLayout parentLay;
        TextView tvName, tvPhoneNum;
        ImageView imageView;

        //연결하는 부분
        public ViewHolder(@NonNull View itemView ,  OnSingerItemClickListner listner) {
            super(itemView);

            tvName = itemView.findViewById(R.id.mainPageRcvTitleTv);
            tvPhoneNum = itemView.findViewById(R.id.mainPageRcvContentTv);
            imageView = itemView.findViewById(R.id.mainPageRcvImgV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listner != null){
                        listner.onItemClick(ViewHolder.this , itemView, position);
                    }
                }
            });
        }//ViewHolder


        //데이터 세팅부분 onBindViewHolder에서 사용함
        //데이터 의존성
        public void setItem(ColumnDTO dto){
            tvName.setText(dto.getName());
            tvPhoneNum.setText(dto.getPhonenum());
            imageView.setImageResource(dto.getResid());
        }//setItem

    }//ViewHolder class
}//SingerAdapter





















