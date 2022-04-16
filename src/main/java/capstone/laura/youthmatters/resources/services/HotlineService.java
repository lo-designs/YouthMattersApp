package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.Hotline;

import java.util.List;

public interface HotlineService {

    List<Hotline> getAllHotlineLists();
    void saveHotline(Hotline hotline);
    Hotline getHotlineById(long id);
    void deleteHotlineById(long id);

}
