package adeo.leroymerlin.cdp.band;

import adeo.leroymerlin.cdp.member.MemberMapper;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

public class BandMapper {

    public static BandDto toBandDto(Band band){
        BandDto bandDto = new BandDto();

        bandDto.setMembers(MemberMapper.toMemberDtos(band.getMembers(), null));

        bandDto.setName(band.getName());

        return bandDto;
    }

    public static BandDto toBandDtoWithFilterMember(Band band, String filterMember){
        BandDto bandDto = new BandDto();

        bandDto.setMembers(MemberMapper.toMemberDtos(band.getMembers(), filterMember));
        var memberNumbers = String.format(" [%d]", bandDto.getMembers().size());

        bandDto.setName(band.getName() + memberNumbers);

        return bandDto;
    }

    public static BandDto toBandLightDto(Band band){
        BandDto bandDto = new BandDto();
        bandDto.setName(band.getName());

        return bandDto;
    }

    public static List<BandDto> toBandDtos(Iterable<Band> bands, boolean lightDto) {
        var bandDtos = new LinkedList<BandDto>();
        if(lightDto){
            bands.forEach(band -> bandDtos.add(toBandLightDto(band)));
        }else {
            bands.forEach(band -> {
                bandDtos.add(toBandDto(band));
            });
        }
        return bandDtos;
    }

    public static List<BandDto> toBandDtosWithFilterMember(Iterable<Band> bands, String filterMember) {
        var bandDtos = new LinkedList<BandDto>();
        bands.forEach(band -> {
            BandDto bandDto = toBandDtoWithFilterMember(band, filterMember);
            if(!CollectionUtils.isEmpty(bandDto.getMembers())){
                bandDtos.add(bandDto);
            }
        });

        return bandDtos;
    }

}
