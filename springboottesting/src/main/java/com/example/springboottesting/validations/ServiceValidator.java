package com.example.springboottesting.validations;

import com.example.springboottesting.model.Customer;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceValidator.class);

    @Autowired
    private KieContainer kieContainer;


    public ValidationErrors validateCustomerRequest(Customer request) {
        KieSession kieSession = kieContainer.newKieSession();
        final ValidationErrors errors = new ValidationErrors();
        kieSession.setGlobal("errors", errors);
        kieSession.insert(request);
        AgendaFilter agendaFilter;
        agendaFilter = match -> match.getRule().getName().startsWith("Customer_Request_Payload");
        kieSession.fireAllRules(agendaFilter);
        kieSession.dispose();

        LOGGER.info("Customer Request Payload  validation result : {}", errors);
        return errors;
    }

    //    public ValidationErrors validateTwilioConvDetails(Customer request) {
    //        KieSession kieSession = kieContainer.newKieSession();
    //        final ValidationErrors errors = new ValidationErrors();
    //        kieSession.setGlobal("errors", errors);
    //
    //        List<TwilioNotificationDetails> twilioNotificationDetailsList = new ArrayList();
    //        request.stream().forEach(detail -> twilioNotificationDetailsList.add(detail));
    //
    //        kieSession.insert(new TwilioConvQueryParam(twilioNotificationDetailsList));
    //        AgendaFilter agendaFilter;
    //        agendaFilter = match -> match.getRule().getName().startsWith("twilio_conversation");
    //        kieSession.fireAllRules(agendaFilter);
    //        kieSession.dispose();
    //
    //        LOGGER.info("validateTwilioConvDetails validation result : {}", errors);
    //        return errors;
    //    }

}
