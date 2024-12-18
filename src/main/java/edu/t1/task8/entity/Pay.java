package edu.t1.task8.entity;

import jakarta.persistence.*;
import lombok.*;

//@Component
@Entity
@Table(name="PAYS")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Pay {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long Id;
    @Column(name="PRODUCT")
    Long product;
    @Column(name="COUNT")
    Long count;
    @Column(name="USERID")
    Long user;
}
