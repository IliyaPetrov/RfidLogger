package org.rfid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by zlatan on 02.08.16.
 */
@Component
public class ReportResourceProcessor implements ResourceProcessor<RepositoryLinksResource> {

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(ControllerLinkBuilder.linkTo(ReportController.class).slash("$rfid").slash("$date").withRel("report"));
        resource.add(ControllerLinkBuilder.linkTo(ReportController.class).withRel("report"));
        return resource;
    }

}
