package com.domain.entities;

import com.domain.entities.enumerators.RunwayStatus;
import com.domain.entities.enumerators.RunwayType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Runway {

    Integer id;
    String code;
    RunwayStatus runwayStatus;
    RunwayType runwayType;

    public Runway(
            Integer id,
            String code,
            RunwayStatus runwayStatus,
            RunwayType runwayType
    ) {
        this.id = id;
        this.code = code;
        this.runwayStatus = runwayStatus;
        this.runwayType = runwayType;
    }
}
