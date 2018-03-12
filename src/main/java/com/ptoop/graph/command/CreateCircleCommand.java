package com.ptoop.graph.command;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.CircleFigure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public class CreateCircleCommand extends AbstractCommand<CircleFigure> {

    public CreateCircleCommand(BufferedReader br) {
        super(br);
    }

    public CircleFigure execute() throws IOException {
        System.out.print("Center X value: ");
        int x1 = Integer.parseInt(br.readLine());
        System.out.print("Center Y value: ");
        int y1 = Integer.parseInt(br.readLine());
        System.out.print("Radius value: ");
        int rad = Integer.parseInt(br.readLine());
        Map<String, Integer> values = new HashMap<>();
        values.put("r", rad);

        return new CircleFigure(new CoordinateDTO(x1, y1), values);
    }
}
