package com.company;

import com.company.Items.Catalog;

import java.io.*;

public class CatalogUtil {
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

    public static Catalog load(String path){
        Catalog catalog = null;
        try{
            FileInputStream fileInput = new FileInputStream(path);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            catalog = (Catalog) input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
