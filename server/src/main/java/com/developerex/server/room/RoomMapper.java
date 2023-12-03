package com.developerex.server.room;

import com.developerex.server.attendee.AttendeeMapper;
import com.developerex.server.term.TermMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RoomMapper {

    public static RoomDto mapToDto(Room room) {
        return RoomDto.builder()
                .title(room.getTitle())
                .description(room.getDescription())
                .deadline(room.getDeadline())
//                .owner(AttendeeMapper.mapToDto(room.getOwner()))
                .terms(room.getTerms()
                        .stream()
                        .map(TermMapper::mapToDto)
                        .collect(Collectors.toList()))
//                .participants(room.getParticipants()
//                        .stream()
//                        .map(AttendeeMapper::mapToDto)
//                        .collect(Collectors.toList()))
                .build();
    }

    public static Room mapToEntity(RoomDto roomDto) {
        return Room.builder()
                .title(roomDto.title())
                .description(roomDto.description())
                .deadline(roomDto.deadline())
                .owner(AttendeeMapper.mapToEntity(roomDto.owner()))
                .terms(roomDto.terms()
                        .stream()
                        .map(TermMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}