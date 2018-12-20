package com.wyb.rxhttp;

import com.wyb.net.util.JSONUtils;
import com.wyb.rxhttp.request.BookRequest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test(){

        BookRequest bookRequest = new BookRequest();

        bookRequest.setBook_name("");
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

        Map<String, String> map = JSONUtils.beanToMap(bookRequest);

        System.out.println(map.toString());

    }



    @Test
    public void test1(){

        Map<String, String> param = new HashMap<>();

        List<Map<String,String>> content = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Map<String,String> map = new HashMap<>();
            map.put("t_id",""+(i+1));
            content.add(map);
        }

        param.put("t_id_list",content.toString());

        System.out.println(param.toString());
    }

}