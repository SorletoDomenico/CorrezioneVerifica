/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correzioneverifica;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author palazzolo_thomas
 */
public class CorrezioneVerifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here

        String username, password, key, token, str;
        Scanner tastiera = new Scanner(System.in);

        System.out.println("[0]-Registrati\n[1]-getToken\n[2]-setString\n[3]-getString\n[4]-deleteString\n[5]-getKeys\n");
        SaveStrings sv = new SaveStrings();
        while (true) {
            int numero = tastiera.nextInt();

            switch (numero) {
                case 0:
                //0: registrazione
                    System.out.println("Registrazione");
                    System.out.println("Username: ");
                    username = tastiera.next();

                    System.out.println("Password: ");
                    password = tastiera.next();

                    sv.register(username, password);

                    System.out.println("Registrazione completata:" + "User:" + username + " Pass:" + password);

                    break;
                case 1:
//                1: getToken
                    System.out.println("getToken");
                    System.out.println("Username: ");
                    username = tastiera.next();

                    System.out.println("Password: ");
                    password = tastiera.next();

                    token = sv.getToken(username, password);              
                    break;
                    
                      case 2:
//                1: setString
                    System.out.println("setString");
                    System.out.println("Token: ");
                    
                   

                    System.out.println("Password: ");
                    password = tastiera.next();

                    
                    
                    break;

            }

        }

    }
}
