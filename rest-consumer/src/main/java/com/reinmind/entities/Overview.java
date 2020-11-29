package com.reinmind.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Overview {
    @JsonProperty(value = "message_stats")
    private MessageStats messageStats;
    private String rabbitmq_version;
    private List<Map<String,Object>> contexts;
    private List<ExchangeType> exchange_types;
}
