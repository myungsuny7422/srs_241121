package srs.domain;

import java.util.*;
import lombok.*;
import srs.domain.*;
import srs.infra.AbstractEvent;

@Data
@ToString
public class ReservReturned extends AbstractEvent {

    private Integer id;
    private String employeeId;
    private Integer seatId;
}
