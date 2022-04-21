package capstone.laura.youthmatters.youth.resources.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String programs;
    private int zipcode;
    @ManyToMany(targetEntity = ResourceTag.class)
    private Set<ResourceTag> resourceTags;

    public Resource() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrograms() {
        return programs;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setPrograms(String programs) {
        this.programs = programs;
    }

    public Set<ResourceTag> getResourceTags() {
        return resourceTags;
    }

    public void setResourceTags(Set<ResourceTag> resourceTags) {
        this.resourceTags = resourceTags;
    }
}



