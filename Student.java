
package DSASE;

public class Student {
    private String name;
    private int age;
    private String dep;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student(String name, int age, String dep, long id) {
        this.name = name;
        this.age = age;
        this.dep = dep;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + ", dep=" + dep + ", id=" + id + '}';
    }
    
    
    
}
