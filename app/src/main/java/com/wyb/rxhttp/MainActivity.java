package com.wyb.rxhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wyb.net.RxHttp;
import com.wyb.net.callback.CommonCallBack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 测试
     */
    private Button btn_test;

    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
        tv_msg = findViewById(R.id.tv_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_test:
                doGet();
                break;
        }
    }

    private void doGet() {

        BookRequest bookRequest = new BookRequest();

        bookRequest.setBook_name("测试");
        bookRequest.setBook_anthor("");
        bookRequest.setBook_keyword("");
        bookRequest.setBook_class_number("");
        bookRequest.setBook_ISBN("");
        bookRequest.setBook_press("");
        bookRequest.setBook_collection("");
        bookRequest.setBook_type_id("");
        bookRequest.setBook_borw_id("");
        bookRequest.setStart_time("");
        bookRequest.setEnd_time("");

        RxHttp.getInstance().get("book/framebookquery", bookRequest).execute(new CommonCallBack<BookResponse>() {
            @Override
            public void onFinal(BookResponse bookResponse) {
                if (bookResponse != null) {
                    for (BookInfo bookInfo : bookResponse.getData_list()) {
                        Log.e("doGet", "\n"+bookInfo.toString());
                    }
                }
            }
        });

    }

}
