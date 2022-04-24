package capstone.laura.youthmatters.helplines;

import java.util.List;

public interface HelplineService {

    List<Helpline> getAllHelplineLists();
    void saveHelpline(Helpline helpline);
    Helpline getHelplineById(long id);
    void deleteHelplineById(long id);

}
