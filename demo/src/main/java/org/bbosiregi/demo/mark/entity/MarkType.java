package org.bbosiregi.demo.mark.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MarkType {
    ELEVATOR("엘리베이터");
    private final String name;
}
