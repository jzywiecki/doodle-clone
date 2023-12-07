package com.developerex.server.attendee.model;

import com.developerex.server.room.model.Room;
import com.developerex.server.vote.model.Vote;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "participants", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST})
    @JsonBackReference
    private Set<Room> participationRooms;

    @OneToMany(mappedBy = "owner")
    @JsonBackReference
    private List<Room> ownedRooms;

    @OneToMany(mappedBy = "attendee")
    @JsonBackReference
    private List<Vote> votes;

    public void addParticipationRoom(Room room) {
        this.participationRooms.add(room);
    }

    public void addOwnedRoom(Room room) {
        this.ownedRooms.add(room);
    }

}
