package works.task.sub.command;

import works.model.URLParameter;
import works.task.sub.GetParameterForNextPage;

public class GetNextPageCommand implements GetParameterCommand {

	private GetParameterForNextPage param;
	
	public GetNextPageCommand(final GetParameterForNextPage param) {
		this.param = param;
	}
	
	@Override
	public URLParameter getParameter() {		
		return param.getNextPageParameter();
	}

}
