package bonebonestudio.littlestar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by art2cat on 6/15/16.
 */
public class LeaderBoardFragment extends Fragment {
    private View view;
    private ListView listView;
    private ListViewAdapter adapter;

    private String[] userName = {"zhangsan", "lisi", "wangwu", "zhaoliu"}; //这里第一列所要显示的人名
    private String[] userId = {"1001", "1002", "1003", "1004"};  //这里是人名对应的ID

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_leaderboard, null);
        initView();
        return view;
    }

    private void initView() {
        // TODO Auto-generated method stub
        // Log.i("htp", "beans.size:" + userName.length);
        listView = (ListView)view.findViewById(R.id.leaderBoard_ListView);
        adapter = new ListViewAdapter(getActivity(), userName, userId);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
