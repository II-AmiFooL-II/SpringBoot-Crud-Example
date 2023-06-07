package com.JavaCrud.RestApiExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Server")
public class Server {
    @Id
    private int id;
    private String name;
    private String language;
    private String framework;
}
