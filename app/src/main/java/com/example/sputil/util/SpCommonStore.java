package com.example.sputil.util;

import com.zyc.myhaw.Hawk;
import com.zyc.myhaw.SpAllStore;

/**
 * author Zyc on date 2022/1/12
 * <p>
 * description:
 */
public final class SpCommonStore {

    public static final Hawk hawk = SpAllStore.getHawk(SpFileName.COMMON_FILE);

    /**
     * @return 清空User数据
     */
    public static boolean clear() {
        return hawk.deleteAll();
    }


    public static final class Key {

        public static final String IS_FIRST = "isFirst";

    }

}
