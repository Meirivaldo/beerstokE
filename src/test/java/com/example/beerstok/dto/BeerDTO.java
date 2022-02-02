package com.example.beerstok.dto;

import com.example.beerstok.enums.BeerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

public class BeerDTO {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class beerDTO {

        private Long id;

        @NotNull
        @Size(min = 1, max = 200)
        private String name;

        @NotNull
        @Size(min = 1, max = 200)
        private String brand;

        @NotNull
        @Max(500)
        private Integer max;

        @NotNull
        @Max(100)
        private Integer quantity;

        @Enumerated(EnumType.STRING)
        @NotNull
        private BeerType type;
}
