package com.alexstyl.specialdates.contact;

import android.net.Uri;

import com.alexstyl.specialdates.DisplayName;

public abstract class Contact {

    protected final long contactID;
    protected final DisplayName displayName;

    public Contact(long id, DisplayName displayName) {
        this.contactID = id;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName.toString();
    }

    public long getContactID() {
        return contactID;
    }

    public DisplayName getDisplayName() {
        return displayName;
    }

    public String getGivenName() {
        return displayName.getFirstNames().getPrimary();
    }

    public abstract Uri getLookupUri();

    /**
     * Returns the image path of the avatar of this contact
     */
    public abstract Uri getImagePath();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contact contact = (Contact) o;

        return contactID == contact.contactID;

    }

    @Override
    public int hashCode() {
        return (int) (contactID ^ (contactID >>> 32));
    }
}
