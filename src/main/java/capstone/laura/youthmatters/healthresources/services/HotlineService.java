package capstone.laura.youthmatters.healthresources.services;

import capstone.laura.youthmatters.healthresources.models.Hotline;

import java.util.List;

public interface HotlineService {

    List<Hotline> getAllHotlineLists();
    void saveHotline(Hotline hotline);
    Hotline getHotlineById(long id);
    void deleteHotlineById(long id);

}
