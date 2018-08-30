package hlq.utils;

/**
 * Created by  Huanglinqing on 2018/8/30/030.
 */

public class ChangeUtils {

    //定义音效类型常量

    public static final  int zhengchang = 0;//正常
    public static final int luoli = 1;//萝莉
    public static final int dashu = 2;//大叔
    public static final int jingsong = 3;//惊悚
    public static final int gaoguai = 4;//搞怪
    public static final int kongling = 5;//空灵


    /**
     *
     * @param path
     * @param type
     */
    public native static void change(String path, int type);

    static {
        System.loadLibrary("fmodL");
        System.loadLibrary("fmod");
        System.loadLibrary("sound");
    }
}
