package com.reinmind.entities;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Customer {
    @Id
    String id;
    String firstName;
    String lastName;
    String phoneNumber;
}
