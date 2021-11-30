package ec.edu.espe.soapserver.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SOCCER_MATCH")
@Data
@NoArgsConstructor
public class SoccerMatch {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @Column(name = "local_team", length = 64)
    private String localTeam;

    @Column(name = "visiting_team", length = 64)
    private String visitingTeam;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "site", length = 128)
    private String site;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<MatchLocation> locations;
}
