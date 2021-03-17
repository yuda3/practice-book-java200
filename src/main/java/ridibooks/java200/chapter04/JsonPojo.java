package ridibooks.java200.chapter04;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"cp_id", "login_info_no", "name","keta_suu","mask_flg","h_operate_dt","h_user_id","h_site_id","h_syori_sybetu","h_function_cd","h_ip_add","min_keta_suu","allow_character"})
public class JsonPojo {
    private String cp_id;
    private String login_info_no;
    private String name;
    private String keta_suu;
    private String mask_flg;
    private String h_operate_dt;
    private String h_user_id;
    private String h_site_id;
    private String h_syori_sybetu;
    private String h_function_cd;
    private String h_ip_add;
    private String min_keta_suu;
    private String allow_character;


    public JsonPojo(String s, String s1) {
    }
}
