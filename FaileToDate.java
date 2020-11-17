import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class FaileToDate {
    public static void main(String[] args) throws IOException, ParseException {
        //reader
        List<Person> personlist = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\42t_java\\listStudents.txt"))){
        while (reader.ready()){
            String tmp = reader.readLine();
            personlist.add(getPerson(tmp));//запись строки из файла в массив через метод преобразования в объект
        }}
        //writer
        String fileName = "C:\\42t_java\\listStudentsRight.txt";
        File file = new File(fileName);
        file.createNewFile();
        try( FileWriter fw = new FileWriter(file);){
           for(Person person : personlist){
               fw.write(person.toString());
               fw.write("\n");
           }
        }
        // seeker od age
        try(var scaner = new Scanner(System.in);) {
            System.out.println("введите ID студента");
            String idStudenta = scaner.nextLine();
            for (Person p :personlist) {
                if (idStudenta.equals(p.getId())){
                    System.out.printf("студент %s %s %s имеет возраст: %S лет",
                            p.getLastName(),
                            p.getFirstName(),
                            p.getOtchestvo(),
                            p.getAge());
                }
            }
        }
    }
    public static Person getPerson(String line) throws ParseException {//преобразование из строки в файле в объект
        String[] str = line.split(" ");
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        Date date;
        date = df.parse(str[4]);
        Person person = new Person(str[0],str[1],str[2],str[3],date);
        return person;
    }
}