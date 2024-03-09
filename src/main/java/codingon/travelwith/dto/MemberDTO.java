package codingon.travelwith.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDTO {
    private String u_id;
    private String u_pw;
    private String u_nickname;
    private String u_email;
    private String u_addr;
}
