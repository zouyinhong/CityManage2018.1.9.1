package mycity.com.citymanage.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;
import java.util.List;


/**
 *class AdapterBase
 *@author GuoZhuShu
 * create at 2016/6/2 18:26
 * @Description: 适配器基类
 **/
public abstract class AdapterBase<T> extends BaseAdapter {

	protected final List<T> mList = new LinkedList<T>();
	protected LayoutInflater layoutInflater;
	protected Context mContext;
	protected int selectedItem = -1;
	
	
	public AdapterBase(Context context) {
		layoutInflater = LayoutInflater.from(context);
		mContext = context;
	}
	
	public List<T> getList(){
		return mList;
	}
	
	public void remove(int postion){
		if ( (postion > (mList.size() - 1)) || postion < 0) {
			return;
		}
		mList.remove(postion);
		this.selectedItem = -1;
		notifyDataSetChanged();
	}

	public void setList(List<T> list){
		if (list == null) {
			return;
		}
		if (mList != null && mList.size() > 0){
			mList.clear();
		}
		for (T t : list){
			mList.add(t);
		}
		notifyDataSetChanged();
	}
	
	public void appendToList(List<T> list) {
		if (list == null) {
			return;
		}
		mList.addAll(list);
		notifyDataSetChanged();
	}

	public void appendToTopList(List<T> list) {
		if (list == null) {
			return;
		}
		mList.addAll(0, list);
		notifyDataSetChanged();
	}

	public void clear() {
		mList.clear();
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public T getItem(int position) {
		// TODO Auto-generated method stub
		if(position > mList.size()-1){
			return null;
		}
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (position == getCount() - 1) {
			onReachBottom();
		}
		return getViewHolder(position, convertView, parent).getConvertView();
	}
	
	public void setSelectedItem(int selectedItem){
		this.selectedItem = selectedItem;
		notifyDataSetInvalidated();
	}

	protected abstract ViewHolder getViewHolder(int position, View convertView, ViewGroup parent);
	protected abstract void onReachBottom();

	/**
	 * 当做是hashMap
	 */
	public static class ViewHolder {
		private SparseArray<View> views = new SparseArray<View>();
		private View convertView;

		private ViewHolder(View convertView) {
			this.convertView = convertView;
			convertView.setTag(this);
		}

		public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId) {
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
				return new ViewHolder(convertView);
			} else {
				return (ViewHolder) convertView.getTag();
			}
		}

		public View getConvertView() {
			return convertView;
		}

		public void setConvertView(View convertView) {
			this.convertView = convertView;
		}

		public View findViewById(int viewId) {

			View view = views.get(viewId);
			if (view == null) {
				view = convertView.findViewById(viewId);
				views.put(viewId, view);
			}
			return view;
		}

	}

}
