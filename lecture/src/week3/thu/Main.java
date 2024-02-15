package week3.thu;

public class Main {
    public static void main(String[] args) {
        Member member1 = new Member("asd");
        Member member2 = new Member("asd");
        System.out.println(member1.equals(member2));
        try {
            System.out.println(Class.forName("week3.thu.Member").getClass());
        } catch (Exception e){}
    }
}
