package com.gavynzhang.welcome2016.fragment.fragmentGuide;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gavynzhang.welcome2016.R;

/**
 * Created by a on 2016/8/5.
 */
public class FragmentQinDan extends Fragment {
    public static FragmentQinDan newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentQinDan fragmentQinDan = new FragmentQinDan();
        fragmentQinDan.setArguments(args);
        return fragmentQinDan;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qindan, container, false);

        return view;
    }

}
