import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;


public class People {
    private String name;
    private String surname;
    private String patronymic;
    private String born;

    /**Конструктор
     * @param str - Строка Формата <p>"Фамилия Имя Отчество дд.мм.гггг"<p/>
     * @throws  {@link IOException}
    */
    public People(String str)throws IOException {
        String[] NSPAndBorn = str.split(" ");
        try {
            if(NSPAndBorn.length != 4){
                throw new IOException();
            }
            else{
                surname = NSPAndBorn[0];
                name = NSPAndBorn[1];
                patronymic = NSPAndBorn[2];
                born = NSPAndBorn[3];
            }
        }catch (IOException e){
            System.out.println("Incorrect format of the entered data");
        }

    }


    public String getSurname(){
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getPatronymic(){
        return this.patronymic;
    }

    public String getBornAge(){
        return this.born;
    }

    /**
     *
     * @return Число int(Кол-во полных лет) или -1 в случае неправильного формата введённых данных
     * @throws DateTimeParseException
     */
    public int getAge() throws DateTimeParseException {
        try {
            LocalDate born = LocalDate.parse(getBornAge(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate today = LocalDate.now();
            return (int) ChronoUnit.YEARS.between(born, today);
        }catch (DateTimeParseException e){
           System.out.println("The date of birth format is incorrect");
           return -1;
        }
    }
    /**
     * @return {@link String} пол человек "Мужчина" или "Женщина"
     */
    public String getSex(){
        String word = getPatronymic().substring(getPatronymic().length()-1);
        if (word.equals("ч")){
            return "Мужчина";
        }
        else {
            return "Женщина";
        }
    }

    /**
     * Приватная функция для правильно вывода возраста
     * @param age кол-лет
     */
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

    /**
     * Основная функция
     * @return {@link  String} формата "Фамилия И.О. пол:() возраст:() лет/год/года "
     * @throws NullPointerException
     */
    public String getUserInfoFormat() throws NullPointerException{
        try {
            return getSurname()+" "+getName().charAt(0)+"."+getPatronymic().charAt(0)+". пол:"+getSex()+" возраст:"+formatYear(getAge());
        }
        catch (NullPointerException e){
            System.out.println("Object was created incorrectly");
            return null;
        }
    }




}
