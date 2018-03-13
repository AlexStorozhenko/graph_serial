package com.ptoop.graph.factory;

import com.ptoop.graph.model.base.BaseFigure;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public abstract class AbstractFactory<T extends BaseFigure> {
    protected Scanner sc;
    public AbstractFactory(Scanner sc) {
        this.sc = sc;
    }
    abstract public T create() throws IOException;

    //basic figure update method
    public T update(T baseFigure) throws IOException {
        System.out.print("Enter new description: ");
        String descr = sc.nextLine();
        baseFigure.setDescription(descr);
        System.out.print("Update creation date? (Y for yes): ");
        if (sc.nextLine().toUpperCase().equals("Y")) {
            baseFigure.setCreationDate(new Date());
        }
        return baseFigure;
    }
}
