package com.alibaba.xinan.sirs.entity.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2019/2/12 16:26
 */
@Data
@Builder
public class PageVO<T> implements Serializable {

    private static final long serialVersionUID = -5019555805376736497L;

    private Long totalPages;

    private Integer pageSize;

    private Integer pageNum;

    private List<T> list;
}
