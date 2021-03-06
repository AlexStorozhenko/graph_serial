package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.FigureName;
import com.ptoop.graph.model.base.CoordinateFigure;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class RectangleFigure extends CoordinateFigure {

    final private List<CoordinateDTO> fullCoordinateList;

    public RectangleFigure(int valueX1, int valueY1, int valueX2, int valueY2) {
        super(FigureName.RECTANGLE, null);
        //calculate rest rectangle coordinates
        List<CoordinateDTO> fullCoordinateList = Arrays.asList(new CoordinateDTO(valueX1, valueY1),
                                                               new CoordinateDTO(valueX2, valueY2));
        //add initial values
        fullCoordinateList.addAll(Arrays.asList(new CoordinateDTO(valueX1, valueY1),
                                                new CoordinateDTO(valueX2, valueY2)));
        this.fullCoordinateList = fullCoordinateList;
    }

    @Override
    public List<CoordinateDTO> getCoordinateList() {
        return fullCoordinateList;
    }
}
