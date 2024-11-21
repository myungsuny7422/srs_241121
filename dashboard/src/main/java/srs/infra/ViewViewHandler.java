package srs.infra;

import srs.domain.*;
import srs.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ViewViewHandler {

//<<< DDD / CQRS
    @Autowired
    private ViewRepository viewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenResigterPlaced_then_CREATE_1 (@Payload ResigterPlaced resigterPlaced) {
        try {

            if (!resigterPlaced.validate()) return;

            // view 객체 생성
            View view = new View();
            // view 객체에 이벤트의 Value 를 set 함
            view.setSeatId(resigterPlaced.getId());
            // view 레파지 토리에 save
            viewRepository.save(view);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회

                List<View> viewList = viewRepository.findBySeatId(.getId());
                for(View view : viewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    view.setReservedYn(Y);
                    view.setReservedEmployeeId(String.valueOf(.getReservedEmployeeId()));
                    view.setReservedDt(.getReservedDt());
                // view 레파지 토리에 save
                viewRepository.save(view);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSeatReturned_then_UPDATE_2(@Payload SeatReturned seatReturned) {
        try {
            if (!seatReturned.validate()) return;
                // view 객체 조회

                List<View> viewList = viewRepository.findBySeatId(seatReturned.getId());
                for(View view : viewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    view.setReservedYn(N);
                    view.setReservedEmployeeId(  );
                // view 레파지 토리에 save
                viewRepository.save(view);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenUpdateLocationed_then_UPDATE_3(@Payload UpdateLocationed updateLocationed) {
        try {
            if (!updateLocationed.validate()) return;
                // view 객체 조회

                List<View> viewList = viewRepository.findBySeatId(updateLocationed.getId());
                for(View view : viewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    view.setReservedYn(Y);
                // view 레파지 토리에 save
                viewRepository.save(view);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


//>>> DDD / CQRS
}

