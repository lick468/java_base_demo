package main.java.demo;

import main.java.demo.domain.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：lichuankang
 * @date ：2021/10/25 10:59
 * @description ：lamda示例
 */
public class LamdaMain {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        initUserList(userList);
        System.out.println("用户列表数据----" + userList);
        // 1.获取所有用户名称，并放到一个新的列表中
        List<String> usernameList = userList.stream().map(User::getUsername).collect(Collectors.toList());
        System.out.println("用户名称列表----" + usernameList);
        // 2.按照年龄进行排序，升序排列
        System.out.println("升序排序前----" + userList);
        userList = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println("升序排序后----" + userList);
        // 3.按照年龄进行排序，降序排列
        System.out.println("降序排序前----" + userList);
        userList = userList.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        System.out.println("降序排序后----" + userList);
        // 4.根据年龄分组，相同年龄的分到同一组
        Map<Integer, List<User>> ageMap = userList.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println("年龄分组名单----" + ageMap);
        // 5.根据性别分区，相同性别的分到一组，key只有true和false
        Map<Boolean, List<User>> genderMap = userList.stream().collect(Collectors.partitioningBy(user -> 1 == user.getGender()));
        System.out.println("男生组名单----" + genderMap.get(true));
        System.out.println("女生组名单----" + genderMap.get(false));
    }


    public static List<User> initUserList(List<User> userList) {
        Random random = new Random();
        for (int i = 1; i < 6; i++) {
            User user = new User();
            user.setUsername("测试" + i + "号");
            user.setAge(random.nextInt(100));
            user.setGender(random.nextInt(2));
            userList.add(user);
        }

        return userList;
    }
}
