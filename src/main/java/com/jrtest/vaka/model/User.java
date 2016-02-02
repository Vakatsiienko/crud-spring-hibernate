package com.jrtest.vaka.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author Iaroslav
 * @since 20.12.2014 15:34
 */
@Entity(name = "user")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class User extends BaseEntity {
    @Size(max = 50, min = 3, message = "Your name must be between 3 and 50 characters long")
    private String name;
    @Min(value = 0, message = "Minimal age is 0")
    @Max(value = 150, message = "Maximal age is 150")
    private int age;
    private boolean admin;
}
