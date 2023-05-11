package peaksoft.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_sur_name")
    private String teacherSurName;
    @Column(name = "teacher_phone_number")
    private String teacherPhoneNumber;
    @Column(name = "teacher_age")
    private int teacherAge;
    @Transient
    private Long courseId;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Course course;
}
