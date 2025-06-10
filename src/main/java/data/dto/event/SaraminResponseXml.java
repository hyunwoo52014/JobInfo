// 
// Decompiled by Procyon v0.6.0
// 

package data.dto.event;

import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;
import lombok.Generated;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "job-search")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaraminResponseXml extends ResponseDTO
{
    @XmlElement(name = "jobs")
    private Jobs jobs;
    
    public Jobs getJobs() {
        return this.jobs;
    }
    
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Jobs
    {
        @XmlAttribute private int count;
        @XmlAttribute private int start;
        @XmlAttribute private int total;
        @XmlElement(name = "job") private List<Job> jobList;
 
    }
    
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Job
    {
        private long id;
        private String url;
        private int active;
        @XmlElement(name = "posting-timestamp") private long postingTimestamp;
        @XmlElement(name = "modification-timestamp") private long modificationTimestamp;
        @XmlElement(name = "opening-timestamp") private long openingTimestamp;
        @XmlElement(name = "expiration-timestamp") private long expirationTimestamp;
        @XmlElement(name = "close-type") private CloseType closeType;
        private Company company;
        private Position position;
        private String keyword;
        private Salary salary;
        
    }
    
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CloseType
    {
        @XmlAttribute private int code;
        @XmlValue String value;
    }
    
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Company
    {
        @XmlElement(name = "name") private Name name;
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Name
        {
            @XmlAttribute
            private String href;
            @XmlValue String value;
        }
    }
    
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position
    {
        private Title title;
        private Location location;
        @XmlElement(name = "job-type") private JobType jobtype;
        private Industry industry;
        @XmlElement(name = "job-mid-code") private JobMidCode jobMidCode;
        @XmlElement(name = "job-code") private JobCode jobCode;
        @XmlElement(name = "experience-level") ExperienceLevel experienceLevel;
        @XmlElement(name = "required-education-level") private RequiredEducationLevel requiredEducationLevel;
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Title
        {
            @XmlAttribute private String code;
            @XmlValue String value;
        }
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Location
        {
            @XmlAttribute private String code;
            @XmlValue private String value;
        }
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class JobType
        {
            @XmlAttribute private String code;
            @XmlValue private String value;
        }
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Industry
        {
            @XmlAttribute private String code;
            @XmlValue private String value;

        }
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class JobMidCode
        {
            @XmlAttribute private String code;
            @XmlValue private String value;
        }
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class JobCode
        {
            @XmlAttribute private String code;
            @XmlValue private String value;

        }
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ExperienceLevel
        {
            @XmlAttribute private String code;
            @XmlAttribute private int min;
            @XmlAttribute private int max;
            @XmlValue private String value;

        }
        
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class RequiredEducationLevel
        {
            @XmlAttribute private String code;
            @XmlValue private String value;
        }
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Salary
    {
        @XmlAttribute private String code;
        @XmlValue private String value;
    }
}
