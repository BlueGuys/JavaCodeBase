package com.blueguy;

import java.io.File;
import java.util.Date;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        for(;;){
            i++;
            if(i>10){
                break;
            }
            System.out.println(new Random(System.currentTimeMillis()).nextInt());
        }
        File file = new File("ssss");
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
