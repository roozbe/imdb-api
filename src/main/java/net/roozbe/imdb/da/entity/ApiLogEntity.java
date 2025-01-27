package net.roozbe.imdb.da.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "api_logs")
@SequenceGenerator(name = "sq_api_logs",sequenceName = "sq_api_logs",allocationSize = 1)
@Data
public class ApiLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_api_logs")
    private Long id;

    @Column(name = "http_method")
    private String httpMethod;

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "status_code")
    private int statusCode;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
