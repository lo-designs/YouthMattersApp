package capstone.laura.youthmatters.helplines;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Helpline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String programs;
    private String hours;
    @ManyToMany(targetEntity = Helpline.class)
    private Set<Helpline> helplines;

    public Helpline() {
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

    public void setPrograms(String programs) {
        this.programs = programs;
    }

    public Set<Helpline> getHelplines() {
        return helplines;
    }

    public void setHelplines(Set<Helpline> helplines) {
        this.helplines = helplines;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}

