package tacoJDBC;

public class Client {
    private final String name;
    private final int age;
    private final Gender gender;
    private final String footballclub;

    public Client(String name, int age, Client.Gender gender, String footballClub) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.footballclub = footballClub;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public  String getFootballclub(){
        return footballclub;
    }

    public static enum Gender {
        MAN, WOMAN;
    }


}
