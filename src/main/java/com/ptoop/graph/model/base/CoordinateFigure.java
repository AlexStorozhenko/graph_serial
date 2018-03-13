package com.ptoop.graph.model.base;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.FigureName;

import java.util.List;

import static com.ptoop.graph.model.FigureType.COORDINATE;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public abstract class CoordinateFigure extends BaseFigure {

    protected final List<CoordinateDTO> coordinateList;

    //data for point to point figures
    protected CoordinateFigure(FigureName name, List<CoordinateDTO> coordinateList) {
        super(name, COORDINATE);
        this.coordinateList = coordinateList;
    }

    public List<CoordinateDTO> getCoordinateList() {
        return coordinateList;
    }
}
