package com.example.daolayerhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainInfo implements Serializable {

    private String name;
    private String surname;
    private int age;

}
