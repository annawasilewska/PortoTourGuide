package com.example.android.portotourguide;

/**
 * Created by soonsoon on 2017-03-16.
 */

public class PlaceToVisit {
    /** Image resource ID*/
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /** Default translation*/
    private String mPlaceName;

    /** Miwok translation*/
    private String mPlaceAddress;

    /** Additional information about places */
    private String mAdditionalInformation;

    public PlaceToVisit(String placeName, String placeAddress, String additionalInformation) {
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mAdditionalInformation = additionalInformation;

    }

    public PlaceToVisit(String placeName, String placeAddress, String additionalInformation, int imageResourceID) {
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mAdditionalInformation = additionalInformation;
        mImageResourceID = imageResourceID;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceID() {
        return mImageResourceID;
    }

    /**
     * Get the default translation
     */
    public String getPlaceName(){
        return mPlaceName;
    }

    /**
     * Get the Miwok translation
     */
    public String getPlaceAddress(){
        return mPlaceAddress;
    }

    /**
     * Get additional information about places
     */
    public String getAdditionalInformation() {
        return mAdditionalInformation;
    }

    /**
     * Return whether there is or not an image for given word
     */
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
