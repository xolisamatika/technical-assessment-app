package com.example.technicalassessmentapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Directory {
    String fullPath;
    Map<String, Object> attributeInformation;
}
