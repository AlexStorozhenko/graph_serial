package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;

import java.util.List;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public abstract class CoordinateFigure extends BaseFigure {

    final protected List<CoordinateDTO> coordinateList;

    protected CoordinateFigure(FigureName name, List<CoordinateDTO> coordinateList) {
        super(name);
        this.coordinateList = coordinateList;
    }

    public List<CoordinateDTO> getCoordinateList() {
        return coordinateList;
    }
}
