package com.blueguy.structure;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator
 */
public class Demo05 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("在世间，本就是各人下雪，各人有各人的隐晦与皎洁");
        list.add("人生是个长局，生老病死而已。有人弃棋，有人做泥荷做清溪，有人成为风雨里的一行诗句。");
        list.add("无非野合与破鞋，何必脏了风花雪月…");

        String str = "人生是个长局，生老病死而已。有人弃棋，有人做泥荷做清溪，有人成为风雨里的一行诗句。";
        ergodic(list);
    }

    private static void ergodic(Iterable<String> data) {
        if (data == null) {
            return;
        }
        Iterator<String> iterator = data.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}




