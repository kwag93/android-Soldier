package com.example.flower;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class EventRequest extends StringRequest {

    //서버 URL 설정 (PHP 연동)
    final  static private String URL = "http://ec2-3-229-83-86.compute-1.amazonaws.com:80/event.php"; //인스턴스 주소값/php파일
    private Map<String, String> map;


    public EventRequest(String type, String Memo, String EndDate, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);


        map = new HashMap<>();
        map.put("type",type);
        map.put("Memo",Memo);
        map.put("EndDate",EndDate);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
