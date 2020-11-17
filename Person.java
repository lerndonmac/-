import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String id;
    private String lastName;
    private String firstName;
    private String otchestvo;
    private Date dataOfBorn;
    private String age;

    public Person(String id, String lastName, String firstName, String otchestvo, Date dataOfBorn) {
        Date nowDate = new Date();
        String age = String.valueOf(((nowDate.getTime()-dataOfBorn.getTime())/1000/60/60/24/365));

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.otchestvo = otchestvo;
        this.dataOfBorn = dataOfBorn;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public Date getDataOfBorn() {
        return dataOfBorn;
    }

    public String dateToString(Date date){
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", getId(), getLastName(), getFirstName(), getOtchestvo());
    }
}
