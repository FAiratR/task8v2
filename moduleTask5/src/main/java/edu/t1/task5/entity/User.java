package edu.t1.task5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

//@Component
@Entity
@Table(name="USERS")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
//@Validated
public class User {
    //@NotEmpty(message = "id не может быть пустым")
    @Id
    private Long id;
    //@NotEmpty(message = "username не может быть пустым")
    @Column(name="USERNAME")
    private String username;
}
