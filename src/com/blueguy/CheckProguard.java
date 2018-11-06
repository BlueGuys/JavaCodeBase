package com.blueguy;


import java.io.*;
import java.util.ArrayList;

/**
 * 绝对路径用法：/Users/wangning/Code/github/AndroidBase/base
 * 相对路径用法：.  getAllFilePath(".");
 */
public class CheckProguard {

    private static ArrayList<String> nameList = new ArrayList<>();


    public static void main(String[] args) {
        //获取指定目录下的所有文件路径
        ArrayList<String> paths = getAllFilePath("/Users/wangning/Code/JDB/JDB/JDBApp-Android");
        //添加拦截器自己要检测文件
        ArrayList<String> filterPath = getFilterPath(paths);
        //读取文件
        for (String path : filterPath) {
            analysisClass(path);
        }
    }

    /**
     * 获取指定目录下的所有文件
     */
    private static ArrayList<String> getAllFilePath(String packageName) {
        File allFile = new File(packageName);
        if (!allFile.exists()) {
            throw new IllegalArgumentException("文件夹不存在");
        }
        File[] files = allFile.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    getAllFilePath(file.getAbsolutePath());
                } else {
                    String path = file.getAbsolutePath();
                    nameList.add(path);
                }
            }
        }
        return nameList;
    }

    /**
     * 获取感兴趣的类(过滤器)
     */
    private static ArrayList<String> getFilterPath(ArrayList<String> paths) {
        ArrayList<String> list = new ArrayList<>();
        for (String path : paths) {
            if (path == null || path.length() == 0) {
                continue;
            }
            if (!path.endsWith(".java")) {
                continue;
            }
            if (path.contains("build")) {
                continue;
            }
            if (!isResultJava(path)) {
                continue;
            }
            list.add(path);
        }
        return list;
    }

    /**
     * 如果是你感兴趣的类就返回true
     */
    private static boolean isResultJava(String path) {
        if (path == null || path.length() == 0) {
            return false;
        }
        //先读取整个文件，看是否是想要检查的类
        String encoding = "UTF-8";
        File file = new File(path);
        Long filelength = file.length();
        byte[] fileContent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            String content = new String(fileContent, encoding);
            in.close();
            return content.length() > 0 && content.contains("extends JDBBaseResult");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 分析该类的内部类是否实现了NoProguard接口
     */
    private static void analysisClass(String path) {
        if (path == null || path.length() == 0) {
            return;
        }
        try {
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String str;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if ((str = br.readLine()) != null) {//逐行分析
                    if (str.contains(" class ")) {
                        if (!str.contains("JDBBaseResult") && !str.contains("NoProguard") && !str.contains("JDBBaseListResult")) {//如果包含JDBBaseResult
                            String className = path.substring(path.lastIndexOf("/") + 1, path.length() - 5);
                            String lineCount = String.valueOf(i);
                            String line1 = "----------------------------------------------------------------------------------------";
                            String line2 = className + ":(line" + lineCount + ")";
                            String line3 = str.trim();
                            System.out.println(line1);
                            System.out.println(line2);
                            System.out.println(line3);
                        }
                    }
                } else {
                    break;
                }
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}