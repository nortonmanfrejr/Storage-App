package service.dispatcher.conveyor;

import java.util.List;

public interface ConveyorInterface {

    void insert();
    void update();
    void delete();

    List read();

    List search();
}
