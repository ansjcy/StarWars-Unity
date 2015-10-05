package course.learn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "course.learn.MESSAGE";

    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout root=(LinearLayout) findViewById(R.id.root);

        //创建一个自己继承于View的对象
        final DrawView drawView=new DrawView(this);
        //设置自定义组件的最大宽度和高度
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);

        drawView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                drawView.currentX=event.getX();
                drawView.currentY=event.getY();
                //重绘
                drawView.invalidate();
                //返回true表明算是方法已经处理该事件
                return true;
            }
        });
        root.addView(drawView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.action_search:
                Log.e(null, "search");
                return true;
            case R.id.action_settings:
                Log.e(null, "settings");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void sendMessage(View view){
        int b;
        b = 100+200;
        Log.e(null, Integer.toString(b));
        Intent intent = new Intent(this, DisplayMessageActivity.class); //context,class to receive
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
