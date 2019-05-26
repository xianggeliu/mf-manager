package com.imf.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by JiXiang on 2019/5/24 22:20
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shippers {

    @JsonProperty(value = "ShipperName")
    private String shipperName;

    @JsonProperty(value = "ShipperCode")
    private String shipperCode;

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }
}
