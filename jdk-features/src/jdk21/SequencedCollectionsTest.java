package jdk21;

import java.util.ArrayList;

/**
 * Sequenced Collections(有序集合) API 练习.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/11 11:20
 */
public class SequencedCollectionsTest {

    static void main(String[] args) {
        var sequencedList = new ArrayList<String>();
        sequencedList.addFirst("张三");
        sequencedList.addLast("李四");
        sequencedList.add("王五");
        System.out.println(sequencedList.getFirst());
        System.out.println(sequencedList.getLast());
        System.out.println(sequencedList.reversed().getFirst());
    }

}
