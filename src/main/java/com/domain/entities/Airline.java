package com.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airline {

    private Integer code;
    private String name;
    private String alliance;
    private String mainHub;

    public Airline(
            Integer code,
            String name,
            String alliance,
            String mainHub
    ) {
        this.code = code;
        this.name = name;
        this.alliance = alliance;
        this.mainHub = mainHub;
    }

    public Airline(
            String name,
            String alliance,
            String mainHub
    ) {
        this.name = name;
        this.alliance = alliance;
        this.mainHub = mainHub;
    }
}
