package edu.t1.task5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.lang.Long;

//@Component
@Entity
@Table(name="PRODUCTS")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
//@Validated
public class Product {
    //@NotEmpty(message = "id не может быть пустым")
    @Id
    private Long id;
    //@NotEmpty(message = "userId не может быть пустым")
    @Column(name="USERID")
    private Long userId;
    //@NotEmpty(message = "accNum не может быть пустым")
    @Column(name="ACCNUM")
    private String accNum;
    //@NotEmpty(message = "balance не может быть пустым")
    @Column(name="BALANCE")
    private Long balance;
    //@NotEmpty(message = "type не может быть пустым")
    @Column(name="TYPE")
    @Enumerated(EnumType.STRING)
    private TypePruduct type;

}
