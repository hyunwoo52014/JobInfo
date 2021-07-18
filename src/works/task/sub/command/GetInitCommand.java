package works.task.sub.command;

import java.io.UnsupportedEncodingException;

import works.model.URLParameter;
import works.task.sub.GetFromComponent;

public class GetInitCommand implements GetParameterCommand {

	private GetFromComponent getfromcomponent;
	
	public GetInitCommand(GetFromComponent getfromcomponent) {
		this.getfromcomponent = getfromcomponent;
	}
	
	@Override
	public URLParameter getParameter() {
		try {
			return this.getfromcomponent.returnURLParameter();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
