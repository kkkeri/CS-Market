package ru.itmo.backend.model;

import jakarta.persistence.*;
import lombok.*;
import ru.itmo.backend.model.enums.RentalContractStatus;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "rental_contracts")
public class RentalContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price_per_day", nullable = false)
    private Integer pricePerDay;

    @Column(name = "max_days", nullable = false)
    private Integer maxDays;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 64)
    private RentalContractStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_listing_id")
    private RentalListing rentalListing;
}