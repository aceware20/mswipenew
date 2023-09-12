package com.aceware.testmswipe;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;

import com.mswipetech.wisepad.sdk.Print;
import com.socsi.smartposapi.printer.Align;


public class MswipePrinterUtil {
    private Context mContext;
    float desiredPaperWidthInInches = 5.0f; // Adjust as needed
    int printerDPI = 203;
    private  PrintSuccesInterface printSuccesInterfaceTT;

    public MswipePrinterUtil(Context context, View  view, String alignment, PrintSuccesInterface printSuccesInterface) {
        mContext=context;
        printSuccesInterfaceTT=printSuccesInterface;
        Bitmap bitmap1 =screenShot(view);
        Bitmap bitmap=getResizedBitmap(bitmap1, view.getHeight(), 400);
        Print.init(mContext);
        Print.StartPrintingImage(bitmap, Align.CENTER);
        Print.StartPrinting();
        Print.StartPrinting();
        Print.StartPrinting();

    }




    public interface PrintSuccesInterface
    {
        void onSuccess(boolean val);
        void onMsg(String msg);
    }
    private Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;

    }
    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        // GET CURRENT SIZE
        int width = bm.getWidth();
        int height = bm.getHeight();
        // GET SCALE SIZE
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }



}
