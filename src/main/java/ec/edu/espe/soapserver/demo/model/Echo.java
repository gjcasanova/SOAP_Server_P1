package ec.edu.espe.soapserver.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "ECHO")
@Data
@NoArgsConstructor
public class Echo {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "echo_id")
    private Long id;

    @Column(name = "echo_type", length = 64)
    private String echoType;

    @Column(name = "message", length = 128)
    private String message;
}
