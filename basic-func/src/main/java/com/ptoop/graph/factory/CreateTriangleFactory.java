package com.ptoop.graph.factory;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.TriangleFigure;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public class CreateTriangleFactory extends AbstractFactory<TriangleFigure> {

    public CreateTriangleFactory(Scanner br) {
        super(br);
    }

    public TriangleFigure create() throws IOException {
        System.out.print("X1 value: ");
        while (!sc.hasNextInt()) sc.next();
        int x1 = sc.nextInt();
        System.out.print("Y1 value: ");
        while (!sc.hasNextInt()) sc.next();
        int y1 = sc.nextInt();
        System.out.print("X2 value: ");
        while (!sc.hasNextInt()) sc.next();
        int x2 = sc.nextInt();
        System.out.print("Y2 value: ");
        while (!sc.hasNextInt()) sc.next();
        int y2 = sc.nextInt();
        System.out.print("X3 value: ");
        while (!sc.hasNextInt()) sc.next();
        int x3 = sc.nextInt();
        System.out.print("Y3 value: ");
        while (!sc.hasNextInt()) sc.next();
        int y3 = sc.nextInt();
        sc.nextLine();
        return new TriangleFigure(x1, y1, x2, y2, x3, y3);
    }
}
