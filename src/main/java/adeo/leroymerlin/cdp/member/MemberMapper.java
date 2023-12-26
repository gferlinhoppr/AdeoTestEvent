package adeo.leroymerlin.cdp.member;

import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class MemberMapper {

    public static MemberDto toMemberDto(Member member){

        MemberDto memberDto = new MemberDto();
        memberDto.setName(member.getName());

        return memberDto;
    }

    public static List<MemberDto> toMemberDtos(Iterable<Member> members, String filterMember){

        var memberDtos = new LinkedList<MemberDto>();

        var emptyFilter = filterMember == null
                || StringUtils.trimAllWhitespace(filterMember).isEmpty();

        members.forEach(member -> {
            if(emptyFilter
                    || member.getName().toLowerCase().contains(filterMember.toLowerCase())) {
                memberDtos.add(toMemberDto(member));
            }
        });

        return memberDtos;
    }

}
