package com.ustc.reed.utils;

import java.util.UUID;

public class UUIDUtils {

    //生成文件名
    public  static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


}
