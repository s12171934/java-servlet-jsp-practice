package userManager.userRepo;

import userManager.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserArrayList implements UserRepo {
    private ArrayList<User> userList = new ArrayList<>();
    @Override
    public List<User> getUserList(){
        return userList;
    }
    @Override
    public void addUser(User user) {
        userList.add(user);
    }
    @Override
    public User getUser(String id) {
        return userList.stream().filter(user -> user.getId().equals(id)).toArray(User[]::new)[0];
    }
    @Override
    public void removeUser(String id) {
        userList.removeIf(user -> user.getId().equals(id));
    }
    @Override
    public void sortUserList(String type, boolean asc) {
        int ascInt = asc? 1: -1;
        switch (type){
            case "id":
                userList.sort((user1,user2) -> Integer.compare(ascInt * user1.getId().compareTo(user2.getId()),0));
                break;
            case "pw":
                userList.sort((user1,user2) -> Integer.compare(ascInt * user1.getPw().compareTo(user2.getPw()),0));
                break;
            case "name":
                userList.sort((user1,user2) -> Integer.compare(ascInt * user1.getName().compareTo(user2.getName()),0));
                break;
            case "sex":
                userList.sort((user1,user2) -> Integer.compare(ascInt * user1.getSex().compareTo(user2.getSex()),0));
                break;
            case "phoneNum":
                userList.sort((user1,user2) -> Integer.compare(ascInt * user1.getPhoneNum().compareTo(user2.getPhoneNum()),0));
                break;
            default:
                break;
        }
    }
    @Override
    public List<User> searchUser(String type, String search) {
        ArrayList<User> userList2;
        switch (type){
            case "id":
                userList2 = new ArrayList<>(List.of(userList.stream().filter(user -> user.getId().contains(search)).toArray(User[]::new)));
                return userList2;
            case "pw":
                userList2 = new ArrayList<>(List.of(userList.stream().filter(user -> user.getPw().contains(search)).toArray(User[]::new)));
                return userList2;
            case "name":
                userList2 = new ArrayList<>(List.of(userList.stream().filter(user -> user.getName().contains(search)).toArray(User[]::new)));
                return userList2;
            case "sex":
                userList2 = new ArrayList<>(List.of(userList.stream().filter(user -> user.getSex().contains(search)).toArray(User[]::new)));
                return userList2;
            case "phoneNum":
                userList2 = new ArrayList<>(List.of(userList.stream().filter(user -> user.getPhoneNum().equals(search)).toArray(User[]::new)));
                return userList2;
            default:
                return null;
        }
    }
}
