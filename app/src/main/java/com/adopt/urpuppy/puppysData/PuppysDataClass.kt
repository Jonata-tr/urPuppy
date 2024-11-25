package com.adopt.urpuppy.puppysData

import android.os.Parcel
import android.os.Parcelable

data class PuppysDataClass(
    var puppyImage:Int,
    var puppyName: String,
    var puppyAge: String,
    var puppySex: String,
    var puppyLocation: String,
    var puppyRace: String,
    var petDescription: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString().toString(), parcel.readString().toString(),
        parcel.readString().toString(), parcel.readString().toString(), parcel.readString().toString(), parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(puppyImage)
        parcel.writeString(puppyName)
        parcel.writeString(puppyAge)
        parcel.writeString(puppySex)
        parcel.writeString(puppyLocation)
        parcel.writeString(puppyRace)
        parcel.writeString(petDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PuppysDataClass> {
        override fun createFromParcel(parcel: Parcel): PuppysDataClass {
            return PuppysDataClass(parcel)
        }

        override fun newArray(size: Int): Array<PuppysDataClass?> {
            return arrayOfNulls(size)
        }
    }
}
