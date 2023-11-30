package function;

import bookManager.BookManager;
import bookManager.book.Book;
import userManager.UM;
import userManager.user.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
               String info = reader.readLine();
               String[] userInfo = info.split("#")[0].split(",");
               String[] books;
               try {
                   books = info.split("#")[1].split(",");
               } catch (Exception e){
                   books = new String[]{""};
               }
               ArrayList<String> bookInfo = new ArrayList<>(List.of(books));
               um.addUser(userInfo,bookInfo);
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
            String bookInfo = "";

            ArrayList<String> books = user.getCheckOutBook();
            for(String book : books){
                bookInfo += book + ",";
            }
            if(bookInfo.charAt(0)==',')bookInfo = bookInfo.substring(1);
            if(bookInfo.charAt(bookInfo.length()-1)==',')bookInfo = bookInfo.substring(0,bookInfo.length()-1);

            String userInfo = id + "," + pw + "," + name + "," + sex + "," + phonNum + "#" + bookInfo;
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
