package io.arrogantprogrammer.beercitycode;

import io.smallrye.common.annotation.Blocking;
import jakarta.ejb.ApplicationException;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class KafkaResource {

    private static final Logger LOGGER = getLogger(KafkaResource.class);

    @Incoming("registration")
    @Blocking
    public void onRegistration(Attendee attendee) {
        LOGGER.debug("registering: {}", attendee);
        attendee.persist();
    }
}
