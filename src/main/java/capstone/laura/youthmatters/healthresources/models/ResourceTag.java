package capstone.laura.youthmatters.healthresources.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResourceTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // ex: remote, 24/7, all-female, low income, lgbtqia+, etc.
    private String type;
    // ex: 1 service, 2 resource, 3 specifications, 4 preferences
    private String category;

    public ResourceTag() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}