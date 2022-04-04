package com.company.Commands;

import com.company.Items.Catalog;
import com.company.Items.Item;
import com.company.Items.Other;
import freemarker.template.Template;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command{

    public ReportCommand(String type, Catalog cat) {
        super(type, cat);
    }

    public static void report(Catalog cat) throws IOException{
        Configuration config = new Configuration();
        config.setDirectoryForTemplateLoading(new File("D:\\TestLab5"));
        HashMap<String, Object>report = new HashMap<>();
        report.put("name",cat.getName());
        report.put("items",cat.getItems());
        Template template = config.getTemplate("template.html");
        Writer write = new FileWriter("D:\\"+cat.getName()+".html");
        try{
            template.process(report,write);
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            write.close();
        }
        Item raport = new Other(cat.getName(), "D:\\"+cat.getName()+".html");
        new ViewCommand(raport);
    }
}
