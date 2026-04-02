package com.example.betting.soobin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sample")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
