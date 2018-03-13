package app.zd.myredpackage.baseadapter.delegate;


import app.zd.myredpackage.baseadapter.ViewHolder;

public interface ItemViewDelegate<T> {

    public abstract int getItemViewLayoutId();

    public abstract boolean isForViewType(T item, int position);

    public abstract void convert(ViewHolder holder, T t, int position);
}
