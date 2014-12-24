package com.jrtest.vaka.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author Iaroslav
 * @since 20.12.2014 15:34
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class User extends BaseEntity {
    @Size(max = 45)
    private String name;
    @Min(0)
    @Max(150)
    private int age;
    private boolean isAdmin;
}
