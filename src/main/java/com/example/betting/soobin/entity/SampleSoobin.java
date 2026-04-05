package com.example.betting.soobin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "samplesoobin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SampleSoobin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
