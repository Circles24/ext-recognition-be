package com.circles24.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationInfoDto {
    private long pageCount;
    private long pageSize;
}
