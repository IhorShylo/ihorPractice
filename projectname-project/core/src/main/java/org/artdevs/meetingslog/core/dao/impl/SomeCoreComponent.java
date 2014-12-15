package org.artdevs.meetingslog.core.dao.impl;

import org.artdevs.meetingslog.core.dao.CoreComponent;
import org.springframework.stereotype.Component;

/**
 * Created by Artem L.V. on 09.12.14.
 */
@Component("defaultCoreComponent")
public class SomeCoreComponent implements CoreComponent {

	@Override
	public String getMessage() {
		return "Message from Some Core component";
	}

}
