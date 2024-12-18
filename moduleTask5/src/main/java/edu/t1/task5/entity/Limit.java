package edu.t1.task5.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="LIMITS")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Limit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="USERID")
    private Long userId;
    @Column(name="SUMLIMIT")
    private Long sumLimit;
}
