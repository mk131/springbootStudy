package com.mk.study.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author  lldzobc
 */
public class Gardener {
    public static String Apple;
    public static String Grape;

    public static void main(String[] args) throws Exception {
        Fruit fruit0 = Gardener.getFruit(Apple);
        fruit0.grow();
        Fruit fruit1 = Gardener.getFruit(Grape);
        fruit1.harveset();
    }

    //加载驱动，在程序启动的时候就被加载且只执行一次
    static {
        try {
            //创建配置文件对象
            Properties properties = new Properties();
            //通过类获取流的对象
            InputStream in = Gardener.class.getClassLoader().getResourceAsStream("Fruit.properties");
            //通过字节输入流in读取里边的键值对
            properties.load(in);
            //获取键对应的值
            Apple = properties.getProperty("Apple");
            //获取键对应的值
            Grape = properties.getProperty("Grape");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Fruit getFruit(String fruit) throws Exception {
        Class<?> c = Class.forName(fruit);
        return (Fruit) c.newInstance();

//        if ("apple".equalsIgnoreCase(fruit))
//        {
//            return new Apple();
//        }
//        else if ("grape".equalsIgnoreCase(fruit))
//        {
//            return new Grape();
//        }
//        else
//        {
//            return null;
//        }

    }

}
