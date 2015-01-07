package com.jrtest.vaka.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author Iaroslav
 * @since 07.01.2015 21:43
 */
@AllArgsConstructor
@Getter
public class Page<T> {
    private List<T> content;
    private long total;
}
