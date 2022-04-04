package com.company.Commands;

import com.company.Items.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand {
    public static void save(Catalog catalog, String path) {
        String name = catalog.getName();
        try{
            FileOutputStream fileOutput = new FileOutputStream(path);
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(catalog);
            output.close();
            fileOutput.close();
            System.out.println("Path for catalog is:" + path + "'\'" + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
