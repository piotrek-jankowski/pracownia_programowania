package com.s462050.pracownia_programowania.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="KIEROWCY")
@Getter
@Setter
@NoArgsConstructor
public class Kierowcy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String nazwaKierowcy;
    @ManyToMany
    @JoinTable(name = "Kierowcy_Samochod",
            joinColumns = @JoinColumn(name = "kierowcy_id"),
            inverseJoinColumns = @JoinColumn(name = "samochod_id"))
    private Set<Samochod> samochody = new HashSet<>();
}
