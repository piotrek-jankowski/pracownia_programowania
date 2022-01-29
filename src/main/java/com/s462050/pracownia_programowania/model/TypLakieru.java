package com.s462050.pracownia_programowania.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="TYPLAKIERU")
@Getter
@Setter
@NoArgsConstructor
public class TypLakieru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String lakier;
}
