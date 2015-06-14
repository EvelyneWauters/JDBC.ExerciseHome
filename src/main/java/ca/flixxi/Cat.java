package ca.flixxi;

/**
 * Created by Flyne on 13/06/2015.
 */
public class Cat {
    private Integer id;
    private String name;
    private int age;
    private String k;

    public Cat(Integer id, String name, int age, String k) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.k = k;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", k=" + k +
                '}';
    }
}
