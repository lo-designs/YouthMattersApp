package capstone.laura.youthmatters.resources.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Hotline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String hours;
    @ManyToMany(targetEntity = Hotline.class)
    private Set<Hotline> hotlines;

    public Hotline() {
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}

