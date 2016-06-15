package bonebonestudio.littlestar;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by art2cat on 6/14/16.
 */
public class LittleStarActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private TextView tab1, tab2;
    private TextView line_tab;
    private int moveOne = 0;
    private boolean isScrolling = false;
    private boolean isBackScrolling = false;
    private long startTime = 0;
    private long currentTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_littlestar);
        initView();
        initLine();
    }

    /**
     * 初始化下划线的宽度
     */
    public void initLine() {
        //获取屏幕的宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;

        //重新设定下划线的宽度
        ViewGroup.LayoutParams lp = line_tab.getLayoutParams();
        lp.width = screenW / 2;
        line_tab.setLayoutParams(lp);

        //滑动一个页面的距离
        moveOne = lp.width;
    }

    public void initView() {
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        LeaderBoardFragment fragment1 = new LeaderBoardFragment();
        RecordFragment fragment2 = new RecordFragment();

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),
                fragmentList);
        viewPager.setAdapter(myFragmentAdapter);

        tab1 = (TextView)findViewById(R.id.tab_0);
        tab2 = (TextView)findViewById(R.id.tab_1);
        viewPager.setCurrentItem(0);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentTime = System.currentTimeMillis();
                if (isScrolling && (currentTime - startTime > 200)) {
                    movePositionX(position, moveOne * positionOffset);
                    startTime = currentTime;
                }
                if (isBackScrolling) {
                    movePositionX(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        movePositionX(0);
                        break;
                    case 1:
                        movePositionX(1);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case 1:
                        isScrolling = true;
                        isBackScrolling = false;
                        break;
                    case 2:
                        isScrolling = false;
                        isBackScrolling = true;
                        break;
                    default:
                        isScrolling = false;
                        isBackScrolling = false;
                        break;
                }
            }
        });

        line_tab = (TextView)findViewById(R.id.line_tab);
    }

    /**
     * 重写FragmentPagerAdapter
     */
    public class MyFragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList;

        public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragmentList.get(arg0);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    private void movePositionX(int position, float v) {
        float curTranslationX = line_tab.getTranslationX();
        float toPositionX = moveOne * position + v;
        ObjectAnimator animator = ObjectAnimator.ofFloat(line_tab, "translationX", curTranslationX,
                toPositionX);
        animator.setDuration(500);
        animator.start();
    }

    private void movePositionX(int toPosition) {
        movePositionX(toPosition, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_0:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_1:
                viewPager.setCurrentItem(1);
                break;
            default:
                break;
        }
    }
}

