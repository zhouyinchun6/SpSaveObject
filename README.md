轻量级数据存取工具类：
    1、支持存取任何数据类型。
    2、多个SharedPreferences文件管理。

集成：
    方式1：可导入编译好的jar包(导入jar包app要依赖gson)
    implementation 'com.google.code.gson:gson:2.8.8'
    implementation files('libs\\mysp.jar')
    
    方式2：导入工程
    implementation project(path: ':myhaw')
    
使用：
     SpAllStore.init(this, SpFileName.USER_FILE, SpFileName.COMMON_FILE); //全局初始化
     
     SpCommonStore.hawk.put(SpCommonStore.Key.IS_FIRST, true); //存Boolean
     boolean b = SpCommonStore.hawk.getBoolean(SpCommonStore.Key.IS_FIRST);//取Boolean
        
     SpUserStore.hawk.put(SpUserStore.Key.USER, new User("小明", "#15"));  //存对象
     User save_user = SpUserStore.hawk.getObject(SpUserStore.Key.USER, User.class); //取对象
        
     List<User> userList = new ArrayList<>();
     userList.add(new User("张三", "10"));
     userList.add(new User("李四", "11"));
     SpUserStore.hawk.put(SpUserStore.Key.USER_LIST, userList); //存集合
     List<User> save_users = SpUserStore.hawk.getList(SpUserStore.Key.USER_LIST, User.class); //取集合
     
     SpAllStore.clearAllHawk(); //清空所有spFile数据
     
     具体用法参考demo

    
        

        
     
     
