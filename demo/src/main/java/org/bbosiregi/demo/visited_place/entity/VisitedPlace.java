package org.bbosiregi.demo.visited_place.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bbosiregi.demo.search.entity.Search;
import org.bbosiregi.demo.user.entity.Users;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="visited_place")
public class VisitedPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "count")
    private Long count;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "search_id")
    private Search search;
}
