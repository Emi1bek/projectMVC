package peaksoft.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "data_of_start")
    private String dataOfStart;
    @Column(name = "data_of_finished")
    private String dataOfFinished;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "groups_courses",
    joinColumns =  @JoinColumn(name = "groups_id"),
    inverseJoinColumns =  @JoinColumn(name = "course_id"))
    private List<Course> courses;
    @Transient
    private Long coursId;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
//    private List<Teacher> teachers;
//    @Transient
//    private Long teacherId;
}
