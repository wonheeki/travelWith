package codingon.travelwith.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class CommentDTO {
    private int c_no;
    private int b_no;
    private String c_writer;
    private Date c_regDate;
    private String c_txt;
}
