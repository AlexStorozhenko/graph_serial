package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.FigureName;
import com.ptoop.graph.model.base.CoordinateFigure;

import java.util.Arrays;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
public class LineFigure extends CoordinateFigure {

    public LineFigure(int valueX1, int valueY1, int valueX2, int valueY2) {
       super(FigureName.LINE, Arrays.asList(new CoordinateDTO(valueX1, valueY1), new CoordinateDTO(valueX2, valueY2)));
    }

    public LineFigure() {
        super();
    }
}
