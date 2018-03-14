package com.ptoop.graph.factory;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.DottedCircleFigure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public class CreateDottedCircleFactory extends AbstractFactory<DottedCircleFigure> {

    public CreateDottedCircleFactory(Scanner br) {
        super(br);
    }

    public DottedCircleFigure create() throws IOException {
        System.out.print("Center X value: ");
        while (!sc.hasNextInt()) sc.next();
        int x1 = sc.nextInt();
        System.out.print("Center Y value: ");
        while (!sc.hasNextInt()) sc.next();
        int y1 = sc.nextInt();
        System.out.print("Radius value: ");
        while (!sc.hasNextInt()) sc.next();
        int rad = sc.nextInt();
        Map<String, Integer> values = new HashMap<>();
        values.put("r", rad);
        sc.nextLine();
        return new DottedCircleFigure(new CoordinateDTO(x1, y1), values);
    }
}
