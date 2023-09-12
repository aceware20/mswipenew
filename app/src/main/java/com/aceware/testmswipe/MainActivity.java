package com.aceware.testmswipe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.aceware.testmswipe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Activity activity=this;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MswipePrinterUtil(activity, binding.llMain, "center", new MswipePrinterUtil.PrintSuccesInterface() {
                    @Override
                    public void onSuccess(boolean val) {

                    }

                    @Override
                    public void onMsg(String msg) {

                    }
                });
            }
        });
    }
}