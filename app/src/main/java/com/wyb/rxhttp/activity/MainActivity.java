package com.wyb.rxhttp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wyb.net.RxHttp;
import com.wyb.net.callback.CommonCallBack;
import com.wyb.net.util.JSONUtils;
import com.wyb.rxhttp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.et_url)
    EditText etUrl;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.et_base_url)
    EditText etBaseUrl;
    @BindView(R.id.btn_set)
    Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_set, R.id.btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_set:
                String baseUrl = etBaseUrl.getText().toString().trim();
                RxHttp.init(baseUrl, 20 * 1000);
                break;

            case R.id.btn_send:
                String url = etUrl.getText().toString();

                String content = etContent.getText().toString();

                tvResponse.setText("");

                RxHttp.post(url, content, new CommonCallBack<String>() {
                    @Override
                    public void onFinal(String s) {
                        tvResponse.setText(JSONUtils.stringToJSON(s));
                    }
                });
                break;
        }
    }
}
