/*
 * Decompiled with CFR 0.152.
 */
package event;

import data.dto.event.RequestSaraminDTO;
import javax.swing.JCheckBox;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class SaraminRestApiEvent extends ApplicationEvent {
	
    private static final long serialVersionUID = 1975712810907159126L;
    RequestSaraminDTO dto;

    public SaraminRestApiEvent(Object source, RequestSaraminDTO dto) {
        super(source);
        this.dto = dto;
    }

    public String getHeaderValue() {
        return this.dto.getHeaderValue();
    }

    public String apiUrl() {
        int start;
        int cd_job;
        int cd_mid_job;
        int cd_ind;
        int cd_loc;
        StringBuilder builder = new StringBuilder("https://oapi.saramin.co.kr/job-search");
        builder.append("?access-key=" + this.dto.getAccessKey());
        
        if (this.dto.getKeywords() != null && this.dto.getKeywords().length() > 0) {
            builder.append("&keywords=" + this.dto.getKeywords());
        }
        
        if (this.dto.getBbs_gb() != null && this.dto.getBbs_gb().booleanValue()) {
            builder.append("&bbs_gb=1");
        }
        
        String temp = "";
        JCheckBox[] jCheckBoxArray = this.dto.getStocks();
        
        for(JCheckBox stock : jCheckBoxArray) {
        	if (stock.isSelected()) {
                if (((String)temp).length() > 0) {
                    temp = (String)temp + "+";
                }
                temp = (String)temp + String.valueOf(stock.getClientProperty("apiValue"));
            }
        }
        
        if (((String)temp).length() > 0) {
            builder.append("&stock=" + (String)temp);
        }
        
        if (this.dto.getSr().isSelected()) {
            builder.append("&sr=directhire");
        }
        
        if (this.dto.getJob_type() != null) {
            int type_job = this.dto.getJob_type().getCode();
            if (type_job > 0) {
                builder.append("&job_type=" + type_job);
            } else {
                builder.append("&job_type=");
            }
        }
        
        if (this.dto.getEdu_lv() != null) {
            int lv_edu = this.dto.getEdu_lv().getCode();
            if (lv_edu > 0) {
                builder.append("&edu_vl=" + lv_edu);
            } else {
                builder.append("&edu_vl=");
            }
        }
        
        if (this.dto.getLoc_cd() != null && (cd_loc = this.dto.getLoc_cd().getCode()) > 0) {
            builder.append("&loc_cd=" + cd_loc);
        }
        
        if (this.dto.getInd_cd() != null && (cd_ind = this.dto.getInd_cd().getCode()) > 0) {
            builder.append("&ind_cd=" + cd_ind);
        }
        
        if (this.dto.getJob_mid_cd() != null && (cd_mid_job = this.dto.getJob_mid_cd().getCode()) > 0) {
            builder.append("&job_mid_cd=" + cd_mid_job);
        }
        
        if (this.dto.getJob_cd() != null && (cd_job = this.dto.getJob_cd().getCode()) > 0) {
            builder.append("&job_cd=" + cd_job);
        }
        
        temp = "";
        jCheckBoxArray = this.dto.getFields();
        
        for(JCheckBox field : jCheckBoxArray) {
        	if (field.isSelected()) {
                if (((String)temp).length() > 0) {
                    temp = (String)temp + "+";
                }
                temp = (String)temp + String.valueOf(field.getClientProperty("apiValue"));
            }
        }
        
        if (((String)temp).length() > 0) {
            builder.append("&fields=" + (String)temp);
        }
        
        if (this.dto.getSort() != null && (temp = this.dto.getSort().getAbbreviation()) != "" && temp != null) {
            builder.append("&sort=ud");
        }
        
        if ((start = this.dto.getStart()) >= 0) {
            builder.append("&start=" + start);
        } else {
            builder.append("&start=0");
        }
        
        int count = this.dto.getCount();
        
        if (count > 0 && count <= 110) {
            builder.append("&count=" + count);
        } else {
            builder.append("&count=110");
        }
        
        return builder.toString();
    }

    @Generated
    public RequestSaraminDTO getDto() {
        return this.dto;
    }
}

