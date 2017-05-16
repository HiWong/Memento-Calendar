package com.alexstyl.specialdates.datedetails;

import android.view.View;
import android.widget.FrameLayout;

import com.alexstyl.resources.ColorResources;
import com.alexstyl.resources.StringResources;
import com.alexstyl.specialdates.R;
import com.alexstyl.specialdates.contact.Contact;
import com.alexstyl.specialdates.datedetails.actions.LabeledAction;
import com.alexstyl.specialdates.images.ImageLoader;

import java.util.List;

class CompactDateDetailsViewHolder extends DateDetailsViewHolder {

    private final FrameLayout more;
    private final View cardView;

    CompactDateDetailsViewHolder(View convertView, ImageLoader imageLoader, StringResources strings, ColorResources colors) {
        super(convertView, imageLoader, strings, colors);
        this.cardView = convertView;
        this.more = (FrameLayout) convertView.findViewById(R.id.more_actions);
    }

    @Override
    void bindActionsFor(final Contact contact, final ContactCardListener listener, final List<LabeledAction> actions) {
        if (actions.size() > 0) {
            more.setVisibility(View.VISIBLE);
            more.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onContactActionsMenuClicked(v, contact, actions);
                        }
                    }
            );
        } else {
            more.setVisibility(View.GONE);
        }
    }

    @Override
    public void clearActions() {
        // we are not displaying any actions
    }

}
