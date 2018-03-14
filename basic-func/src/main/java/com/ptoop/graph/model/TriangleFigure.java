package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.FigureName;
import com.ptoop.graph.model.base.CoordinateFigure;

import java.util.Arrays;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class TriangleFigure extends CoordinateFigure {

    public TriangleFigure() {
        super();
    }

    public TriangleFigure(int valueX1, int valueY1, int valueX2, int valueY2 , int valueX3, int valueY3) {
        super(FigureName.TRIANGLE, Arrays.asList(new CoordinateDTO(valueX1, valueY1),
                                             new CoordinateDTO(valueX2, valueY2),
                                             new CoordinateDTO(valueX3, valueY3)));
    }
}
