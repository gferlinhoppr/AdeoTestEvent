package adeo.leroymerlin.cdp.band;

import adeo.leroymerlin.cdp.member.MemberDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BandDto {

    private Long id;

    private String name;

    private List<MemberDto> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addMember(MemberDto memberDto){
        if(members == null){
            members = new ArrayList<>();
        }
        members.add(memberDto);
    }

    public List<MemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDto> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
