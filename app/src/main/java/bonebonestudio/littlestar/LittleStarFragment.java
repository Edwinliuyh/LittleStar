package bonebonestudio.littlestar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by art2cat on 6/14/16.
 */
public class LittleStarFragment extends Fragment {
    private View view;
    private ListView listView;
    private ListViewAdapter adapter;

    private String[] userName = {"zhangsan", "lisi", "wangwu", "zhaoliu"}; //这里第一列所要显示的人名
    private String[] userId = {"1001", "1002", "1003", "1004"};  //这里是人名对应的ID

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_main, null);
        initView();
        return view;
    }
    private void initView() {
        // TODO Auto-generated method stub
        Log.i("htp", "beans.size:" + userName.length);
        listView = (ListView)view.findViewById(R.id.listView);
        adapter = new ListViewAdapter(getActivity(), userName, userId);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }



//        // TODO Auto-generated method stub
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);       //为MainActivity设置主布局
//        //创建ArrayList对象；
//        list = new ArrayList<HashMap<String, String>>();
//        //将数据存放进ArrayList对象中，数据安排的结构是，ListView的一行数据对应一个HashMap对象，
//        //HashMap对象，以列名作为键，以该列的值作为Value，将各列信息添加进map中，然后再把每一列对应
//        //的map对象添加到ArrayList中
//
//        for (int i = 0; i < 4; i++) {
//            map = new HashMap<String, String>();       //为避免产生空指针异常，有几列就创建几个map对象
//            map.put("id", userId[i]);
//            map.put("name", userName[i]);
//            list.add(map);
//        }
//
//        //创建一个SimpleAdapter对象
//        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_view_item, from, to);
//        ListView listView = (ListView) findViewById(R.id.listView);
//        //调用ListActivity的setListAdapter方法，为ListView设置适配器
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//                                    long arg3) {
//                //点击后在标题上显示点击了第几行
//                setTitle("你点击了第" + arg2 + "行");
//                selectedViewID = arg1.getId();
//                if (selectedViewID == -1) {
//                    arg1.setId(View.generateViewId());
//                    selectedViewID = arg1.getId();
//                }
//                arg1.setBackgroundColor(android.graphics.Color.RED);
//                Log.d("test", "选择的是：" + selectedViewID);
////                Log.d("test",  arg1.getResources().getResourceEntryName());
//            }
//        });



//    public void onClick(View view) {
//        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        TextView textView;
//        selected = radioGroup.getCheckedRadioButtonId();
//        if (selected != -1) {
//            switch (selected) {
//                case R.id.radio1:
//                    textView = (TextView) findViewById(R.id.quantity1);
//                    display(view, textView);
//                    break;
//                case R.id.radio2:
//                    textView = (TextView) findViewById(R.id.quantity2);
//                    display(view, textView);
//                    break;
//                case R.id.radio3:
//                    textView = (TextView) findViewById(R.id.quantity3);
//                    display(view, textView);
//                    break;
//            }
//        } else
//            Toast.makeText(getActivity(), "请选择一个成员", Toast.LENGTH_SHORT).show();
//    }
//
//    /**
//     * This method displays the given quantity value on the screen.
//     */
//    private void display(View plusOrMinus, TextView quantity_text_view) {
//        quantity = Integer.parseInt((String) quantity_text_view.getText());
//        switch (plusOrMinus.getId()) {
//            case R.id.plusOne:
//                quantity_text_view.setText("" + (quantity + 1));
//                quantity = Integer.parseInt((String) quantity_text_view.getText());
//                break;
//            case R.id.plusTwo:
//                quantity_text_view.setText("" + (quantity + 2));
//                break;
//            case R.id.plusFive:
//                quantity_text_view.setText("" + (quantity + 5));
//                break;
//            case R.id.minusOne:
//                quantity_text_view.setText("" + (quantity - 1));
//                break;
//            case R.id.minusTwo:
//                quantity_text_view.setText("" + (quantity - 2));
//                break;
//            case R.id.minusFive:
//                quantity_text_view.setText("" + (quantity - 5));
//                break;
//        }
//        newQuantity = Integer.parseInt((String) quantity_text_view.getText());
//    }
//
//
//    /**
//     * This method displays the event when you change the quantity of the littleStar.
//     */
//    public void submitEvent(View view) {
//        String str;
//        RadioButton stuff = (RadioButton)findViewById(selected);
//        String name = stuff.getText().toString();
//        int i = newQuantity - quantity;
//        EditText text = (EditText) findViewById(R.id.editText);
//        String value = text.getText().toString();
//        if(i>0){
//            str = getResources().getString(R.string.youGot) + i + getResources()
//                    .getString(R
//                            .string.surfix);
//        }
//        else
//            str = getResources().getString(R.string.youLost) + i + getResources().getString(R
//                    .string.surfix);
//
//        TextView textView = (TextView) findViewById(R.id.summary);
//        textView.setText((name + " " + str + "\n" + value));
//    }
}

