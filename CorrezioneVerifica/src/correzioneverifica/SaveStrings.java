/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correzioneverifica;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author sorleto_domenico
 */
public class SaveStrings {

    private String download(String url_str) throws MalformedURLException, IOException {
        URL url = new URL(url_str);
        Scanner inRemote = new Scanner(url.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();
        inRemote.close();

        return content;
    }

    //Registrazione
    public String register(String Username, String Password) throws UnsupportedEncodingException, MalformedURLException, IOException {
        String userEnc = URLEncoder.encode(Username, "UTF-8");
        String passEnc = URLEncoder.encode(Password, "UTF-8");

        //creo la connessione con il metodoto register.php
        String d = download("http://savestrings.netsons.org/SaveStrings/register.php?username=" + userEnc + "&password=" + passEnc);

        //dato che è un jason obj 
        JSONObject o = new JSONObject(d);

        String status = o.getString("status");
        if (status.equals("error")) {
            String message = o.getString("message");
            return message;
        } else {
            String result = o.getString("result");
            return result;
        }

    }

    public String getToken(String Username, String Password) throws UnsupportedEncodingException, IOException {
        String userEnc = URLEncoder.encode(Username, "UTF-8");
        String passEnc = URLEncoder.encode(Password, "UTF-8");

        //creo la connessione con il metodoto getToken.php
        String d = download("http://savestrings.netsons.org/SaveStrings/getToken.php?username=" + userEnc + "&password=" + passEnc);

        JSONObject o = new JSONObject(d);
        Boolean status = o.getBoolean("status");

        if (!status) {
            String message = o.getString("message");
            return message;
        } else {
            JSONObject result = o.getJSONObject("result");
            String token = result.getString("token");
            return token;
        }
    }

    public String setString(String Token, String Key, String string) throws UnsupportedEncodingException, IOException {

        String tokenEnc = URLEncoder.encode(Token, "UTF-8");
        String keyEnc = URLEncoder.encode(Key, "UTF-8");
        String stringEnc = URLEncoder.encode(string, "UTF-8");

        //creo la connessione con il metodoto setString.php
        String d = download("http://savestrings.netsons.org/SaveStrings/setString.php?token=" + tokenEnc + "&key=" + keyEnc + "&string=" + stringEnc);

        JSONObject o = new JSONObject(d);
        String status = o.getString("status");

        if (status.equals("error")) {
            String message = o.getString("message");
            return message;
        } else {
            String result = o.getString("result");
            return result;
            //0d801772dc0ba29edf76d06214436241

        }
    }

    public String getString(String Token, String Key) throws UnsupportedEncodingException, IOException {
        String tokenEnc = URLEncoder.encode(Token, "UTF-8");
        String keyEnc = URLEncoder.encode(Key, "UTF-8");

        //creo la connessione con il metodoto deleteString.php
        String d = download("http://savestrings.netsons.org/SaveStrings/getString.php?token=" + tokenEnc + "&key=" + keyEnc);

        JSONObject o = new JSONObject(d);
        String status = o.getString("status");

        if (status.equals("error")) {
            String message = o.getString("message");
            return message;
        } else {
            JSONObject result = o.getJSONObject("result");
            String key = result.getString("key");
            String string = result.getString("string");
            return key + "-" + string;
        }

    }

    public String deleteString(String Token, String Key) throws UnsupportedEncodingException, IOException {
        String tokenEnc = URLEncoder.encode(Token, "UTF-8");
        String keyEnc = URLEncoder.encode(Key, "UTF-8");

        //creo la connessione con il metodoto deleteString.php
        String d = download("http://savestrings.netsons.org/SaveStrings/deleteString.php?token=" + tokenEnc + "&key=" + keyEnc);

         JSONObject o = new JSONObject(d);
        String status = o.getString("status");

        if (status.equals("error")) {
            String message = o.getString("message");
            return message;
        } else {
            String result = o.getString("result");
            return result;
        }

    }

    public String getKeys(String Token) throws UnsupportedEncodingException, IOException {
        String tokenEnc = URLEncoder.encode(Token, "UTF-8");

        //creo la connessione con il metodoto getKeys.php
        String d = download("http://savestrings.netsons.org/SaveStrings/getKeys.php?token=" + tokenEnc);

        JSONObject o = new JSONObject(d);
        String status = o.getString("status");

        if (status.equals("error")) {
            String message = o.getString("message");
            return message;
        } else {
            String result = o.getString("result");
            return result;
        }
    }

}
