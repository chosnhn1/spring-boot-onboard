package com.asdf.minilog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;
import lombok.NonNull;

@Data
public class FollowRequestDto {

    @Deprecated(since = "2.0", forRemoval = true)
    @Schema(
            description = "팔로워 ID (이 필드는 더 이상 사용되지 않습니다",
            example = "0",
            requiredMode = RequiredMode.REQUIRED,       // "required" depreciated from 2.2.5: 살펴보자
            deprecated = true)
    private Long followerId;

    @NonNull private Long followeeId;
}
