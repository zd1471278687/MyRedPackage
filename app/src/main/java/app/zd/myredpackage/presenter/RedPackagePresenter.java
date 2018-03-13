package app.zd.myredpackage.presenter;

import android.content.Context;

import app.zd.myredpackage.bean.RedPackageParam;
import app.zd.myredpackage.model.RedPackageModel;
import app.zd.myredpackage.view.RedPackageView;

/**
 * 红包列表
 * Created by zhangdong on 2018/3/11.
 */

public class RedPackagePresenter {
    private Context mContext;
    private RedPackageView mView;
    private RedPackageModel mModel;

    public RedPackagePresenter(Context context, RedPackageView view) {
        this.mContext = context;
        this.mView = view;
        mModel = new RedPackageModel();
    }

    public void createRedPackageList(RedPackageParam packageParam) {
        if (packageParam != null) {
            mModel.spiltRedPackets(packageParam.amount, packageParam.amount.intValue());
        }
    }
}
