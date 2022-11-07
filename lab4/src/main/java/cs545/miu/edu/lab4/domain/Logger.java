package cs545.miu.edu.lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "logers")

public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transactionId;

    LocalDate date;
    String principle;
    String operation;
    Long  time;

}
