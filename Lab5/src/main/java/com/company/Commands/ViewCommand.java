package com.company.Commands;

import com.company.Items.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand {
    public ViewCommand(Item item) {
       File file = new File(item.getLocation());
       Desktop desktop = Desktop.getDesktop();
       try{
           desktop.open(file);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
