package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.ListViewItem;
import com.example.myapplication.ProfileActivity;
import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter{

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapter(ArrayList<ListViewItem>data){
        this.listViewItemList = data;
    }

    @Override
    public int getCount(){
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, parent, false);
        }

        //이미지뷰 선택 클릭 시
        ImageView button = (ImageView) convertView.findViewById(R.id.imageView1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //다이얼로그 바디
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
                //다이얼로그 메시지
                alertdialog.setMessage("이동하시겠습니까?");

                alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"'확인'버튼을 눌렀습니다",Toast.LENGTH_SHORT).show();
                        //전화번호를 표시만 해주는 기능.
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(listViewItemList.get(pos).getUri()));
                        context.startActivity(intent);
                    }
                });

                //취소버튼
                alertdialog.setNegativeButton("취소",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(context, "'취소' 버튼을 눌렀습니다.",Toast.LENGTH_SHORT).show();
                    }
                });

                //메인 다이얼로그 생성
                AlertDialog alert = alertdialog.create();
                alert.setIcon(R.drawable.p4);
                alert.setTitle("Youtube");
                alert.show();
            }
        });

        ImageView button2 = (ImageView) convertView.findViewById(R.id.imageView2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(context, ProfileActivity.class);
                it.putExtra("image", pos);
                it.putExtra("title", listViewItemList.get(pos).getTitle());
                it.putExtra("desc", listViewItemList.get(pos).getArtist());
                it.putExtra("location", listViewItemList.get(pos).getGenre());

                context.startActivity(it);
            }
        });


        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView writerTextView = (TextView) convertView.findViewById(R.id.textView2);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.textView3);
        TextView artistTextView = (TextView) convertView.findViewById(R.id.textView4);
        TextView genreTextView = (TextView) convertView.findViewById(R.id.textView5);

        ListViewItem listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        writerTextView.setText(listViewItem.getWriter());
        dateTextView.setText(listViewItem.getDate());
        artistTextView.setText(listViewItem.getArtist());
        genreTextView.setText(listViewItem.getGenre());

        return convertView;

    }

    public long getItemId(int position){
        return position;
    }

    public Object getItem(int position){
        return listViewItemList.get(position);
    }

    //아이템 테이터 추가를 위한 함수, 개발자가 원하는대로 작성 가능
    public void addItem(Drawable icon, String title, String writer, String date, String artist, String genre){
        ListViewItem item = new ListViewItem();
        item.setIcon(icon);
        item.setTitle(title);
        item.setDate(date);
        item.setArtist(artist);
        item.setGenre(genre);

        listViewItemList.add(item);
    }
}



