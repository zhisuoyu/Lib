package com.zsy.sample;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import mzs.lib.app.BaseActivity;

public class TestAct extends BaseActivity {


    @BindView(R.id.iv) ImageView iv;

    @Override
    public void initContentView() {
        setContentView(R.layout.act_test);
    }

    @Override
    public void initView() {
        super.initView();
        iv.setImageDrawable(textToDrawable("Hello world"));
    }


    public Drawable textToDrawable(String s) {
        Bitmap bitmap = Bitmap.createBitmap(200, 250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setTextSize(65);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setColor(Color.GRAY);
        Paint.FontMetrics fm = paint.getFontMetrics();
        canvas.drawText(s, 0, 145 + fm.top - fm.ascent, paint);
        canvas.save();
        Drawable drawableright = new BitmapDrawable(bitmap);
        drawableright.setBounds(0, 0, drawableright.getMinimumWidth(),
                drawableright.getMinimumHeight());
        return drawableright;
    }

//    public synchronized Drawable byteToDrawable(String icon) {
//        byte[] img = Base64.decode(icon.getBytes(), Base64.DEFAULT);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
//        return new BitmapDrawable(bitmap);
//
//    }

    public synchronized String drawableToByte(Drawable drawable) {

        if (drawable != null) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            int size = bitmap.getWidth() * bitmap.getHeight() * 4;

            // 创建一个字节数组输出流,流的大小为size
            ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
            // 设置位图的压缩格式，质量为100%，并放入字节数组输出流中
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            // 将字节数组输出流转化为字节数组byte[]
            byte[] imagedata = baos.toByteArray();

            String icon = Base64.encodeToString(imagedata, Base64.DEFAULT);
            return icon;
        }
        return null;
    }

}
