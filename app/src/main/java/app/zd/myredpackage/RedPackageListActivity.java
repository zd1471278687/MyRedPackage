package app.zd.myredpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.List;

import app.zd.myredpackage.baseadapter.CommonAdapter;
import app.zd.myredpackage.baseadapter.ViewHolder;
import app.zd.myredpackage.bean.FollowRedPackage;
import app.zd.myredpackage.bean.RedPackageParam;
import app.zd.myredpackage.commonview.ViewGroupListView;
import app.zd.myredpackage.presenter.RedPackagePresenter;
import app.zd.myredpackage.utils.NumberUtil;
import app.zd.myredpackage.view.RedPackageView;

/**
 * 红包列表
 * Created by zhangdong on 2018/3/9.
 */

public class RedPackageListActivity extends Activity implements RedPackageView {
    private TextView mDescribeTv;
    private ViewGroupListView mRedPackageVglv;
    private RedPackageParam mRedPackageData;
    private RedPackagePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_package_list);
        getPageIntent();
        initView();
        initData();
    }

    private void getPageIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            mRedPackageData = (RedPackageParam) intent.getSerializableExtra(GlobalConstant.IntentConstant.RED_PACKAGE_PARAM);
        }
    }

    private void initView() {
        mRedPackageVglv = (ViewGroupListView) findViewById(R.id.vglv_red_package);
        mDescribeTv = (TextView) findViewById(R.id.tv_describe);
        if (mRedPackageData != null) {
            mDescribeTv.setText(mRedPackageData.describe);
        }
    }

    private void initData() {
        mPresenter = new RedPackagePresenter(this, this);
        mPresenter.createRedPackageList(mRedPackageData);
    }

    @Override
    public void initREdPackageList(List<FollowRedPackage> details) {
        mRedPackageVglv.setAdapter(new CommonAdapter<FollowRedPackage>(this, R.layout.list_item_follow_red_package, details) {
            @Override
            protected void convert(ViewHolder viewHolder, FollowRedPackage item, int position) {
                if (item == null) {
                    return;
                }
                viewHolder.setText(R.id.tv_user_name, item.nickName);
                viewHolder.setText(R.id.tv_money, getString(R.string.chinese_yuan, NumberUtil.TWO_FORMAT.format(item.amount)));
                viewHolder.setText(R.id.tv_time, item.time);
            }
        });
    }
}
