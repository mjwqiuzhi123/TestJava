package com.mjw.path.test;
import java.io.File;
 
public class TestDemo {
    public static void main(String[] args) throws Exception {
        File file = new File(".");
        // 参数"."点表示当前路径
        // new File(".") 表示用当前路径 生成一个File实例,!!!并不是表达创建一个 . 文件
        String path = file.getCanonicalPath();
        System.out.println(path);
        //输出file代表的路径
         
         
        File file2 = new File("bcde.txt");
        boolean b = file2.createNewFile();//这才是创建一个名为bcde.txt的文件  windows不支持文件名为一个点"."
        if(b){
            System.out.println("在当前路径"+path+"下创建文件bcde.txt成功");
        }else{
            //如bcde.txt已经存在,再次创建就会失败,
            System.out.println("在当前路径"+path+"下创建文件bcde.txt失败");
        }
    }
}