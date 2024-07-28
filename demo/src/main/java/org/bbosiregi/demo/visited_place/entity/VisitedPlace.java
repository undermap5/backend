package org.bbosiregi.demo.visited_place.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bbosiregi.demo.location.entity.Location;
import org.bbosiregi.demo.search.entity.Search;
import org.bbosiregi.demo.user.entity.User;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "search_id")
    private Search search;
}
