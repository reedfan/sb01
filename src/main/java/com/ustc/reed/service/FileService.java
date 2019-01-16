package com.ustc.reed.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class FileService {
    private static Logger logger = LoggerFactory.getLogger(FileService.class);

//    public String getData(String location) {
//
//
//
//
//
//        StringBuffer sb = new StringBuffer();
//
//
//        try {
//
//            File f = ResourceUtils.getFile(location);
//
//            FileInputStream fip = new FileInputStream(f);
//            // 构建FileInputStream对象
//
//            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
//            // 构建InputStreamReader对象,编码与写入相同
//
//
//            while (reader.ready()) {
//                sb.append((char) reader.read());
//                // 转成char加到StringBuffer对象中
//            }
//            reader.close();
//            // 关闭读取流
//
//            fip.close();
//            // 关闭输入流,释放系统资源
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (sb != null) {
//            return sb.toString();
//        }
//        return null;
//
//
//    }


    public String getData(String location) {
        ClassPathResource classPathResource = new ClassPathResource(location);
        StringBuffer stringBuffer = new StringBuffer();

        try {
            InputStreamReader reader = new InputStreamReader(classPathResource.getInputStream(),"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (bufferedReader.ready()){
                stringBuffer.append((char) reader.read());
            }


//            String tmpContent = null;
//
//            while ((tmpContent = bufferedReader.readLine())!=null){
//                stringBuffer.append(tmpContent);
//            }
            bufferedReader.close();
            reader.close();


        } catch (IOException e) {
            logger.info("IOException",e.toString());
        }
        if(stringBuffer != null){
            return stringBuffer.toString();
        }
        return null;

    }

}

