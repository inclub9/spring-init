package co.autopair.spring.entity.dao;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDAO {
    Integer id;
    String nickName;
    String firstName;
    String lastName;
    String position;
    Member leader = null;
    Team team;
    Address address;
}
