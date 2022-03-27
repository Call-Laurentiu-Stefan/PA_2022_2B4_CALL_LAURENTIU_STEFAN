package com.company;

import java.util.List;

import static com.company.CatalogUtil.*;

public class Main {

    public static void main(String[] args) {
	Item item1 = new Book("The Art of Computer Programming", "d:/books/programming/tacp.ps");
    Item item2 = new Other("The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");

    Catalog catalog = new Catalog("Prototip");
    catalog.add(item1);
    catalog.add(item2);

    save(catalog, "D:\\Test\\Prototip");

    Catalog otherCatalog;
    otherCatalog = load("D:\\Test\\Prototip");
    System.out.println(otherCatalog);
    }
}
