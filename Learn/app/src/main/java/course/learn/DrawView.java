package course.learn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {

    public float currentX=40;
    public float currentY=50;

    //必须重写一个构造方法
    public DrawView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    //重写onDraw方法通过Canvas绘画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        //绘制一个小圆
        canvas.drawCircle(currentX, currentY, 25, paint);

    }

}
