package works.model;

import java.lang.reflect.Field;


public class URLParameter {
	
	private final String keyword;
	private final String bbs_gb;
	private final String stock;
	private final String sr;
	private final String job_type;
	private final String edu_lv;
	private final String loc_cd;
	private final String ind_cd;
	private final String job_category;
	private final String fields;
	private final Integer start;
	private final Integer count;
	
	public static class Builder {
		
		private String keyword = null;
		private String bbs_gb = null;
		private String stock = null;
		private String sr = null;
		private String job_type = null;
		private String edu_lv = null;
		private String loc_cd = null;
		private String ind_cd = null;
		private String job_category = null;
		private String fields = null;
		private Integer start = 0;
		private Integer count = 110;
		
		public Builder addSearchWord(String param) {
			
			if(param != null) {
				keyword = param;
			} else {
				keyword = null;
			}
			
			return this;
		}
		
		public Builder addRecruitmentOption(String param) {
			
			if(param != null) {
				bbs_gb = param;
			} else {
				bbs_gb = null;
			}
			
			return this;
		}
		
		public Builder addStockListingOption(String param) {
			
			if(param != null) {
				stock = param;
			} else {
				stock = null;
			}
			
			return this;
		}
		
		public Builder addHeadHuntingOrDispatchOption(String param) {
			
			if(param != null) {
				sr = param;
			} else {
				sr = null;
			}
			
			return this;
		}
		
		public Builder addJobType(String param) {
			
			if(param != null) {
				job_type = param;
			} else {
				job_type = null;
			}
			
			return this;
		}
		
		public Builder addEducationLevel(String param) {
			
			if(param != null) {
				edu_lv = param;
			} else {
				edu_lv = null;

			}
			
			return this;
		}
		
		public Builder addLocalCode(String param) {
			
			if(param != null) {
				loc_cd = param;
			} else {
				loc_cd = null;
			}
			
			return this;
		}
		
		public Builder addIndustyCode(String param) {
			
			if(param != null) {
				ind_cd = param;
			} else {
				ind_cd = null;
			}
			
			return this;
		}
		
		public Builder addJobCategory(String param) {
			
			if(param != null) {
				job_category = param;
			} else {
				job_category = null;
			}
			
			return this;
		}
		
		public Builder addFields(String param) {
			
			if(param != null) {
				fields = param;
			} else {
				fields = null;
			}
			
			return this;
		}
		
		public Builder setStart(Integer param) {
			try {

				if(param.intValue() < 0) {
					start = new Integer(0);
					return this;
				}

				start = param.intValue();

				
			} catch(Exception e) {
				start = new Integer(0);
			}

			return this;
		}
		
		public Builder setCount(Integer param) {
			
			try {
				
				if(Integer.valueOf(param) < 0) {
					count = 110;
					return this;
				}
				
				if(Integer.valueOf(param) > 110) {
					count = 110;
					return this;
				}
				
				count = param.intValue();

			} catch (Exception e) {
				count = 110;
			}
			
			return this;
		}

		public URLParameter build() {
			return new URLParameter(this);
		}
	}
	
	private URLParameter(Builder builder) {
		
		 this.keyword = builder.keyword;     
		 this.bbs_gb = builder.bbs_gb;      
		 this.stock = builder.stock;       
		 this.sr = builder.sr;          
		 this.job_type = builder.job_type;    
		 this.edu_lv = builder.edu_lv;      
		 this.loc_cd = builder.loc_cd;      
		 this.ind_cd = builder.ind_cd;      
		 this.job_category = builder.job_category;
		 this.fields = builder.fields;      
		 this.start = builder.start;       
		 this.count = builder.count;
		 
	}
	
	public String getURLParameter() {
		
		String result = "";
		Object temp = null;
		Field[] f = this.getClass().getDeclaredFields();

		try {
			for(int i = 0; i < f.length; i++) {
				
				if(f[i].get(this) == null) {
					continue;
				}
				
				temp = f[i].get(this);
				result += "&"+f[i].getName()+"="+temp;
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getBbs_gb() {
		return bbs_gb;
	}

	public String getStock() {
		return stock;
	}

	public String getSr() {
		return sr;
	}

	public String getJob_type() {
		return job_type;
	}

	public String getEdu_lv() {
		return edu_lv;
	}

	public String getLoc_cd() {
		return loc_cd;
	}

	public String getInd_cd() {
		return ind_cd;
	}

	public String getJob_category() {
		return job_category;
	}

	public String getFields() {
		return fields;
	}

	public int getStart() {
		return start.intValue();
	}

	public int getCount() {
		return count.intValue();
	}

}
