package com.berry.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "roles")
public class Role {
    @MongoId
    private String _id;
    private String name;
    @Field("guard_name")
    private String guard_name;

}
