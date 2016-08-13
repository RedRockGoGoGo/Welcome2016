package com.gavynzhang.welcome2016.fragment.fragmentGuide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by a on 2016/8/5.
 */
public class GuideAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 8;
    private String title[] = new String[]{"入学须知","须知路线","寝室概况","必备清单","QQ群","日常生活","周边美食","周边美景"};
    public GuideAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 7:
                fragment = FragmentMeiJin.newInstance(position);break;
            case 6:
                fragment = FragmentMeiShi.newInstance(position);break;
            case 5:
                fragment = FragmentShengHuo.newInstance(position);break;
            case 4:
                fragment = FragmentQQun.newInstance(position);break;
            case 3:
                fragment = FragmentQinDan.newInstance(position);break;
            case 2 :
                fragment = FragmentQinShi.newInstance(position);break;
            case 1 :
                fragment = FragmentLuXian.newInstance(position);break;
            case 0 :
                fragment = FragmentXuZhi.newInstance(position);break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}
