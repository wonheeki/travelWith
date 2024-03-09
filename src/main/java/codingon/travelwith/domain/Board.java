package codingon.travelwith.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {
    private int b_no;
    private String b_title;
    private String b_writer;
    private String b_photo;
    private String b_category;
    private String b_txt;
    private Date b_regDate;
    private int b_readCounter;
}
