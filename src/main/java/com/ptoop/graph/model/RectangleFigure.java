package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class RectangleFigure extends CoordinateFigure {

    final private List<CoordinateDTO> fullCoordinateList;

    public RectangleFigure(int valueX1, int valueY1, int valueX2, int valueY2) {
        super(FigureName.RECTANGLE, Arrays.asList(new CoordinateDTO(valueX1, valueY1),
                                                  new CoordinateDTO(valueX2, valueY2)));
        //calculate full rectangle coordinates
        List<CoordinateDTO> fullCoordinateList = Arrays.asList(new CoordinateDTO(valueX1, valueY1),
                                                               new CoordinateDTO(valueX2, valueY2));
        fullCoordinateList.addAll(coordinateList);
        this.fullCoordinateList = fullCoordinateList;
    }

    @Override
    public List<CoordinateDTO> getCoordinateList() {
        return fullCoordinateList;
    }
}
