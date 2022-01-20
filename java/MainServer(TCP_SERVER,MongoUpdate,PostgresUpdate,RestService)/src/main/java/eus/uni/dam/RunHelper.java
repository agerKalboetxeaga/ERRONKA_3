package eus.uni.dam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RunHelper {
//    @Value("\t -b \t\t |Bezeroak exportatzeko\n" +
//            "\t -s \t\t |Salmentak exportatzeko\n" +
//            "\t -p \t\t |Produktuak exportatzeko\n" +
//            "\t -a \t\t |Denak exportatzeko" +
//            "\t -h/-help")
    private String helper;

    @PostConstruct
    public void init() {
        // @formatter:off
        helper = "\t\t ERABILTZEKO MODUA:\n\n" +
                "\t -f or --file  <jsonfile>.json\t|json fitxategia postgresera igotzeko\n" +
                "\t -f or --file  <jsonfile1>.json <jsonfile2>.json [...]\t|json fitxategiak postgresera igotzeko\n" +
                "\t -h \t\t |Help";
        // formatter:on
    }


    public String getHelper() {
        return helper;
    }
}
