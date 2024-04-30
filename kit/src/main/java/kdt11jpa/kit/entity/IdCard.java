package kdt11jpa.kit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "id_card")
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    @JoinColumn(name="owner_id")
    private Person owner;
}
