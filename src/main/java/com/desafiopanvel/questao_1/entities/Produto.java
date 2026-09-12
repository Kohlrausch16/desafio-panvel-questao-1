package com.desafiopanvel.questao_1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Boolean comprado;

    public UUID getId(){
        return this.id;
    }

    public void setComprado(Boolean comprado){
        this.comprado = comprado;
    }
}
