package no.noroff.tidsbankenbackend.mappers;

import no.noroff.tidsbankenbackend.model.Comment;
import no.noroff.tidsbankenbackend.model.IneligiblePeriod;
import no.noroff.tidsbankenbackend.model.Users;
import no.noroff.tidsbankenbackend.model.VacationRequest;
import no.noroff.tidsbankenbackend.model.dto.users.UsersGetDTO;
import no.noroff.tidsbankenbackend.model.dto.users.UsersPostDTO;
import no.noroff.tidsbankenbackend.model.dto.users.UsersPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(target = "comments", qualifiedByName = "commentToCommentId")
    @Mapping(
            target = "createdIneligiblePeriods",
            qualifiedByName = "ineligiblePeriodToIneligiblePeriodId"
    )
    @Mapping(
            target = "vacationRequests",
            qualifiedByName = "vacationRequestToVacationRequestId"
    )
    @Mapping(
            target = "administeredVacationRequests",
            qualifiedByName = "vacationRequestToVacationRequestId"
    )
    UsersGetDTO usersToUsersGetDto(Users user);

    Collection<UsersGetDTO> usersToUsersGetDto(Collection<Users> users);

    Users usersPostDtoToUsers(UsersPostDTO usersPostDTO);

    Users usersPutDtoToUsers(UsersPutDTO usersPutDTO);


    @Named(value = "commentToCommentId")
    default Set<Integer> mapComments(Set<Comment> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }

    @Named(value = "ineligiblePeriodToIneligiblePeriodId")
    default Set<Integer> mapIneligiblePeriods(Set<IneligiblePeriod> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }

    @Named(value = "vacationRequestToVacationRequestId")
    default Set<Integer> mapVacationsRequests(Set<VacationRequest> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
