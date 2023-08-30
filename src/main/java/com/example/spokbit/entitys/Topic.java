package com.example.spokbit.entitys;


import lombok.*;


import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TOPICS")
public class Topic {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAMES")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    private List<Comment> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(id, topic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", comments=" + comments +
                '}';
    }
}
