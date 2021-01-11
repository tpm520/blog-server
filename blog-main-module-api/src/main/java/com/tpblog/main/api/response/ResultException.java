package com.tpblog.main.api.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResultException {
    private String url;
    private String method;
    private int code;
    private String message;
}
