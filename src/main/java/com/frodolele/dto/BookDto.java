package com.frodolele.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {
    public static final long serialVersionUID = -7920527523028716277L;

    private String title;
    private String description;
    private String author;
}
