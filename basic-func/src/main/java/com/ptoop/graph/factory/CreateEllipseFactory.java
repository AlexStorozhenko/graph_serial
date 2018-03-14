package com.ptoop.graph.factory;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.EllipseFigure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public class CreateEllipseFactory extends AbstractFactory<EllipseFigure> {

    public CreateEllipseFactory(Scanner sc) {
        super(sc);
    }

    public EllipseFigure create() throws IOException {
        System.out.print("Center X value: ");
        while (!sc.hasNextInt()) sc.next();
        int x1 = sc.nextInt();
        System.out.print("Center Y value: ");
        while (!sc.hasNextInt()) sc.next();
        int y1 = sc.nextInt();
        System.out.print("A Radius value: ");
        while (!sc.hasNextInt()) sc.next();
        int radA = sc.nextInt();
        System.out.print("B Radius value: ");
        while (!sc.hasNextInt()) sc.next();
        int radB = sc.nextInt();
        Map<String, Integer> values = new HashMap<>();
        values.put("a", radA);
        values.put("b", radB);
        sc.nextLine();
        return new EllipseFigure(new CoordinateDTO(x1, y1), values);
    }
}
