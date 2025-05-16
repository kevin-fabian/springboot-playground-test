package com.fabiankevin.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanetEvent {
    private UUID id;
    private String status;
    private String name;
    private Double weight;
}