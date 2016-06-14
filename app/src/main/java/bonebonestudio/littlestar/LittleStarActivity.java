package bonebonestudio.littlestar;

import android.support.v4.app.Fragment;

/**
 * Created by art2cat on 6/14/16.
 */
public class LittleStarActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new LittleStarFragment();
    }
}
