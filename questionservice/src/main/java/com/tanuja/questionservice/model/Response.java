package com.tanuja.questionservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response;
}
