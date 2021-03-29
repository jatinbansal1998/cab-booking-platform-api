package org.codejudge.sb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
public class Location implements Serializable {
    private static final long serialVersionUID = 3781905762386369410L;
    @Column(name = "DRIVER_LATITUDE")
    private double latitude;
    @Column(name = "DRIVER_LONGITUDE")
    private double longitude;
}
