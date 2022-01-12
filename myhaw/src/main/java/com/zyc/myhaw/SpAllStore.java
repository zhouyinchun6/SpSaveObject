package com.zyc.myhaw;

import android.content.Context;

import java.util.Hashtable;
import java.util.Map;

/**
 * author Zyc on date 2022/1/11
 * <p>
 * description: 在Hawk的基础上修改而来，修复了他不能用#字符、bean文件移动位置后读取数据为null的bug，支持配置多个SharedPreferences，并去除了加密、Serializer模块，
 * 数据超大的应单独放一个SharedPreferences文件，已读取提高性能
 * <p>
 */
public class SpAllStore {

    private SpAllStore() {
        // no instance
    }

    //SharedPreferences文件和Hawk对应关系
    static Map<String, Hawk> hawkMap = new Hashtable<>();


    /**
     * 初始化
     *
     * @param context     ApplicationContext will be used
     * @param spFileNames SharedPreferences文件名集合
     */
    public static void init(Context context, String... spFileNames) {
        hawkMap.clear();
        for (String spName : spFileNames) {
            Hawk hawk = Hawk.init(context, spName).build();
            hawkMap.put(spName, hawk);
        }
    }


    /**
     * @param spFileName SharedPreferences文件名
     * @return Hawk
     */
    public static Hawk getHawk(String spFileName) {
        return hawkMap.get(spFileName);
    }


    /**
     * @return 清空所有SharedPreferences文件数据
     */
    public static boolean clearAllHawk() {
        boolean deleteSucceed = true;
        for (String spName : hawkMap.keySet()) {
            Hawk hawk = hawkMap.get(spName);
            assert hawk != null;
            deleteSucceed = deleteSucceed & hawk.deleteAll(); //有一个不成功都返回不成功
        }
        return deleteSucceed;
    }
}
