package bonebonestudio.littlestar;

import java.util.HashMap;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private String[] beansName;
    private String[] beansNum;

    // 用来控制CheckBox的选中状况
    private static HashMap<Integer, Boolean> isSelected;

    class ViewHolder {

        TextView tvName;
        TextView tvNum;
    }

    public ListViewAdapter(Context context, String[] beansName, String[] beansNum) {
        // TODO Auto-generated constructor stub
        this.beansName = beansName;
        this.beansNum = beansNum;
        this.context = context;
        isSelected = new HashMap<Integer, Boolean>();
        // 初始化数据
        initDate();
    }

    // 初始化isSelected的数据
    private void initDate() {
        for (int i = 0; i < beansName.length; i++) {
            getIsSelected().put(i, false);
        }
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return beansName.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return beansName[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub
        // 页面
        final ViewHolder holder;
        String bean1 = beansName[position];
        String bean2 = beansNum[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.list_view_item, null);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.textview1);
            holder.tvNum = (TextView) convertView
                    .findViewById(R.id.textview2);
            convertView.setTag(holder);
        } else {
            // 取出holder
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(bean1);
        holder.tvNum.setText(bean2);



        // 监听checkBox并根据原来的状态来设置新的状态
        holder.tvName.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

//                View view = parent.findViewById(R.id.baseLayout);


                if (isSelected.get(position)) {
                    isSelected.put(position, false);
                    holder.tvName.setBackground(null);
                    setIsSelected(isSelected);
                } else {
//                    Drawable backgroundColor = holder.tvNum.getBackground();
                    isSelected.put(position, true);

                    holder.tvName.setBackgroundColor(Color.BLUE);
                    //最新的getColor方法
                    setIsSelected(isSelected);
                }

            }
        });

        // 根据isSelected来设置checkbox的选中状况
//        if(isSelected.get(position) == true)
//
//        else holder.tvName.setBackgroundColor(Color.BLUE);
        return convertView;
    }

    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        ListViewAdapter.isSelected = isSelected;
    }
}