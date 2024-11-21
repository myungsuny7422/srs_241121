package srs.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import srs.ReserveApplication;
import srs.domain.ReservReturned;
import srs.domain.ReserveCancelled;
import srs.domain.ReservePlaced;

@Entity
@Table(name = "Reserve_table")
@Data
//<<< DDD / Aggregate Root
public class Reserve {

    @Id
    private Integer id;

    private String employeeId;

    private Integer seatId;

    @PostPersist
    public void onPostPersist() {
        ReservePlaced reservePlaced = new ReservePlaced(this);
        reservePlaced.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        ReservReturned reservReturned = new ReservReturned(this);
        reservReturned.publishAfterCommit();

        ReserveCancelled reserveCancelled = new ReserveCancelled(this);
        reserveCancelled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static ReserveRepository repository() {
        ReserveRepository reserveRepository = ReserveApplication.applicationContext.getBean(
            ReserveRepository.class
        );
        return reserveRepository;
    }
}
//>>> DDD / Aggregate Root
