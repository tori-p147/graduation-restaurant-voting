package com.github.mahou147.voting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "address"},
        name = "restaurants_unique_address_idx")})
public class Restaurant extends BaseEntity {

    @NotBlank
    @Column(name = "title", nullable = false)
    @Size(max = 128)
    private String title;

    @NotBlank
    @Column(name = "address", nullable = false, unique = true)
    @Size(max = 128)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Set<Menu> menus;

    public Restaurant(Integer id, String title, String address, String phone) {
        super(id);
        this.title = title;
        this.address = address;
        this.phone = phone;
    }
}

