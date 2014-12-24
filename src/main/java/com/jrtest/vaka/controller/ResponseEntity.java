package com.jrtest.vaka.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Iaroslav
 * @since 22.12.2014 21:52
 */
@NoArgsConstructor
@Getter
public class ResponseEntity<T> {
    T content;
    boolean success;

    public ResponseEntity(T content) {
        this.content = content;
        success = true;
    }
}
