package com.s462050.pracownia_programowania.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="SAMOCHOD")
@Getter
@Setter
@NoArgsConstructor
public class Samochod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String marka;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private boolean uzywany;
    @ManyToOne
    private TypLakieru typLakieru;
    @OneToMany
    @JoinColumn(name = "kolory_id")
    private Set<Kolory> kolory;
}
