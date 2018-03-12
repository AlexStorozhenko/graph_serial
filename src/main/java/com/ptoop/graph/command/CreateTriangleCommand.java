package com.ptoop.graph.command;

import com.ptoop.graph.model.TriangleFigure;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public class CreateTriangleCommand extends AbstractCommand<TriangleFigure> {

    public CreateTriangleCommand(BufferedReader br) {
        super(br);
    }

    public TriangleFigure execute() throws IOException {
        System.out.print("X1 value: ");
        int x1 = Integer.parseInt(br.readLine());
        System.out.print("Y1 value: ");
        int y1 = Integer.parseInt(br.readLine());
        System.out.print("X2 value: ");
        int x2 = Integer.parseInt(br.readLine());
        System.out.print("Y2 value: ");
        int y2 = Integer.parseInt(br.readLine());
        System.out.print("X3 value: ");
        int x3 = Integer.parseInt(br.readLine());
        System.out.print("Y3 value: ");
        int y3 = Integer.parseInt(br.readLine());
        return new TriangleFigure(x1, y1, x2, y2, x3, y3);
    }
}
