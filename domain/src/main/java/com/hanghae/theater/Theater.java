package com.hanghae.theater;

import com.hanghae.common.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Theater extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "theater_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_screening_to_theater")
    )
    private List<Screening> screenings = new ArrayList<>();

    protected Theater() {
    }

    public Theater(String name) {
        this(null, name);
    }

    public Theater(Long id, String name) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "상영관 이름을 입력하세요");
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public void addScreenings(List<Screening> screenings) {
        screenings.forEach(this::addScreening);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }
}
