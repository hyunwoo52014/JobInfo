import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import keywords.EducationName;
import keywords.IndustryCode;
import keywords.JobCategoryCode;
import keywords.JobTypeName;
import keywords.LocalCode;
import view.subContainer.JobTypeNEducation;
import view.subContainer.LocalIndustryJobCategoryCodelist;
import view.subContainer.OptionalItem;
import view.subContainer.SaraminRecruitmentOption;
import works.BackGroundTaskCollection;
import works.model.ResultAllData;
import works.model.URLParameter;
import works.model.sub.PublishedStockOption;
import works.model.sub.RecruitmentList;
import works.model.sub.SortFlagList;
import works.task.GetDataFromAPI;
import works.task.sub.GetFromComponent;
import works.task.sub.GetParameterForNextPage;
import works.task.sub.command.GetInitCommand;
import works.task.sub.command.GetNextPageCommand;


public class TestCase {
	
	private BackGroundTaskCollection backgroundTasks;
	private GetDataFromAPI initFirstAPI;
	
	@Before
	public void init() {
		this.initFirstAPI = new GetDataFromAPI(new GetInitCommand(new GetFromComponent()));
		this.backgroundTasks = BackGroundTaskCollection.getInstance();
	}
	
	@Test
	public void testCase1() {
		assertEquals("erdO5SD8H2ecM7T3gIFRn4DEeSQmipLRvN3pAVPD4xt3yqC", this.initFirstAPI.getApiKey());
	}
	
	@Test
	public void testCase2() throws IOException {
		assertNotNull(this.initFirstAPI.getStreamData());
	}
	
	@Test
	public void testCase3() throws IOException, ParserConfigurationException, SAXException {
		InputStream data = initFirstAPI.getStreamData();
		Document doc = initFirstAPI.getResultXMLFile(data);
		ResultAllData result = initFirstAPI.getTargetData(doc);
		
		assertNotNull(result);
		
		data.close();
	}
	
	@Test
	public void testCase4() {
		String abc = "abc";
		String ccc = null;
		String bcd = "";
		assertNotEquals("abc", abc+null);
		assertNotEquals("abc", abc+ccc);
		assertEquals("abc", abc+"");
		assertEquals("abc", abc+bcd);
	}
	
	
	@Test
	public void testSearchWindowsGetValues() {
		JTextField jtf =  this.backgroundTasks.SearchWindows.SearchTextField;
		jtf.setText("테스트 확인");
		assertEquals("테스트 확인", jtf.getText());
		assertEquals("테스트 확인", this.backgroundTasks.SearchWindows.getSearchWord());
	}

	@Test
	public void testSaraminRecruitmentGetValues() {
		
		SaraminRecruitmentOption testSRO = this.backgroundTasks.SaraminRecruitmentOption;
		
		JRadioButton[] recruitment = testSRO.RecruitMentList;
		JCheckBox[] publishedList = testSRO.GoPublicCheckboxList;
		JCheckBox headhuting = testSRO.HheadHuntingCheckBox;
		
		recruitment[0].setSelected(true);
		
		publishedList[0].setSelected(true);
		publishedList[1].setSelected(true);
		publishedList[2].setSelected(true);
		
		headhuting.setSelected(true);
		
		String expectedStr = "&bbs_gb="+ RecruitmentList.All.getNumberToString()+"&stock="+
							 PublishedStockOption.KOSPI.getNameTag()+"+"+
							 PublishedStockOption.KOSDAQ.getNameTag()+"+"+
							 PublishedStockOption.NASDAQ.getNameTag()+"&sr="+
							"directhire"+"&start=0&count=110";
		
		String a = testSRO.getRecruitmentOptionValue();
		String b = testSRO.getPublicOptionValue();
		String c = testSRO.getHeadHuntingValue();
		
		URLParameter urlparam = new URLParameter.Builder()
				.addRecruitmentOption(a)
				.addStockListingOption(b)
				.addHeadHuntingOrDispatchOption(c)
				.build();
		
		String re = urlparam.getURLParameter();
		
		assertEquals(expectedStr, re);
		
		recruitment[0] = new JRadioButton("모든 채용 공고");;
		
		publishedList[0].setSelected(false);
		publishedList[1].setSelected(false);
		publishedList[2].setSelected(false);
		
		headhuting.setSelected(false);
	}
	
	@Test
	public void testJobNEducationType() {
		JobTypeNEducation jtne = this.backgroundTasks.JobTypeNEducation;
		
		JRadioButton[] jobtype = jtne.Jobtypebuttons;
		ArrayList<JRadioButton> educationtype = jtne.Edubuttons;
		
		jobtype[0].setSelected(true);
		educationtype.get(0).setSelected(true);
		
		String expectedStr = "&start=0&count=110";
		URLParameter urlparam = new URLParameter.Builder()
				.addJobType(jtne.getJobTypeCode())
				.addEducationLevel(jtne.getEduCode())
				.build();
		
		assertEquals(expectedStr, urlparam.getURLParameter());
		
		jobtype[22].setSelected(true);
		educationtype.get(6).setSelected(true);
		
		expectedStr = "&job_type=22&edu_lv=99&start=0&count=110";
		urlparam = new URLParameter.Builder()
				.addJobType(jtne.getJobTypeCode())
				.addEducationLevel(jtne.getEduCode())
				.build();
	
		assertEquals(expectedStr, urlparam.getURLParameter());
		
		jobtype[0].setSelected(false);
		jobtype[22].setSelected(false);
		educationtype.get(0).setSelected(false);
		educationtype.get(6).setSelected(false);
	}
	
