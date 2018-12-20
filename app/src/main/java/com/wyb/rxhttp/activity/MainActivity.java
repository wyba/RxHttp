package com.wyb.rxhttp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wyb.net.RxHttp;
import com.wyb.net.callback.CommonCallBack;
import com.wyb.rxhttp.R;
import com.wyb.rxhttp.bean.BookInfo;
import com.wyb.rxhttp.request.BookRequest;
import com.wyb.rxhttp.response.BookResponse;
import com.wyb.rxhttp.response.CommonResponse;
import com.wyb.rxhttp.response.ReaderBorrowBookResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 架体图书信息查询
     */
    private Button btn_query_shelf_book;

    /**
     * 获取读者借阅图书的信息
     */
    private Button btn_query_reader_borrow;
    /**
     * 架体图书借阅
     */
    private Button btn_shelf_borrow;
    /**
     * 架体图书还书
     */
    private Button btn_shelf_return;
    /**
     * 根据TID查位置
     */
    private Button btn_query_position_by_tid;

    private TextView tv_msg;
    /**
     * 根据书的TID查书信息
     */
    private Button btn_query_book_by_tid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_msg = findViewById(R.id.tv_msg);
        btn_query_shelf_book = findViewById(R.id.btn_query_shelf_book);
        btn_query_shelf_book.setOnClickListener(this);
        btn_query_reader_borrow = findViewById(R.id.btn_query_reader_borrow);
        btn_query_reader_borrow.setOnClickListener(this);
        btn_shelf_borrow = findViewById(R.id.btn_shelf_borrow);
        btn_shelf_borrow.setOnClickListener(this);
        btn_shelf_return = findViewById(R.id.btn_shelf_return);
        btn_shelf_return.setOnClickListener(this);
        btn_query_position_by_tid = findViewById(R.id.btn_query_position_by_tid);
        btn_query_position_by_tid.setOnClickListener(this);
        btn_query_book_by_tid = findViewById(R.id.btn_query_book_by_tid);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_query_shelf_book:
                queryShelfBook();
                break;
            case R.id.btn_query_reader_borrow:
                queryReaderBorrow();
                break;
            case R.id.btn_shelf_borrow:
                shelfBorrow();
                break;
            case R.id.btn_shelf_return:
                shelfReturn();
                break;
            case R.id.btn_query_position_by_tid:
                queryBookByPosition();
                break;
        }
    }

    private void queryShelfBook() {

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
                        Log.e("queryShelfBook", "\n" + bookInfo.toString());
                    }
                }
            }
        });

    }

    private void queryReaderBorrow() {

        Map<String, Object> param = new HashMap<>();

        List<Map<String, String>> content = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("t_id", "E2801130200038E30B5808D1");
        content.add(map);

        param.put("t_id_list", content);

        RxHttp.getInstance().get("reader/getReturnBookInfo", param).execute(new CommonCallBack<ReaderBorrowBookResponse>() {
            @Override
            public void onFinal(ReaderBorrowBookResponse readerBorrowBookResponse) {
                if (readerBorrowBookResponse != null) {

                }
            }
        });

    }


    private void shelfBorrow() {

        Map<String, Object> param = new HashMap<>();

        List<Map<String, String>> content = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("book_id", "1");
        map.put("borrower_date", "2018-12-20 16:06:30");
        map.put("estimate_date", "2018-12-29 16:06:30");
        content.add(map);

        param.put("data_list", content);

        param.put("reader_id", "1");
        param.put("oper_user", "1");

        RxHttp.getInstance().get("reader/BorwBook", param).execute(new CommonCallBack<CommonResponse>() {
            @Override
            public void onFinal(CommonResponse commonResponse) {
                if (commonResponse != null) {

                }
            }
        });

    }

    private void shelfReturn() {

        Map<String, Object> param = new HashMap<>();

        List<Map<String, String>> content = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("book_id", "");
        map.put("time", "2018-12-20 16:06:30");
        map.put("", "2018-12-29 16:06:30");
        content.add(map);

        param.put("data_list", content);

        param.put("f_id", "1");

        param.put("reader_id", "1");

        RxHttp.getInstance().get("reader/ReturnBook", param).execute(new CommonCallBack<CommonResponse>() {
            @Override
            public void onFinal(CommonResponse commonResponse) {
                if (commonResponse != null) {

                }
            }
        });

    }

    private void queryBookByPosition() {


    }

}
