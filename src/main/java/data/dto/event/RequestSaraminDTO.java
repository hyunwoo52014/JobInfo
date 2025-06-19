package data.dto.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JCheckBox;
import data.dto.api.ApiDTO;
import data.dto.ui.saramin.EducationDTO;
import data.dto.ui.saramin.IndustryCodeDTO;
import data.dto.ui.saramin.JobCodeDTO;
import data.dto.ui.saramin.LocationCodeDTO;
import data.dto.ui.saramin.OccupationCodeDTO;
import data.dto.ui.saramin.SortLabelDTO;
import data.dto.ui.saramin.WorkTypeDTO;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestSaraminDTO extends ApiDTO
{
    String keywords;
    Boolean bbs_gb;
    JCheckBox[] stocks;
    JCheckBox sr;
    WorkTypeDTO job_type;
    EducationDTO edu_lv;
    LocationCodeDTO loc_cd;
    IndustryCodeDTO ind_cd;
    OccupationCodeDTO job_mid_cd;
    JobCodeDTO job_cd;
    JCheckBox[] fields;
    SortLabelDTO sort;
    int start;
    int count;
}