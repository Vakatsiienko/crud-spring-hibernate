package com.jrtest.vaka.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

/**
 * @author Iaroslav
 * @since 22.12.2014 21:52
 */
@NoArgsConstructor
@Getter
public class ResponseEntity<T> {
    T rows;
    boolean success;
    long total;

    public ResponseEntity(T rows) {
        this.rows = rows;
        success = true;
    }

    public ResponseEntity(T rows, long total) {
        this.rows = rows;
        this.total = total;
        success = true;
    }
}
