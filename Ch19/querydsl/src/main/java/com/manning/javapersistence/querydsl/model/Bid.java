 package com.manning.javapersistence.querydsl.model;

import com.manning.javapersistence.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @Getter
    @Setter
    private BigDecimal amount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private User user;

    public Bid(BigDecimal amount) {
        this.amount = amount;
    }

}
