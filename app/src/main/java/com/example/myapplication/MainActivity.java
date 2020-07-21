package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ListViewItem;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListViewItem data;
    private ArrayList<ListViewItem> arrays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = null;
        ListViewAdapter adapter;
        arrays = new ArrayList<ListViewItem>();

        //데이터 추가 부분
        intialData(); // 서버로 부터 데이터를 받기 or 로컬 sqlite3로 부터 데이터 읽어 올 수 있음
        listview = (ListView)findViewById(R.id.listview1);

        //Adapter 생성
        adapter = new ListViewAdapter(arrays);
        Log.i("kani","test");

        listview = (ListView)findViewById(R.id.listview1);

        /*
        adapter.addItem(getResources().getDrawable(R.drawable.p1),"김관희","010-2333-3333");
        adapter.addItem(getResources().getDrawable(R.drawable.p2),"박신혜","010-2333-3333");
        adapter.addItem(getResources().getDrawable(R.drawable.p3),"이동건","010-2333-3333");
         */

        //리스트뷰 참조 및 Adapter 달기
        listview.setAdapter(adapter);

        //리스트뷰 아이템 클릭 이벤트 핸들러
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get item
                //parent : ListView 자체에 대한 참조
                //view : 클릭이 발생한 View에 대한 참조
                //position : Adapter에서의 view의 position
                //id : 클릭된 아이템의 row id.

                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, item.getTitle() +"\n"+
                        item.getArtist() +"/"+ item.getGenre(), Toast.LENGTH_SHORT).show();

                //전화 걸기
                // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(item.getDesc()));
                // startActivity(intent);
            }
        });
    }



    private void intialData(){
        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p7),"[MV] IU(아이유) _ Blueming(블루밍)","1theK (원더케이)", "2019.11.18","아티스트 아이유","장르 록/포크","https://www.youtube.com/watch?v=D1PvIWdJ8xo");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p6),"IU(아이유) _ YOU&I(너랑나) MV","1theK (원더케이)", "2011.11.28","아티스트 아이유","장르 발라드","https://www.youtube.com/watch?v=f_iQRO5BdCM");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p5),"현아 (HYUN A) - 'FLOWER SHOWER'","HyunA", "2019.11.5","아티스트 현아","장르 댄스","https://www.youtube.com/watch?v=8xqSz6_RJeU");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p8),"[MV] MAMAMOO(마마무) _ HIP","1theK (원더케이)", "2019.11.14","아티스트 마마무","장르 댄스","https://www.youtube.com/watch?v=F4tMI_XcqQ0");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p9),"[MV] 볼빨간사춘기 _ Workaholic","1theK (원더케이)", "2019.09.10","아티스트 볼빨간사춘기","장르 록/포크","https://www.youtube.com/watch?v=mrAIqeULUL0");
        arrays.add(data);


    }
}
