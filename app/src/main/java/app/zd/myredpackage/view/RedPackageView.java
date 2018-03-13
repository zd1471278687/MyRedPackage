package app.zd.myredpackage.view;

import java.util.List;

import app.zd.myredpackage.bean.FollowRedPackage;

/**
 * 红包列表view
 * Created by zhangdong on 2018/3/11.
 */

public interface RedPackageView {
    void initREdPackageList(List<FollowRedPackage> details);
}
