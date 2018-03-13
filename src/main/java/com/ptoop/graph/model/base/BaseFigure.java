package com.ptoop.graph.model.base;

import com.ptoop.graph.model.FigureName;
import com.ptoop.graph.model.FigureType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
public abstract class BaseFigure implements Serializable {
    protected FigureType type;
    protected FigureName name;
    protected String description;
    protected Date creationDate;

    protected BaseFigure() {
        this.name = null;
        this.type = null;
        this.creationDate = null;
    }

    protected BaseFigure(FigureName name, FigureType type) {
        this.name = name;
        this.type = type;
        this.creationDate = new Date();
    }

    public FigureName getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public FigureType getType() {
        return type;
    }

    public void setType(FigureType type) {
        this.type = type;
    }

    public void setName(FigureName name) {
        this.name = name;
    }
}