	@Test
	public void testLocalIndustryJobCategoryCodelist() {
		LocalIndustryJobCategoryCodelist lijcc = this.backgroundTasks.LocalIndustryJobCategoryCodelist;
		
		JComboBox<String> localCodes = lijcc.LocalCodesComboBox;
		JComboBox<String> industryCodes = lijcc.IndustyCodeComboBox;
		JComboBox<String> jobCategories = lijcc.JobCategoryCodeComboBox;
		
		localCodes.setSelectedItem(LocalCode.L118.getNameTag());
		industryCodes.setSelectedItem(IndustryCode.ind_cd64.getNameTag());
		jobCategories.setSelectedItem(JobCategoryCode.JCC28.getNameTag());
		
		String a = lijcc.getLocalCodes();
		String b = lijcc.getIndustyCodes();
		String c = lijcc.getJobCategoryCodes();
		
		String expectedStr = "107010 1003 314";
		String testStr = a+" "+b+" "+c;
		
		assertEquals(expectedStr, testStr);
		
		localCodes.setSelectedItem(LocalCode.L202.getNameTag());
		industryCodes.setSelectedItem(IndustryCode.ind_cd52.getNameTag());
		jobCategories.setSelectedItem(JobCategoryCode.JCC100.getNameTag());
		
		a = lijcc.getLocalCodes();
		b = lijcc.getIndustyCodes();
		c = lijcc.getJobCategoryCodes();
		
		expectedStr = "111160 703 1002";
		testStr = a+" "+b+" "+c;
		
		assertEquals(expectedStr, testStr);
		
		localCodes.setSelectedItem(LocalCode.LALL.getNameTag());
		industryCodes.setSelectedItem(IndustryCode.ind_cdAll.getNameTag());
		jobCategories.setSelectedItem(JobCategoryCode.JCCALL.getNameTag());
	}

	@Test
	public void testOptionalItem() {
		OptionalItem oi = this.backgroundTasks.OptionalItem;
		
		JComboBox<String> sortItemList = oi.sort;
		
		sortItemList.setSelectedItem(SortFlagList.ReplyCount.getNameTag());
		
		String a = oi.getSortOptionNameTag();
		
		String expectedStr = "re";
		String testStr = a;
		
		assertEquals(expectedStr, testStr);
		
		sortItemList.setSelectedItem(SortFlagList.Default.getNameTag());
		
	}
	
	@Test
	public void testURLParameter() throws UnsupportedEncodingException {
		URLParameter urlp = new URLParameter.Builder().build();
		String str = urlp.getURLParameter();
		String expectedStr = "&start=0&count=110";
		
		assertEquals(expectedStr, str);
		
		urlp = new URLParameter.Builder()
				.addSearchWord("한국어")
				.addIndustyCode(String.valueOf(IndustryCode.ind_cd13.getNumber()))
				.addFields(SortFlagList.ReplyCount.getFlagTag())
				.build();
		
		expectedStr = "&keyword=한국어&ind_cd=207&fields=re&start=0&count=110";
		str = urlp.getURLParameter();
		
		assertEquals(expectedStr, str);
		
		urlp = new URLParameter.Builder()
				.addSearchWord(URLEncoder.encode("이게 되는지 확인해 보는 법", "UTF-8"))
				.addRecruitmentOption(RecruitmentList.All.getNumberToString())
				.addStockListingOption(PublishedStockOption.KOSPI.getNumberToString())
				.addHeadHuntingOrDispatchOption("directhire")
				.addJobType(JobTypeName.JobTypeALL.returnNameTagFromNumber(0))
				.addLocalCode(String.valueOf(LocalCode.L118.getNumber()))
				.addIndustyCode(String.valueOf(IndustryCode.ind_cd58.getNumber()))
				.addJobCategory(String.valueOf(JobCategoryCode.JCC125.getNumber()))
				.addEducationLevel(String.valueOf(EducationName.EDNALL.getNumber()))
				.addFields(SortFlagList.ReverseDeadlineDate.getFlagTag())
				.build();
	}
	
	@Test
	public void previNextOperation() throws UnsupportedEncodingException {
		
		String str = null;
		str = this.initFirstAPI.getParameter();
		assertEquals("&start=0&count=110", str);
		
		ResultAllData data = this.initFirstAPI.getData();
		URLParameter parameter = data.getURLParameter();

		this.initFirstAPI = new GetDataFromAPI(new GetNextPageCommand(new GetParameterForNextPage(parameter)));
		str = this.initFirstAPI.getParameter();
		assertEquals("&start=1&count=110", str);
		
		data = this.initFirstAPI.getData();
		parameter = data.getURLParameter();

	}
	
	@Test
	public void reflectionTest() throws Exception {
		URLParameter urlparam = new URLParameter.Builder().build();
		Field[] fs = urlparam.getClass().getDeclaredFields();
		
		for(int i = 0; i < fs.length; i++) {
			fs[i].setAccessible(true);

			if(fs[i].getName().equalsIgnoreCase("start")) {
				assertEquals(0, fs[i].get(urlparam));
				continue;
			}
			
			if(fs[i].getName().equalsIgnoreCase("count")) {
				assertEquals(110, fs[i].get(urlparam));
				continue;
			}
			
			assertNull(fs[i].get(urlparam));
		}
		
	}

}