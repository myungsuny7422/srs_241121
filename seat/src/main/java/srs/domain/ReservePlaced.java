package srs.domain;

import java.util.*;
import lombok.*;
import srs.domain.*;
import srs.infra.AbstractEvent;

@Data
@ToString
public class ReservePlaced extends AbstractEvent {

    private Integer id;
    private String employeeId;
    private Integer seatId;
}
