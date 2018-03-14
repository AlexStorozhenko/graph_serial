package com.ptoop.graph.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
public abstract class BaseFigure implements Serializable {
    protected String type;
    protected String name;
    protected String description;
    protected Date creationDate;

    protected BaseFigure() {
        this.name = null;
        this.type = null;
        this.creationDate = null;
    }

    protected BaseFigure(String name, String type) {
        this.name = name;
        this.type = type;
        this.creationDate = new Date();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
