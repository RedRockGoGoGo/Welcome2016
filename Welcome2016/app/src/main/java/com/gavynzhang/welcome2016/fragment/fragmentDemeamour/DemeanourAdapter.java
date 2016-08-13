package com.gavynzhang.welcome2016.fragment.fragmentDemeamour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by a on 2016/8/8.
 */
public class DemeanourAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    private String title[] = new String[]{"学生组织","原创重邮","美在重邮","优秀学子","优秀教师"};
    public DemeanourAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = FragmentOrganization.newInstance(position);break;
            case 1 :
                fragment = FragmentYuanChuang.newInstance(position);break;
            case 2 :
                fragment = FragmentBeautiful.newInstance(position);break;
            case 3 :
                fragment = FragmentGoodStudent.newInstance(position);break;
            case 4 :
                fragment = FragmentGoodTeacher.newInstance(position);break;
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
