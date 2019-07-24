package com.test.test;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.test.test.retrofit.DataStrategy;
import com.test.test.retrofit.DataWebService;

public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.content_main, container, false);

        mView.findViewById(R.id.buttonHTTP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.setEnabled(false);
                new DataWebService().getTodos(1, new DataStrategy.InteractDispatcherObject() {
                    @Override
                    public void response(int code, Object object) {
                        v.setEnabled(true);
                        Snackbar.make(v, "Petición realizada con éxito", Snackbar.LENGTH_SHORT).show();
                        Log.v("Test-Google", "code = [" + code + "], \nobject = [" + object + "]");
                    }

                    @Override
                    public void fail() {
                        v.setEnabled(true);
                        Snackbar.make(v, "La petición ha fallado", Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return mView;
    }


}
