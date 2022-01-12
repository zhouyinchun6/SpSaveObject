package com.example.sputil;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sputil.bean.User;
import com.example.sputil.util.SpCommonStore;
import com.example.sputil.util.SpFileName;
import com.example.sputil.util.SpUserStore;
import com.zyc.myhaw.SpAllStore;

import java.util.ArrayList;
import java.util.List;


/**
 * author Zyc on date 2022/1/11
 * <p>
 * description:
 */
public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", "10"));
        userList.add(new User("李四", "11"));

        SpAllStore.init(this, SpFileName.USER_FILE, SpFileName.COMMON_FILE); //全局初始化

        SpAllStore.clearAllHawk(); //清空所有spFile数据

        SpCommonStore.hawk.put(SpCommonStore.Key.IS_FIRST, true); //存Boolean
        SpUserStore.hawk.put(SpUserStore.Key.USER, new User("小明", "#15"));  //存对象
        SpUserStore.hawk.put(SpUserStore.Key.USER_LIST, userList); //存集合

        boolean b = SpCommonStore.hawk.getBoolean(SpCommonStore.Key.IS_FIRST);//取Boolean
        User save_user = SpUserStore.hawk.getObject(SpUserStore.Key.USER, User.class); //取对象
        List<User> save_users = SpUserStore.hawk.getList(SpUserStore.Key.USER_LIST, User.class); //取集合

    }
}
