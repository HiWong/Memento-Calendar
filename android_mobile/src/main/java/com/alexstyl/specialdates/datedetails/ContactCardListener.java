package com.alexstyl.specialdates.datedetails;

import android.view.View;

import com.alexstyl.specialdates.contact.Contact;
import com.alexstyl.specialdates.datedetails.actions.LabeledAction;

import java.util.List;

interface ContactCardListener {

    void onCardClicked(Contact contact);

    void onActionClicked(View v, LabeledAction action);

    void onContactActionsMenuClicked(View v, Contact contact, final List<LabeledAction> actions);

}
