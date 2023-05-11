package peaksoft.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_sur_name")
    private String studentSurName;
    @Column(name = "student_phone_number")
    private String studentPhoneNumber;
    @Column(name = "student_age")
    private int studentAge;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;
    @Transient
    private Long groupId;
}
