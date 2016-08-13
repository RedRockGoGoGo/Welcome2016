package com.gavynzhang.welcome2016.fragment.fragmentBigData;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/8/10.
 */
public class BigDataAdapter extends FragmentPagerAdapter {

    private FragmentBigData fragmentBigData;
    final int PAGE_COUNT = 3;
    private String tabTitle[] = new String[]{"男女比例","最难科目","毕业去向"};

    public BigDataAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentBigData.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }

}
