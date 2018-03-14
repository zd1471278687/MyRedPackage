package app.zd.myredpackage;

/**
 * app config
 * Created by zhangdong on 2017/4/8.
 */
public class AppConfig {
    //屏幕信息
    public static int sScreenWidth;
    public static int sScreenHeight;
    public static float sScreenSize;

    public static int getsScreenWidth() {
        return sScreenWidth;
    }

    public static void setsScreenWidth(int sScreenWidth) {
        AppConfig.sScreenWidth = sScreenWidth;
    }

    public static int getsScreenHeight() {
        return sScreenHeight;
    }

    public static void setsScreenHeight(int sScreenHeight) {
        AppConfig.sScreenHeight = sScreenHeight;
    }

    public static float getsScreenSize() {
        return sScreenSize;
    }

    public static void setsScreenSize(float sScreenSize) {
        AppConfig.sScreenSize = sScreenSize;
    }
}
