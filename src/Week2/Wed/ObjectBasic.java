package Week2.Wed;

public class ObjectBasic {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setName("SON");
        student2.setName("KIM");
        System.out.println(student1.getName());
        System.out.println(student2.getName());
    }
}
