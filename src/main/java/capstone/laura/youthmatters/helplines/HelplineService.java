package capstone.laura.youthmatters.helplines;

import java.util.List;

public interface HelplineService {

    List<Helpline> getAllHelplines();
    Helpline getHelplineById(long id);

}
