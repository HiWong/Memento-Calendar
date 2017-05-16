package com.alexstyl.specialdates.datedetails;

import android.content.ContentResolver;

import com.alexstyl.specialdates.contact.Contact;
import com.alexstyl.specialdates.datedetails.actions.ContactActionFactory;
import com.alexstyl.specialdates.datedetails.actions.LabeledAction;
import com.alexstyl.specialdates.util.ContactUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactActionsFactory {

    private final ContentResolver resolver;

    public ContactActionsFactory(ContentResolver resolver) {
        this.resolver = resolver;
    }

    protected List<LabeledAction> buildActionsFor(Contact contact) {
        long contactID = contact.getContactID();
        boolean hasPhoneNumber = ContactUtils.hasPhoneNumber(resolver, contactID);
        List<LabeledAction> actions = new ArrayList<>(2);
        if (hasPhoneNumber) {
            actions.add(ContactActionFactory.get().createCallAction(contactID));
            actions.add(ContactActionFactory.get().createSMSAction(contactID));
        }

        boolean hasEmails = ContactUtils.hasEmail(resolver, contactID);
        if (hasEmails) {
            actions.add(ContactActionFactory.get().createEmailAction(contactID));
        }

        return actions;
    }
}
