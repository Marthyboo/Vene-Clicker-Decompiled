package com.java.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* loaded from: Vene.jar:com/java/loader/Start.class */
public class Start {
    public static void main(String[] strArr) throws IOException {
        int length = strArr.length;
        if (length != 1) {
            System.exit(0);
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://veneclicker.com/api/user/validate_auth_cookie/?cookie=" + strArr[0]).openStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                if (line.contains("\"valid\":true")) {
                    new c();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}