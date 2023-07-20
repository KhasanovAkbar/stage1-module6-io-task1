package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                stringBuilder.append((char) ch);
            }

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Profile profile = new Profile();

        String string = stringBuilder.toString();
        String[] split = string.split("\n");

        for (String s : split) {
            String[] split1 = s.split(" ");
            switch (split1[0]) {
                case "Name:":
                    profile.setName(split1[1]);
                    break;
                case "Age:":
                    profile.setAge(Integer.parseInt(split1[1]));
                    break;
                case "Email:":
                    profile.setEmail(split1[1]);
                    break;
                case "Phone:":
                    profile.setPhone(Long.parseLong(split1[1]));
                    break;
            }
        }
        return profile;
    }
}
