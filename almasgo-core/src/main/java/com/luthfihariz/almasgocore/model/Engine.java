package com.luthfihariz.almasgocore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luthfihariz.almasgocore.model.enums.EngineType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Engine {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 48)
    private String name;

    @Column(length = 1)
    private Integer active;

    private EngineType type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Engine(String name, EngineType type) {
        this.name = name;
        this.type = type;
        this.active = 1;
    }
}