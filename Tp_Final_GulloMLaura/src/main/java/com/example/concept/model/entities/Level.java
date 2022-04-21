package com.example.concept.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "level")
@NoArgsConstructor
@Data
public class Level implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idLevel;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Chapter> chapters=new ArrayList<Chapter>();

}
