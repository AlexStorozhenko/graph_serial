package com.ptoop.graph.command;

import com.ptoop.graph.model.RectangleFigure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public class CreateRectangleCommand extends AbstractCommand<RectangleFigure> {

    public CreateRectangleCommand(BufferedReader br) {
        super(br);
    }

    public RectangleFigure execute() throws IOException {
        System.out.print("X1 value: ");
        int x1 = Integer.parseInt(br.readLine());
        System.out.print("Y1 value: ");
        int y1 = Integer.parseInt(br.readLine());
        System.out.print("X2 value: ");
        int x2 = Integer.parseInt(br.readLine());
        System.out.print("Y2 value: ");
        int y2 = Integer.parseInt(br.readLine());
        return new RectangleFigure(x1, y1, x2, y2);
    }
}
