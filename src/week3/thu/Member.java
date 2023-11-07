package week3.thu;

public class Member {
    private String id;

    public Member(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
            return obj instanceof Member && (this.id).equals(((Member) obj).getId());
    }
}
