package com.tpblog.basic.api.entity.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageVO {
    private Integer start;
    // 总页数
    private Integer allPage;
    // 每页显示数量
    private Integer pageNum;
    // 是否还有下一页
    private Boolean hasNextPage;
    private Object data;
}
