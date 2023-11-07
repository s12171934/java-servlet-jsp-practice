package week3.thu;

public class Student {

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + score;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student && (this.name).equals(((Student) obj).getName()) && (this.score) == ((Student) obj).getScore();
    }
}
