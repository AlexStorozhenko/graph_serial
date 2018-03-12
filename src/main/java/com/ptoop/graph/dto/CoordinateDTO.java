package com.ptoop.graph.dto;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class CoordinateDTO {
    private Integer axisX;
    private Integer axisY;

    public CoordinateDTO(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public Integer getAxisX() {
        return axisX;
    }

    public void setAxisX(Integer axisX) {
        this.axisX = axisX;
    }

    public Integer getAxisY() {
        return axisY;
    }

    public void setAxisY(Integer axisY) {
        this.axisY = axisY;
    }
}
