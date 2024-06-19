package Other_Topics;
import java.util.*;
import java.util.stream.Collectors;

class Students{
    private String name;
    public Students(String name) {
        this.name = name;
    }
    public Students() {
    }
    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private int age;
    public Students(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
public class Stream_01 {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(2,35,6,3,6,3,5);
        //Stream API
        int o1=list.stream().map(n-> n*2).reduce(0,(i,j)->i+j); 
        System.out.println(o1);

        //Parallel Stream
        int o2=list.parallelStream().map(i->i*2).mapToInt(i-> i).sum();
        System.out.println(o2);

        //Optional Class
        List<String> names=Arrays.asList("abc","cde","xyz");
        Optional<String> name=names.stream().filter(str-> str.contains("c")).findFirst();
        System.out.println(name.get());
        //or 
        String name2=names.stream().filter(str-> str.contains("c")).findFirst().orElse("null");
        System.out.println(name2);

        //Method Reference
        List<String> uName=names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uName);

        //Constructor Refrence
        List<Students> stu=new ArrayList<>();
        stu=names.stream().map(Students::new).collect(Collectors.toList());
        System.out.println(stu);

    }
}
