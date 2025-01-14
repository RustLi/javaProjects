package org.lwl.test;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionTest {

    public static void main(String[] args) {
        String orderNo = null;
        Collection<String> orderNos = Collections.singletonList(orderNo);
//        Collection<String> orderNos = Collections.singleton(orderNo);
        System.out.println("orderNos = " + orderNos + ", size = " + orderNos.size());

        test1();
    }



    private static void test1() {
        Collection<User> userList = Lists.newArrayList();

        User user = new User();
        user.setName("lwl");
        user.setAge(10);
        userList.add(user);

        User user2 = new User();
        user2.setName("lwl-2");
        user2.setAge(11);
        userList.add(user2);

        User user1 = userList.iterator().next();
        System.out.println("user1 = " + user1);

    }

    private static void test2() {
        List<User> userList = Lists.newArrayList();

        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("lwl");
            user.setAge(i);
            userList.add(user);
        }
        User user = new User();
        user.setName("lwl");
        user.setAge(3);
        userList.add(user);


    }
}
