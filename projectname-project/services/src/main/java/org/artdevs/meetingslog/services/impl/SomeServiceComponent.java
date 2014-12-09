package org.artdevs.meetingslog.services.impl;

import org.artdevs.meetingslog.services.ServiceComponent;
import org.springframework.stereotype.Component;

/**
 * Created by Artem L.V. on 09.12.14.
 */
@Component("defaultServiceComponent")
public class SomeServiceComponent implements ServiceComponent {

	@Override
	public String getMessage() {
		return "Message from Some Service component";
	}

}
