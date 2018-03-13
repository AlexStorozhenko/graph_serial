package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.base.CoordinateFigure;

import java.util.Arrays;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class TetragonFigure extends CoordinateFigure {

    public TetragonFigure(int valueX1, int valueY1, int valueX2, int valueY2, int valueX3, int valueY3, int valueX4, int valueY4) {
        super(FigureName.TETRAGON, Arrays.asList(new CoordinateDTO(valueX1, valueY1),
                                             new CoordinateDTO(valueX2, valueY2),
                                             new CoordinateDTO(valueX3, valueY3),
                                             new CoordinateDTO(valueX4, valueY4)));
    }
}
