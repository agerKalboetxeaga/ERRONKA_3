# DordokaRazing

  ## *Java datubase Konexio aplikazioa:*
   ### Helburua
   ##### - Aplikazioa
   
 Aplikazio honek remotoan daukagun [Odoo-ren](https://www.odoo.com/es_ES) datubasearekin [(Postgres)](https://www.postgresql.org/) bidez konektatzen da. Gero [Microsoft SQL Server-era](https://www.microsoft.com/es-es/sql-server/sql-server-downloads) zer exportatu nahi duzun galdetzen dizu. Ondoren konfigurazioa [XML](https://es.wikipedia.org/wiki/Extensible_Markup_Language) konfigurazio fitxategi batean gordetzen da, baita Log-ak ere. Aplikazioa komandoen bidez exekutatzen da. 
     
  ##### - Persistentzia
  Aplikazioa behin exekutatzerakoan aukeratu dituzun aukerak gordetzen ditu eta hurrengoan exekutatzen duzunean aukera berdinak erabiltzeko aukera izango duzu, [fitxategia](https://github.com/MaitaneG/DordokaRazing/blob/main/ERRONKA2/springhibernatejpa/config.xml) xml batean gordetzen da.
  
  ![XML Fitxategia](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/config%20xml%20(2).png)
  ##### - Log-a  
  
   Aplikazioak exportazioa egiten duenean, log  fitxategi bat sortzen du. Fitxategi honetan aplikazioak exportatu dituen datuak erakusten ditu ditu eta, datu-basean datuak gehitu badituzu zenbat eta zeintzuk diren esango dizu.
   
   ![Log fitxategi bat](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/log_erronka2.png)

   ### Abiaraztea:
   Programa abiarazteko Java instalatuta egon behar da Sistema Eragilean (Deskargatzeko eta gida esteka):
          ``` 
         https://www.java.com/es/download/ie_manual.jsp
          ```
          
   Ondoren, jar fitxategia dagoen karpetara joango gara exekutatzeko. Bertan, jar fitxategia komandoen bidez exekutatu behar da:
      1.- ``` java -jar NewTel.jar ``` fitxategia exekutatzeko 
      2.- Ondoren komando desberdinak gehitu behar dira: 
                                                         ```   ERABILTZEKO AUKERAK: ``` 

                                                     -b              |Bezeroak exportatzeko
                                                     -s              |Salmentak exportatzeko
                                                     -p              |Produktuak exportatzeko
                                                     -e              |Erosketak exportatzeko
                                                     -a              |Denak exportatzeko
                                                     -h              |Help 
                                                      
   
   Aurreko konfigurazioa erabiltzea nahi baduzu programa komandu gabe exekutatu behar duzu.
   
   Aplikazioa exekutatu ostean, konfigurazio fitxategia karpeta barruan agertuko da, eta log fitxategia log karpeta barruan.
   
   ![Aplikazioa CMDan exekutatzerakoan](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/cmd%20running.png)
  ### Klase diagrama:
  Gure aplikazioa osatzen dituzten klase eta interfaz desberdinen diagrama:
  
 ![Klase diagrama svg formatuan](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/NewTelXml.svg)
 
 ### Gehigarriak (Extras)
 Abestitxo bat dago eginda non abestia osatzen duten elementu guztiak hariak dira eta hari bakoitzak beraz, soinu desberdin bat zabaltzen du, Horretarako "Clip" libreria erabili dugu. Azkenik festi klaseak soinuak sekuentziatu eta kudeatzen ditu:
 
 ![Hat baten klasea](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/hats.png)
 
 Abestia klaseko zati bat:
 
 ![Abestia class](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/abestia2.png)
 
 ### Iturriak:
  - [StackOverflow](https://stackoverflow.com/) 
  - [Baeldung (Spring Boot)](https://www.baeldung.com/)
  - [Youtube gidak](https://www.youtube.com/)
  - [Hibernate/JPA](https://openwebinars.net/academia/progreso/)
