package adeo.leroymerlin.cdp.event;

import adeo.leroymerlin.cdp.band.BandDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDto {

    private Long id;

    private String title;

    private String imgUrl;

    private List<BandDto> bands;

    private Integer nbStars;

    private String comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<BandDto> getBands() {
        return bands;
    }

    public void setBands(List<BandDto> bands) {
        this.bands = bands;
    }

    public void addBand(BandDto bandDto){
        if (bands == null){
            bands = new ArrayList<>();
        }
    }

    public Integer getNbStars() {
        return nbStars;
    }

    public void setNbStars(Integer nbStars) {
        this.nbStars = nbStars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
