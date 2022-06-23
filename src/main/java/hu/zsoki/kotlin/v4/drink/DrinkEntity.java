package hu.zsoki.kotlin.v4.drink;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "DRINK")
public class DrinkEntity {

    @Column
    @Id
    private String name;

    @Column
    private LocalDateTime edited;

    @Column
    private Double price;

    @Column
    private Double capacity;

    @Column
    private Double percent;

    @Column
    private Double efficiency;

    public DrinkEntity() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Double index) {
        this.efficiency = index;
    }

}
