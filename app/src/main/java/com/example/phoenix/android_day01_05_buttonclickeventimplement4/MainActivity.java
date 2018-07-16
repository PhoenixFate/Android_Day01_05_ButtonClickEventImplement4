package com.example.phoenix.android_day01_05_buttonclickeventimplement4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editViewNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载一个布局
        setContentView(R.layout.activity_main);
        //找到想要的控件
//        View viewById = findViewById(R.id.editText);
        editViewNumber = findViewById(R.id.editText);
        Button buttonCall = findViewById(R.id.button);

        //给button绑定点击事件
        //按钮的点击事件的第一种实现方式
//        buttonCall.setOnClickListener(new MyClickListener());

        //按钮的点击事件的第二种实现
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editViewNumber.getText().toString().trim();
                System.out.println(number);
                if("".equals(number)){
                    /**
                     * content 上下文
                     */
                    Toast.makeText(MainActivity.this,"电话号码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                //进行拨打电话，创建一个意图对象
                Intent intent=new Intent();
                //设置动作
                intent.setAction(Intent.ACTION_CALL);
                //设置要拨打电话的数据
                intent.setData(Uri.parse("tel:"+number));
                //开启意图
                startActivity(intent);

                System.out.println("button is clicked");
            }
        });

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        //按钮的点击事件的第三种实现，本类实现View.OnClickListener 接口
        //多个按钮时只需要一个onClick方法
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    //按钮的点击事件的第四种实现，声明一个方法 方法名和你要点击的这个按钮 在布局中的声明的onClick一样。
    public void personalClick(View view){
        System.out.println("personal click");
    }

    @Override
    public void onClick(View view) {
        //具体判断点击的是哪个按钮
        switch (view.getId()){
        case R.id.button2:

            break;
        case R.id.button3:
            System.out.println("button3");
            break;
        }
    }










    //定义一个类去实现按钮所需的类
    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String number = editViewNumber.getText().toString().trim();
            System.out.println(number);
            if("".equals(number)){
                /**
                 * content 上下文
                 */
                Toast.makeText(MainActivity.this,"电话号码不能为空",Toast.LENGTH_LONG).show();
                return;
            }
            //进行拨打电话，创建一个意图对象
            Intent intent=new Intent();
            //设置动作
            intent.setAction(Intent.ACTION_CALL);
            //设置要拨打电话的数据
            intent.setData(Uri.parse("tel:"+number));
            //开启意图
            startActivity(intent);



            System.out.println("button is clicked");

        }
    }

}
