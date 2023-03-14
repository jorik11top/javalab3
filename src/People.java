import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class People {
    private final String[] NSPAndBorn;

    public People(String str){
        NSPAndBorn = str.split(" ");
    }

    public String getFullNameAndBorn(){
        return String.join(" ",NSPAndBorn);
    }

    public String getSurname(){
        return NSPAndBorn[0];
    }

    public String getName(){
        return NSPAndBorn[1];
    }

    public String getPatronymic(){
        return NSPAndBorn[2];
    }

    public String getBornAge(){
        return NSPAndBorn[3];
    }

    public int getAge(){
        LocalDate born = LocalDate.parse(NSPAndBorn[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate today = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(born,today);
    }

    public String getSex(){
        String word = getPatronymic().substring(getPatronymic().length()-1);
        if (word.equals("ч")){
            return "Мужчина";
        }
        else {
            return "Женщина";
        }
    }

    private String formatYear(int age){
        if (age>4 & age < 21){
            return getAge() + " лет";
        }
        int con = age%10;
        return switch (con) {
            case 1 -> getAge() + " год";
            case 2,3,4 -> getAge() + " года";
            default -> getAge() + " лет";
        };


    }

    public String getUserInfoFormat(){
        return getSurname()+" "+getName().charAt(0)+"."+getPatronymic().charAt(0)+". пол:"+getSex()+" возраст:"+formatYear(getAge());
    }




}
