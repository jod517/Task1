package User;

public class User {
    private long id;
    private String name;
    private String Soname;


    public User() {
    }

    public User(long id, String name, String Soname){
    this.id = id;
    this.name = name;
    this.Soname = Soname;
    }

    public User(String name, String Soname){
        this.name = name;
        this.Soname = Soname;

    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public  String getName(String name){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSoname(String Soname){
        return Soname;
    }
    public void String

    public void setSoname(java.lang.String soname) {
        this.Soname = soname;
    }
}
