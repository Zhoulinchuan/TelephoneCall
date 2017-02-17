package com.example.zlc.telephonecall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_main);
        //获取输入文本
        et_number = (EditText) findViewById(R.id.editText);
        //获取按钮
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);


        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);


        /**
         * //匿名内部类
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
        */


       /**
        * 内部类
        * //设置点击事件
        button.setOnClickListener(new MyClickListener());
        */
    }

    /**
     * 内部类
     * //定义一个实现接口的类
    private   class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            call();
        }


    }
    */


    public void click(View v){
        call();
    }

    private void call() {
        //获取文本并转为字符串
        String number = et_number.getText().toString().trim();

        if ("".equals(number)){
            Toast.makeText(MainActivity.this,"number不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        //进行拨打电话
        Intent intent = new Intent(Intent.ACTION_CALL);//创建一个意图

        Uri data = Uri.parse("tel:" + number);
        intent.setData(data);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                call();
                break;
            case R.id.button2:
                call();
                break;
            case R.id.button3:
                call();
                break;
            case R.id.button4:
                System.out.println("我可能是个假按钮");
                break;
            default:
                break;
        }
    }
}
