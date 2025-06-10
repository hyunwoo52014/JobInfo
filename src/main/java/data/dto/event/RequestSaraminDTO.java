package data.dto.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import data.dto.ui.SortLabelDTO;
import data.dto.ui.JobCodeDTO;
import data.dto.ui.OccupationCodeDTO;
import data.dto.ui.IndustryCodeDTO;
import data.dto.ui.LocationCodeDTO;
import data.dto.ui.EducationDTO;
import data.dto.ui.WorkTypeDTO;
import javax.swing.JCheckBox;
import data.dto.api.ApiDTO;

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