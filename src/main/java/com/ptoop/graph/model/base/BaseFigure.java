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
    protected final FigureType type;
    protected final FigureName name;
    protected String description;
    protected Date creationDate;

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
}
