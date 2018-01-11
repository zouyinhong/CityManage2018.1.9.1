package mycity.com.citymanage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mycity.com.citymanage.R;
import mycity.com.citymanage.entity.EntityGongGao;


/**
 * class AdapterGongGao
 * <p/>
 * Created by Kyle on 2017/4/8.
 */
public class AdapterGongGao extends AdapterBase<EntityGongGao> {
    public AdapterGongGao(Context context) {
        super(context);
    }

    protected ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = ViewHolder.get(this.mContext, convertView, parent, R.layout.gonggao_item);
        TextView titles = (TextView) holder.findViewById(R.id.tv_gonggao_title);
        TextView contents = (TextView) holder.findViewById(R.id.tv_gonggao_content);
        TextView endDates = (TextView) holder.findViewById(R.id.tv_gonggao_endDate);

        EntityGongGao item = getItem(position);
        contents.setText(item.getContent());
        titles.setText(item.getTitle());
        endDates.setText(item.getEndDate());
        return holder;
    }

    @Override
    protected void onReachBottom() {

    }
}
