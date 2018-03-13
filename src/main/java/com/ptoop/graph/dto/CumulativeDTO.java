package com.ptoop.graph.dto;

import com.ptoop.graph.model.base.BaseFigure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class CumulativeDTO {

    private List<BaseFigure> figures = new ArrayList<>();

    public List<BaseFigure> getFigures() {
        return figures;
    }

    public void setFigures(List<BaseFigure> figures) {
        this.figures = figures;
    }
}
