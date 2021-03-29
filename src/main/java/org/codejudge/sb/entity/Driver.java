package org.codejudge.sb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

import static org.codejudge.sb.constants.JPADataTypeConstants.PHONE_NUMBER;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "DRIVER_DTL")
@SequenceGenerator(name = "default_gen", sequenceName = "DRIVER_DTL_SEQ", allocationSize = 25)
public class Driver extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5284364329643373966L;
    @Column(name = "DRIVER_NAME", nullable = false)
    private String name;
    @Column(name = "DRIVER_EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name = "DRIVER_PHONE_NUMBER", columnDefinition = PHONE_NUMBER, nullable = false, unique = true)
    private Long phoneNumber;
    @Column(name = "DRIVER_LICENCE_NUMBER", nullable = false, unique = true)
    private String licenceNumber;
    @Column(name = "CAR_NUMBER", nullable = false, unique = true)
    private String carNumber;
    @Embedded
    private Location location;
}
