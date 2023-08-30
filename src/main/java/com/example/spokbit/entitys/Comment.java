package com.example.spokbit.entitys;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMMENTS")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}
