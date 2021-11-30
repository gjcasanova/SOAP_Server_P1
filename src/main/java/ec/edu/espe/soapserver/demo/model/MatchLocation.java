package ec.edu.espe.soapserver.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "MATCH_LOCATION")
@Data
@NoArgsConstructor
public class MatchLocation {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "code", length = 3)
    private String code;

    @Column(name = "availability")
    private Double availability;

    @Column(name = "price")
    private Double price;

    @ManyToOne(optional = false)
    @JoinColumn(name="match_id", nullable = false, updatable = false)
    private SoccerMatch match;
}
