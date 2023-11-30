package function;

import userManager.UM;
import userManager.user.User;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RWUser {
    static String userId;
    static String path = "C:\\Users\\ast08\\IdeaProjects\\bookManager\\data\\users\\";
    public static void readUsers(UM um){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path + "userIds.txt", StandardCharsets.UTF_8));
            userId = reader.readLine();
            if(userId == null)userId = "";
            String[] userIds = userId.split(",");

            for(String id : userIds){
               reader = new BufferedReader(new FileReader(path + "user_" + id + ".txt", StandardCharsets.UTF_8));
               String[] userInfo = reader.readLine().split(",");
               um.addUser(userInfo);
            }
        } catch (Exception e) {
        }
    }
    public static void addUser(User user){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "userIds.txt", StandardCharsets.UTF_8));
            userId += "," + user.getId();
            writer.write(userId);
            writer.flush();
            writer.close();
        } catch (Exception e){}
    }
    public static void writeUser(User user){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "user_" + user.getId() + ".txt", StandardCharsets.UTF_8));

            String id = user.getId();
            String pw = user.getPw();
            String name = user.getName();
            String sex = user.getSex();
            String phonNum = user.getPhoneNum();
            String userInfo = id + "," + pw + "," + name + "," + sex + "," + phonNum;
            writer.write(userInfo);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }
    public static void deleteUser(User user){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "userIds.txt", StandardCharsets.UTF_8));
            userId = userId.replace(user.getId(),"");
            userId = userId.replace(",,",",");
            if(userId.charAt(0)==',')userId = userId.substring(1);
            if(userId.charAt(userId.length()-1)==',')userId = userId.substring(0,userId.length()-1);
            writer.write(userId);
            writer.flush();
            writer.close();

            File file = new File(path + "user_" + user.getId() + ".txt");
            if(file.exists())file.delete();

        } catch (Exception e) {
        }
    }
}
