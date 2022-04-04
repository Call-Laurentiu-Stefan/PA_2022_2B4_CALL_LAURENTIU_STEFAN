package com.company;

import com.company.Commands.*;
import com.company.Exceptions.*;
import com.company.Items.*;

import java.io.File;
import java.util.Scanner;

import static com.company.CatalogUtil.*;

        public class Main {
            public static void main(String[] args) {
                Exception ex = new Exception();
                Catalog cat = new Catalog();
                String name,path, type;
                Scanner scan = new Scanner(System.in);
                System.out.println("Catalog name:");
                cat.setName(scan.nextLine());
                while (true) {
                    System.out.print("Enter command: ");
                    String command = scan.nextLine();
                    String[] arguments = command.split(" ");
                    try {
                        if (arguments.length > 1)
                            throw new InvalidCommandException(ex);
                        switch (arguments[0].toLowerCase()) {
                            case "add" -> {
                                System.out.println("Type:");
                                type = scan.nextLine();
                                System.out.println("Enter a name:");
                                name = scan.nextLine();
                                System.out.println("Enter a path:");
                                path = scan.nextLine();
                                try {
                                    File file = new File(path);
                                    if (!file.exists())
                                        throw new InvalidPathException(ex);
                                } catch (InvalidPathException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                switch (type.toLowerCase()) {
                                    case "book" -> {
                                        Item book = new Book(name, path);
                                        AddCommand.add(cat, book);
                                    }
                                    case "other" -> {
                                        Item other = new Other(name, path);
                                        AddCommand.add(cat, other);
                                    }
                                    default -> throw new InvalidTypeException(ex);
                                }
                                System.out.println("Added");
                            }
                            case "save" -> {
                                System.out.println("Enter a path:");
                                path = scan.nextLine();
                                try {
                                    File file = new File(path);
                                    if (!file.exists())
                                        throw new InvalidPathException(ex);
                                    SaveCommand.save(cat, path);
                                } catch (InvalidPathException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case "list" -> {
                                ListCommand.list(cat);
                            }
                            case "load" -> {
                                System.out.println("Enter a path:");
                                path = scan.nextLine();
                                try {
                                    File file = new File(path);
                                    if (!file.exists())
                                        throw new InvalidPathException(ex);
                                    cat = LoadCommand.load(path);
                                } catch (InvalidPathException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case "report" -> {
                                ReportCommand.report(cat);
                            }
                            case "quit" -> System.exit(0);
                            default -> throw new InvalidCommandException(ex);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
