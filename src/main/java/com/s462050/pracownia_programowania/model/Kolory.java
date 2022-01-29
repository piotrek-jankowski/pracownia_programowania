package com.s462050.pracownia_programowania.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="KOLORY")
@Getter
@Setter
@NoArgsConstructor
public class Kolory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String nazwaKoloru;
}
