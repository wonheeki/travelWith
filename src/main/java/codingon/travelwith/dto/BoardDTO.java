package codingon.travelwith.dto;

import codingon.travelwith.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class BoardDTO {
//    private int b_rn;
    private int b_no;
    private String b_title;
    private String u_id;
    private String b_writer;
    private String b_photo;
    private String b_category;
    private String b_txt;
    private Date b_regDate;
    private int b_readCounter;
    private List<Comment> b_comment;
}
