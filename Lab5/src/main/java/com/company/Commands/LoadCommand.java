package com.company.Commands;

import com.company.Items.Catalog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command{

    public LoadCommand(String type, Catalog cat) {
        super(type, cat);
    }

    public static Catalog load(String path){
        Catalog catalog = null;
        try{
            FileInputStream fileInput = new FileInputStream(path);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            catalog = (Catalog) input.readObject();
            input.close();
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
