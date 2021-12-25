package com.mahou.bootjava.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "dish", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "title"},
        name = "dish_unique_menu_title_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Dish extends BaseEntity {

    @Column(name = "title", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String title;

    @NotNull
    @Column(name = "price", nullable = false)
    @Range(min = 10, max = 100000)
    private BigDecimal price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Menu menu;

    public Dish(Integer id, String title, BigDecimal price, Menu menu) {
        super(id);
        this.title = title;
        this.price = price;
        this.menu = menu;
    }
}