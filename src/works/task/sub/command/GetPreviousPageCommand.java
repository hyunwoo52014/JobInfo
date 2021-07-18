package works.task.sub.command;

import works.model.URLParameter;
import works.task.sub.GetParameterForPreviousPage;

public class GetPreviousPageCommand implements GetParameterCommand {

	private GetParameterForPreviousPage param;
	
	public GetPreviousPageCommand(final GetParameterForPreviousPage param) {
		this.param = param;
	}
	
	@Override
	public URLParameter getParameter() {
		return param.getPreviousPageParameter();
	}

}
