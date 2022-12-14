package service.dispatcher;

import java.util.List;

public interface DispatcherInterface {

    void valueForInsert();

    void valueForDelete();

    void valueForUpdate();

    List valueForRead();

    List valueForSearch(String... clausule);

}
