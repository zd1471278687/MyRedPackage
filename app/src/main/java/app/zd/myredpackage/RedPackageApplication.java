package app.zd.myredpackage;

import android.app.Application;
import android.util.DisplayMetrics;

/**
 * application
 * Created by zhangdong on 2018/3/14.
 */

public class RedPackageApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 获取屏幕尺寸
        DisplayMetrics dm = getResources().getDisplayMetrics();
        if (dm.widthPixels <= dm.heightPixels) {
            AppConfig.setsScreenWidth(dm.widthPixels);
            AppConfig.setsScreenHeight(dm.heightPixels);
        } else { // 确保screen width取实际屏幕宽度
            AppConfig.setsScreenWidth(dm.heightPixels);
            AppConfig.setsScreenHeight(dm.widthPixels);
        }
    }
}
