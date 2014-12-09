package org.artdevs.meetingslog.facades.impl;

import org.artdevs.meetingslog.facades.FacadeComponent;
import org.springframework.stereotype.Component;

/**
 * Created by Artem L.V. on 09.12.14.
 */
@Component("defaultFacadeComponent")
public class SomeFacadeComponent implements FacadeComponent {

	@Override
	public String getMessage() {
		return "Message from Some Facade component";
	}

}
