package com.ptoop.graph.command;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.EllipseFigure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public class CreateEllipseCommand extends AbstractCommand<EllipseFigure> {

    public CreateEllipseCommand(BufferedReader br) {
        super(br);
    }

    public EllipseFigure execute() throws IOException {
        System.out.print("Center X value: ");
        int x1 = Integer.parseInt(br.readLine());
        System.out.print("Center Y value: ");
        int y1 = Integer.parseInt(br.readLine());
        System.out.print("A Radius value: ");
        int radA = Integer.parseInt(br.readLine());
        System.out.print("B Radius value: ");
        int radB = Integer.parseInt(br.readLine());
        Map<String, Integer> values = new HashMap<>();
        values.put("a", radA);
        values.put("b", radB);

        return new EllipseFigure(new CoordinateDTO(x1, y1), values);
    }
}
