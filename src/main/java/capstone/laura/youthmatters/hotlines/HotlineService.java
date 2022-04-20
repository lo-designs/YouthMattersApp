package capstone.laura.youthmatters.hotlines;

import capstone.laura.youthmatters.hotlines.Hotline;

import java.util.List;

public interface HotlineService {

    List<Hotline> getAllHotlineLists();
    void saveHotline(Hotline hotline);
    Hotline getHotlineById(long id);
    void deleteHotlineById(long id);

}
