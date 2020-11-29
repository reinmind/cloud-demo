package com.reinmind.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MessageStats {
    @JsonProperty("publish")
    private String publish;
    @JsonProperty("publish_in")
    private String publish_in;
    @JsonProperty("publish_out")
    private String publish_out;
    @JsonProperty("confirm")
    private String confirm;
    private String deliver;
    private String deliver_no_ack;
    private String get;
    private String get_no_ack;
    private String deliver_get;
    private String redeliver;
    private String drop_unroutable;
    private String return_unroutable;
}
