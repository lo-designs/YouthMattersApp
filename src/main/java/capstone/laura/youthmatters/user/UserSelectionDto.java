package capstone.laura.youthmatters.user;

import java.util.ArrayList;
import java.util.List;

public class UserSelectionDto {

    private List<Long> ids = new ArrayList<>();

    public UserSelectionDto() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "UserSelectionDto{" +
                "ids=" + ids +
                '}';
    }
}
