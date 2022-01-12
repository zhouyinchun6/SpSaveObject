package com.example.sputil.util;

import com.example.sputil.bean.User;
import com.zyc.myhaw.Hawk;
import com.zyc.myhaw.SpAllStore;


/**
 * author Zyc on date 2022/1/12
 * <p>
 * description:
 */
public final class SpUserStore {

    public static final Hawk hawk = SpAllStore.getHawk(SpFileName.USER_FILE);

    /**
     * @return 清空User数据
     */
    public static boolean clear() {
        return hawk.deleteAll();
    }


    public boolean saveUser(User user) {
        return hawk.put(Key.USER, User.class);
    }

    public User getUser() {
        return hawk.getObject(Key.USER, User.class);
    }


    public static final class Key {

        public static final String USER = "user";

        public static final String USER_LIST = "user_list";
    }

}
