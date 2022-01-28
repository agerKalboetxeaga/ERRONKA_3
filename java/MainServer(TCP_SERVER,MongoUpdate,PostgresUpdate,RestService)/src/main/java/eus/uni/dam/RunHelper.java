package eus.uni.dam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * This component is used when this application is launched as a jar.
 * @author kalboetxeaga.ager
 *
 */
@Component
public class RunHelper {
         
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
