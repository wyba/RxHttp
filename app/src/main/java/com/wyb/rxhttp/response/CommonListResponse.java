package com.wyb.rxhttp.response;

import java.util.List;

public class CommonListResponse<T> {

    private List<T> data_list;

    public List<T> getData_list() {
        return data_list;
    }

    public void setData_list(List<T> data_list) {
        this.data_list = data_list;
    }
}
