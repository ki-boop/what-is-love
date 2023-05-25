package com.example.hackatonrowi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StompEvent<T> {
    String name;
    T payload;
}
