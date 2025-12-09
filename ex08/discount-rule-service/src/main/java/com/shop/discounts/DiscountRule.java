package com.shop.discounts;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_rules")
public class DiscountRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;          // z.B. "STUDENT10"

    @Column(nullable = false)
    private int percentage;       // ganzzahliger Prozentwert, z.B. 10 für 10 %

    @Enumerated(EnumType.STRING)  // TODO: kurz überlegen, was diese Annotation bewirkt
    @Column(nullable = false)
    private DiscountTarget target;

    protected DiscountRule() {
    }

    public DiscountRule(String code, int percentage, DiscountTarget target) {
        this.code = code;
        this.percentage = percentage;
        this.target = target;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public int getPercentage() {
        return percentage;
    }

    public DiscountTarget getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "DiscountRule [id=" + id + ", code=" + code + ", percentage=" + percentage + ", target=" + target + "]";
    }
}