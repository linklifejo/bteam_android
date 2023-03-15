package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    RecyclerView recyclerView;
    SingerAdapter adapter_re;
    ArrayList<SingerDTO> dtos_re;
    Button btnAdd;
    private MainActivity mainActivity;
    GridView gridView;

    BoardrAdapter adapter;
    ArrayList<BoardDTO> dtos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

       View view =  inflater.inflate(R.layout.fragment1,
                container, false);
        mainActivity = (MainActivity) getActivity();
        dtos_re = new ArrayList<>();


        recyclerView = view.findViewById(R.id.recyclerView);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                mainActivity, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // 어댑터 객체 생성
        adapter_re = new
                SingerAdapter(mainActivity, dtos_re);

        // 어댑터에 있는 ArrayList<SingerDTO> dtos에 dto 추가
        adapter_re.addDto(new SingerDTO("블랙핑크",
                "010-1111-1111", 25, R.drawable.singer1));
        adapter_re.addDto(new SingerDTO("걸스데이",
                "010-1111-2222", 27, R.drawable.singer2));
        adapter_re.addDto(new SingerDTO("방탄소년단",
                "010-1111-3333", 25, R.drawable.singer3));
        adapter_re.addDto(new SingerDTO("마마무",
                "010-1111-4444", 35, R.drawable.singer4));
        adapter_re.addDto(new SingerDTO("소녀시대",
                "010-1111-5555", 29, R.drawable.singer5));

        // 만든 어댑터를 리싸이클러뷰에 붙인다
        recyclerView.setAdapter(adapter_re);





        // 중요 : dtos 넘겨줄때 반드시 생성해서 넘겨준다
        dtos = new ArrayList<>();

        gridView = view.findViewById(R.id.gridView);

        // 어댑터 객체를 생성한다
        adapter = new BoardrAdapter(mainActivity, dtos);
        // 어댑터에 생성한 매소드 addDto를 이용하여 dtos에 데이터를 추가한다
        adapter.addDto(new BoardDTO("블랙핑크", "010-1111-1111",
                25, R.drawable.singer1));
        adapter.addDto(new BoardDTO("걸스데이", "010-1111-2222",
                26, R.drawable.singer2));
        adapter.addDto(new BoardDTO("방탄소년단", "010-1111-3333",
                23, R.drawable.singer3));
        adapter.addDto(new BoardDTO("마마무", "010-1111-4444",
                29, R.drawable.singer4));
        adapter.addDto(new BoardDTO("소녀시대", "010-1111-5555",
                28, R.drawable.singer5));
        // 5. 만든 어댑터를 리스트뷰에 붙인다
        gridView.setAdapter(adapter);
        // 리스트뷰는 아이템 클릭 이벤트를 제공해준다
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BoardDTO dto = (BoardDTO) adapter.getItem(position);
                Toast.makeText(mainActivity, "" +
                        "선택 : " + position + "\n이름 : " + dto.getName()
                        + "\n전화번호 : " + dto.getMobile() + "\n나이 : " + dto.getAge()
                        + "\n이미지 : " + dto.getResId(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
