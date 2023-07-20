package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/Profile.txt");
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(file);
    }
}
